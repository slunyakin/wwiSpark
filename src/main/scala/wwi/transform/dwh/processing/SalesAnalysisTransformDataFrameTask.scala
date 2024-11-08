package wwi.transform.dwh.processing

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
object SalesAnalysisTransformDataFrameTask {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("SalesAnalysisTransformation")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    // Load DataFrames
    val factOrderDF = sparkSession.read.option("header", "true").csv("/Users/slunyakin/Downloads/WWIDW/Orders.csv")
    val dimCustomerDF = sparkSession.read.option("header", "true").csv("/Users/slunyakin/Downloads/WWIDW/Customers.csv")
    val dimDateDF = sparkSession.read.option("header", "true").csv("/Users/slunyakin/Downloads/WWIDW/Date.csv")

    // Join FactOrder with DimDate and DimCustomer
    val joinedDF = factOrderDF
      .join(dimDateDF, factOrderDF("orderDateKey") === dimDateDF("dateKey"), "left")
      .join(dimCustomerDF, factOrderDF("customerKey") === dimCustomerDF("customerKey"), "left")

    // Step 1: Calculate monthly metrics and ranking within each month
    val monthlyMetricsDF = joinedDF
      .groupBy("calendarYear", "month", "calendarMonthNumber", "customer")
      .agg(
        sum("quantity").alias("TotalOrderQuantity"),
        sum("totalExcludingTax").alias("TotalOrderValue"),
        countDistinct("orderKey").alias("TotalOrders"),
        avg("totalExcludingTax").alias("AvgOrderValue")
      )
      .withColumn("OrderValueRank",
        row_number().over(Window.partitionBy("calendarYear", "calendarMonthNumber").orderBy(desc("TotalOrderValue")))
      )

    // Step 2: Calculate running totals and YoY growth using window functions
    val windowSpec = Window.partitionBy("customer").orderBy("calendarYear", "calendarMonthNumber")

    val runningTotalsAndYoYDF = monthlyMetricsDF
      .withColumn("RunningTotalOrderValue", sum("TotalOrderValue").over(windowSpec))
      .withColumn("RunningTotalOrderQuantity", sum("TotalOrderQuantity").over(windowSpec))
      .withColumn("LastYearOrderValue", lag("TotalOrderValue", 12).over(windowSpec))
      .withColumn("LastYearOrderQuantity", lag("TotalOrderQuantity", 12).over(windowSpec))
      .withColumn("YoYOrderValueGrowth",
        when(col("LastYearOrderValue").isNotNull,
          (col("TotalOrderValue") - col("LastYearOrderValue")) / col("LastYearOrderValue") * 100)
          .otherwise(null)
      )
      .withColumn("YoYOrderQuantityGrowth",
        when(col("LastYearOrderQuantity").isNotNull,
          (col("TotalOrderQuantity") - col("LastYearOrderQuantity")) / col("LastYearOrderQuantity") * 100)
          .otherwise(null)
      )

    // Final report: Selecting and ordering the relevant columns
    val ordersReportDF = runningTotalsAndYoYDF
      .select(
        "Year",
        "MonthName",
        "CustomerName",
        "TotalOrderQuantity",
        "TotalOrderValue",
        "TotalOrders",
        "AvgOrderValue",
        "OrderValueRank",
        "RunningTotalOrderValue",
        "RunningTotalOrderQuantity",
        "YoYOrderValueGrowth",
        "YoYOrderQuantityGrowth"
      )
      .orderBy("Year", "MonthName", "OrderValueRank")

    // Optionally, save the report as a CSV or any other format
    ordersReportDF.write.option("header", "true").csv("path_to_save_orders_report.csv")

    sparkSession.stop()
  }
}