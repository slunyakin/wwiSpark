package wwi.common.domain.facts

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Purchase {

  object Fields {
    val PurchaseKey = "purchaseKey" //autoincr
    val DateKey = "dateKey"
    val SupplierKey = "supplierKey"
    val StockItemKey = "stockItemKey"
    val WWIPurchaseOrderId = "wwiPurchaseOrderId"
    val OrderedOuters = "orderedOuters"
    val OrderedQuantity = "orderedQuantity"
    val ReceivedOuters = "receivedOuters"
    val Package = "Package"
    val IsOrderFinalized = "isOrderFinalized"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(PurchaseKey, StringType),
    StructField(DateKey, StringType),
    StructField(SupplierKey, IntegerType),
    StructField(StockItemKey, IntegerType),
    StructField(WWIPurchaseOrderId, IntegerType),
    StructField(OrderedOuters, IntegerType),
    StructField(OrderedQuantity, IntegerType),
    StructField(ReceivedOuters, IntegerType),
    StructField(Package, StringType),
    StructField(IsOrderFinalized, IntegerType)
  ))

  val columnList = Seq(
    PurchaseKey,
    DateKey,
    SupplierKey,
    StockItemKey,
    WWIPurchaseOrderId,
    OrderedOuters,
    OrderedQuantity,
    ReceivedOuters,
    Package,
    IsOrderFinalized
  )

}
