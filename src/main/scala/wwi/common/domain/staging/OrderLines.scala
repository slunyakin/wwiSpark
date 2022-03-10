package wwi.common.domain.staging

import org.apache.spark.sql.types._

object OrderLines {

  object Fields {
    val OrderLineID = "orderLineID"
    val OrderID = "orderID"
    val StockItemID = "stockItemID"
    val Description = "description"
    val PackageTypeID = "packageTypeID"
    val Quantity = "quantity"
    val UnitPrice = "unitPrice"
    val TaxRate = "taxRate"
    val PickedQuantity = "pickedQuantity"
    val PickingCompletedWhen = "pickingCompletedWhen"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(OrderLineID, IntegerType),
    StructField(OrderID, IntegerType),
    StructField(StockItemID, IntegerType),
    StructField(Description, StringType),
    StructField(PackageTypeID, IntegerType),
    StructField(Quantity, IntegerType),
    StructField(UnitPrice, DoubleType),
    StructField(TaxRate, DoubleType),
    StructField(PickedQuantity, IntegerType),
    StructField(PickingCompletedWhen, StringType)
  ))

  val columnList = Seq(
    OrderLineID,
    OrderID,
    StockItemID,
    Description,
    PackageTypeID,
    Quantity,
    UnitPrice,
    TaxRate,
    PickedQuantity,
    PickingCompletedWhen
  )

}
