package wwi.transform.dwh.analysis.helper

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, col, countDistinct, desc, row_number, sum}
import org.apache.spark.sql.{Column, DataFrame}
import wwi.common.domain.dimensions.{CustomerDim, DateDim, EmployeeDim}
import wwi.common.domain.facts.Order
import wwi.common.domain.reports.OrderSummaryReport
import wwi.common.domain.staging._
import wwi.utils.JoinUtils._

object OrderAnalysisHelper {

  //Enrich order data with dimensions
  def enrichOrders(factOrderDF: DataFrame, dimCustomerDF: DataFrame, dimDateDF: DataFrame): DataFrame = {

    val enrichedOrdersDF =
      factOrderDF
        .leftJoin(dimDateDF, factOrderDF(Order.Fields.OrderDateKey) === dimDateDF(DateDim.Fields.Date),true)
        .leftJoin(dimCustomerDF, Seq(CustomerDim.Fields.CustomerKey))

    enrichedOrdersDF
  }

  val employeeColumns: Seq[Column] = Seq(
    col(People.Fields.PersonID).as(EmployeeDim.Fields.WWIEmployeeID),
    col(People.Fields.FullName).as(EmployeeDim.Fields.Employee),
    col(People.Fields.PreferredName).as(EmployeeDim.Fields.PreferredName),
    col(People.Fields.IsSalesperson).as(EmployeeDim.Fields.IsSalesPerson)
  )

  implicit class transformationLogic(df: DataFrame) {

    //Calculate monthly metrics and ranking within each month
    def monthlyMetricsDF: DataFrame = {
      df
        .groupBy(DateDim.Fields.CalendarYear, DateDim.Fields.Month, DateDim.Fields.CalendarMonthNumber, CustomerDim.Fields.Customer)
        .agg(
          sum(Order.Fields.Quantity).as(OrderSummaryReport.Fields.TotalOrderQuantity),
          sum(Order.Fields.TotalExcludingTax).as(OrderSummaryReport.Fields.TotalOrderValue),
          countDistinct(Order.Fields.OrderKey).as(OrderSummaryReport.Fields.TotalOrders),
          avg(Order.Fields.TotalExcludingTax).as(OrderSummaryReport.Fields.AvgOrderValue)
        ).withColumn(OrderSummaryReport.Fields.OrderValueRank,
          row_number().over(Window.partitionBy(DateDim.Fields.CalendarYear, DateDim.Fields.CalendarMonthNumber).orderBy(desc(OrderSummaryReport.Fields.TotalOrderValue))))
    }

    //Calculate running totals and YoY growth using window functions


  }

}












//def runningTotalsAndYoYDF: DataFrame = {
//  val windowSpec = Window.partitionBy(CustomerDim.Fields.Customer).orderBy(DateDim.Fields.CalendarYear, DateDim.Fields.CalendarMonthNumber)
//  df
//    .withColumn(OrderSummaryReport.Fields.RunningTotalOrderValue, sum(OrderSummaryReport.Fields.TotalOrderValue).over(windowSpec))
//    .withColumn(OrderSummaryReport.Fields.RunningTotalOrderQuantity, sum(OrderSummaryReport.Fields.TotalOrderQuantity).over(windowSpec))
//    .withColumn(OrderSummaryReport.Fields.LastYearOrderValue, lag(OrderSummaryReport.Fields.TotalOrderValue, 12).over(windowSpec))
//    .withColumn(OrderSummaryReport.Fields.LastYearOrderQuantity, lag(OrderSummaryReport.Fields.TotalOrderQuantity, 12).over(windowSpec))
//    .withColumn(OrderSummaryReport.Fields.YoYOrderValueGrowth,
//      when(col(OrderSummaryReport.Fields.LastYearOrderValue).isNotNull,
//        (col(OrderSummaryReport.Fields.TotalOrderValue) - col(OrderSummaryReport.Fields.LastYearOrderValue)) / col(OrderSummaryReport.Fields.LastYearOrderValue) * 100)
//        .otherwise(null)
//    )
//    .withColumn(OrderSummaryReport.Fields.YoYOrderQuantityGrowth,
//      when(col(OrderSummaryReport.Fields.LastYearOrderQuantity).isNotNull,
//        (col(OrderSummaryReport.Fields.TotalOrderQuantity) - col(OrderSummaryReport.Fields.LastYearOrderQuantity)) / col(OrderSummaryReport.Fields.LastYearOrderQuantity) * 100)
//        .otherwise(null)
//    )
//}