package wwi.common.domain.facts

import org.apache.spark.sql.types._

object Transaction {

  object Fields {
    val TransactionKey = "transactionKey"
    val DateKey = "dateKey"
    val CustomerKey = "customerKey"
    val BillToCustomerKey = "billToCustomerKey"
    val SupplierKey = "supplierkey"
    val TransactionTypeKey = "transactionTypeKey"
    val PaymentMethodKey = "paymentMethodKey"
    val WWICustomerTransactionId = "wwiCustomerTransactionId"
    val WWISupplierTransactionId = "wwiSupplierTransactionId"
    val WWIInvoiceId = "wwiInvoiceId"
    val WWIPurchaseOrderId = "wwiPurchaseOrderId"
    val SupplierInvoiceNumber = "supplierInvoiceNumber"
    val TotalExcludingTax = "totalExcludingTax"
    val TaxAmount = "taxAmount"
    val TotalIncludingTax = "totalIncludingTax"
    val OutstandingBalance = "outstandingBalance"
    val IsFinalized = "isFinalized"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(TransactionKey, StringType),
    StructField(DateKey, StringType),
    StructField(CustomerKey, IntegerType),
    StructField(BillToCustomerKey, IntegerType),
    StructField(SupplierKey, IntegerType),
    StructField(TransactionKey, IntegerType),
    StructField(PaymentMethodKey, IntegerType),
    StructField(WWICustomerTransactionId, IntegerType),
    StructField(WWISupplierTransactionId, IntegerType),
    StructField(WWIInvoiceId, IntegerType),
    StructField(WWIPurchaseOrderId, IntegerType),
    StructField(SupplierInvoiceNumber, StringType),
    StructField(TotalExcludingTax, DoubleType),
    StructField(TaxAmount, DoubleType),
    StructField(TotalIncludingTax, DoubleType),
    StructField(OutstandingBalance, DoubleType),
    StructField(IsFinalized, IntegerType)
  ))

  val columnList = Seq(
    TransactionKey,
    DateKey,
    CustomerKey,
    BillToCustomerKey,
    SupplierKey,
    TransactionTypeKey,
    PaymentMethodKey,
    WWICustomerTransactionId,
    WWISupplierTransactionId,
    WWIInvoiceId,
    WWIPurchaseOrderId,
    SupplierInvoiceNumber,
    TotalExcludingTax,
    TaxAmount,
    TotalIncludingTax,
    OutstandingBalance,
    IsFinalized
  )

}
