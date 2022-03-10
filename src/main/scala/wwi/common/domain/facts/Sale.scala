package wwi.common.domain.facts

import org.apache.spark.sql.types._

object Sale {

  object Fields {
    val SaleKey = "saleKey" //autoincr
    val CityKey = "cityKey"
    val CustomerKey = "customerKey"
    val BillToCustomerKey = "billToCustomerKey"
    val StockItemKey = "stockItemKey"
    val InvoiceDateKey = "invoiceDateKey"
    val DeliveryDateKey = "deliveryDateKey"
    val SalespersonKey = "salespersonKey"
    val WWIInvoiceId = "WWIInvoiceId"
    val Description = "Description"
    val Package = "package"
    val Quantity = "quantity"
    val UnitPrice = "unitPrice"
    val TaxRate = "taxRate"
    val TotalExcludingTax = "totalExcludingTax"
    val TaxAmount = "taxAmount"
    val Profit = "profit"
    val TotalIncludingTax = "totalIncludingTax"
    val TotalDryItems = "totalDryItems"
    val TotalChillerItems = "totalChillerItems"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(SaleKey, StringType),
    StructField(CityKey, StringType),
    StructField(CustomerKey, IntegerType),
    StructField(BillToCustomerKey, IntegerType),
    StructField(StockItemKey, IntegerType),
    StructField(InvoiceDateKey, StringType),
    StructField(DeliveryDateKey, StringType),
    StructField(SalespersonKey, IntegerType),
    StructField(WWIInvoiceId, IntegerType),
    StructField(Description, StringType),
    StructField(Package, StringType),
    StructField(Quantity, IntegerType),
    StructField(UnitPrice, DoubleType),
    StructField(TaxRate, DoubleType),
    StructField(TotalExcludingTax, DoubleType),
    StructField(TaxAmount, DoubleType),
    StructField(Profit, DoubleType),
    StructField(TotalIncludingTax, DoubleType),
    StructField(TotalDryItems, IntegerType),
    StructField(TotalChillerItems, IntegerType)
  ))

  val columnList = Seq(
    SaleKey,
    CityKey,
    CustomerKey,
    BillToCustomerKey,
    StockItemKey,
    InvoiceDateKey,
    DeliveryDateKey,
    SalespersonKey,
    WWIInvoiceId,
    Description,
    Package,
    Quantity,
    UnitPrice,
    TaxRate,
    TotalExcludingTax,
    TaxAmount,
    Profit,
    TotalIncludingTax,
    TotalDryItems,
    TotalChillerItems
  )

}
