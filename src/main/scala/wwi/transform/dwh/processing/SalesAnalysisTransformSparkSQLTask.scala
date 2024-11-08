package wwi.transform.dwh.processing

import org.apache.spark.sql.{DataFrame, SparkSession}
object SalesAnalysisTransformSparkSQLTask {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("SalesAnalysisTransformation")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    // Load DataFrames (assuming CSV format here; replace with actual data source)
    val factOrderDF = sparkSession.read.option("header", "true").csv("/Users/slunyakin/Downloads/WWIDW/Orders.csv")
    val dimCustomerDF = sparkSession.read.option("header", "true").csv("path_to_dimension_customer.csv")
    val dimDateDF = sparkSession.read.option("header", "true").csv("path_to_dimension_date.csv")

    // Register DataFrames as temporary views for SQL queries
    factOrderDF.createOrReplaceTempView("Order")
    dimCustomerDF.createOrReplaceTempView("Customer")
    dimDateDF.createOrReplaceTempView("Date")

    // Define the SQL query
    val query =
      """
        WITH MonthlyOrders AS (
            SELECT
                d.Year,
                d.MonthName,
                d.MonthNumber,
                c.CustomerName,
                SUM(o.OrderQuantity) AS TotalOrderQuantity,
                SUM(o.OrderLineTotal) AS TotalOrderValue,
                COUNT(DISTINCT o.OrderKey) AS TotalOrders,
                AVG(o.OrderLineTotal) AS AvgOrderValue,
                ROW_NUMBER() OVER (PARTITION BY d.Year, d.MonthNumber ORDER BY SUM(o.OrderLineTotal) DESC) AS OrderValueRank
            FROM
                Order AS o
            JOIN
                Date AS d ON o.OrderDateKey = d.DateKey
            JOIN
                Customer AS c ON o.CustomerKey = c.CustomerKey
            GROUP BY
                d.Year, d.MonthName, d.MonthNumber, c.CustomerName
        ),
        RunningTotalsAndYoY AS (
            SELECT
                Year,
                MonthName,
                CustomerName,
                TotalOrderQuantity,
                TotalOrderValue,
                TotalOrders,
                AvgOrderValue,
                OrderValueRank,
                SUM(TotalOrderValue) OVER (PARTITION BY CustomerName ORDER BY Year, MonthNumber) AS RunningTotalOrderValue,
                SUM(TotalOrderQuantity) OVER (PARTITION BY CustomerName ORDER BY Year, MonthNumber) AS RunningTotalOrderQuantity,
                LAG(TotalOrderValue, 12) OVER (PARTITION BY CustomerName ORDER BY Year, MonthNumber) AS LastYearOrderValue,
                LAG(TotalOrderQuantity, 12) OVER (PARTITION BY CustomerName ORDER BY Year, MonthNumber) AS LastYearOrderQuantity
            FROM
                MonthlyOrders
        )
        SELECT
            Year,
            MonthName,
            CustomerName,
            TotalOrderQuantity,
            TotalOrderValue,
            TotalOrders,
            AvgOrderValue,
            OrderValueRank,
            RunningTotalOrderValue,
            RunningTotalOrderQuantity,
            CASE
                WHEN LastYearOrderValue IS NOT NULL THEN
                    ((TotalOrderValue - LastYearOrderValue) / LastYearOrderValue) * 100
                ELSE
                    NULL
            END AS YoYOrderValueGrowth,
            CASE
                WHEN LastYearOrderQuantity IS NOT NULL THEN
                    ((TotalOrderQuantity - LastYearOrderQuantity) / LastYearOrderQuantity) * 100
                ELSE
                    NULL
            END AS YoYOrderQuantityGrowth
        FROM
            RunningTotalsAndYoY
        ORDER BY
            Year, MonthName, OrderValueRank
        """

    // Execute the query using Spark SQL
    val ordersReportDF: DataFrame = sparkSession.sql(query)

    // Optionally, save the report as a CSV or any other format
    ordersReportDF.write.option("header", "true").csv("path_to_save_orders_report.csv")

    sparkSession.stop()
  }
}