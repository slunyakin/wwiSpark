package wwi.common.domain.facts

import org.apache.spark.sql.types._

object Order {

  object Fields {
    val OrderKey = "orderKey" //autoincr
    val CityKey = "cityKey"
    val CustomerKey = "customerKey"
    val StockItemKey = "stockItemKey"
    val OrderDateKey = "orderDateKey"
    val PickedDateKey = "pickedDateKey"
    val SalespersonKey = "salesPersonKey"
    val PickerKey = "pickerKey"
    val WWIOrderId = "wwiOrderId"
    val WWIBackorderId = "wwiBackorderId"
    val Description = "description"
    val Package = "package"
    val Quantity = "quantity"
    val UnitPrice = "unitPrice"
    val TaxRate = "taxRate"
    val TotalExcludingTax = "totalExcludingTax"
    val TaxAmount = "taxAmount"
    val TotalIncludingTax = "totalIncludingTax"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(OrderKey, StringType),
    StructField(CityKey, IntegerType),
    StructField(CustomerKey, IntegerType),
    StructField(StockItemKey, IntegerType),
    StructField(OrderDateKey, StringType),
    StructField(PickedDateKey, StringType),
    StructField(SalespersonKey, IntegerType),
    StructField(PickerKey, IntegerType),
    StructField(WWIOrderId, IntegerType),
    StructField(WWIBackorderId, IntegerType),
    StructField(Description, StringType),
    StructField(Package, StringType),
    StructField(Quantity, IntegerType),
    StructField(UnitPrice, DoubleType),
    StructField(TaxRate, DoubleType),
    StructField(TotalExcludingTax, DoubleType),
    StructField(TaxAmount, DoubleType),
    StructField(TotalIncludingTax, DoubleType)
  ))

  val columnList = Seq(
    OrderKey,
    CityKey,
    CustomerKey,
    StockItemKey,
    OrderDateKey,
    PickedDateKey,
    SalespersonKey,
    PickerKey,
    WWIOrderId,
    WWIBackorderId,
    Description,
    Package,
    Quantity,
    UnitPrice,
    TaxRate,
    TotalExcludingTax,
    TaxAmount,
    TotalIncludingTax
  )

}
