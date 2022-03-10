package wwi.common.domain.facts

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Movement {

  object Fields {
    val MovementKey = "movementKey" //autoincr
    val DateKey = "dateKey"
    val StockItemKey = "stockItemKey"
    val CustomerKey = "customerKey"
    val SupplierKey = "supplierKey"
    val TransactionTypeKey = "transactionTypeKey"
    val WWIStockItemTransactionId = "wwiStockItemTransactionId"
    val WWIInvoiceId = "wwiInvoiceId"
    val WWIPurchaseOrderId = "wwiPurchaseOrderId"
    val Quantity = "quantity"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(MovementKey, StringType),
    StructField(DateKey, StringType),
    StructField(StockItemKey, IntegerType),
    StructField(CustomerKey, IntegerType),
    StructField(SupplierKey, IntegerType),
    StructField(TransactionTypeKey, IntegerType),
    StructField(WWIStockItemTransactionId, IntegerType),
    StructField(WWIInvoiceId, IntegerType),
    StructField(WWIPurchaseOrderId, IntegerType),
    StructField(Quantity, IntegerType)
  ))

  val columnList = Seq(
    MovementKey,
    DateKey,
    StockItemKey,
    CustomerKey,
    SupplierKey,
    TransactionTypeKey,
    WWIStockItemTransactionId,
    WWIInvoiceId,
    WWIPurchaseOrderId,
    Quantity
  )

}
