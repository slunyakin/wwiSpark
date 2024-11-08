package wwi.common.domain.reports

import org.apache.spark.sql.types._

object OrderSummaryReport {

  object Fields {
    //Report Fields
    val Year = "Year"
    val MonthName = "MonthName"
    val CustomerName = "CustomerName"
    val TotalOrderQuantity = "TotalOrderQuantity"
    val TotalOrderValue = "TotalOrderValue"
    val TotalOrders = "TotalOrders"
    val AvgOrderValue = "AvgOrderValue"
    val OrderValueRank = "OrderValueRank"
    val RunningTotalOrderValue = "RunningTotalOrderValue"
    val RunningTotalOrderQuantity = "RunningTotalOrderQuantity"
    val YoYOrderValueGrowth = "YoYOrderValueGrowth"
    val YoYOrderQuantityGrowth = "YoYOrderQuantityGrowth"

    //Calculated Fields
    val LastYearOrderValue = "LastYearOrderValue"
    val LastYearOrderQuantity = "LastYearOrderQuantity"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(Year, IntegerType),
    StructField(MonthName, StringType),
    StructField(CustomerName, StringType),
    StructField(TotalOrderQuantity, IntegerType),
    StructField(TotalOrderValue, DecimalType(18, 2)),
    StructField(TotalOrders, IntegerType),
    StructField(AvgOrderValue, DecimalType(18, 2)),
    StructField(OrderValueRank, DecimalType(18, 2)),
    StructField(RunningTotalOrderValue, DecimalType(18, 2)),
    StructField(RunningTotalOrderQuantity, IntegerType),
    StructField(YoYOrderValueGrowth, DecimalType(18, 2)),
    StructField(YoYOrderQuantityGrowth, IntegerType)
  ))

  val columnList:Seq[String] = Seq(
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
    YoYOrderValueGrowth,
    YoYOrderQuantityGrowth
  )

}
