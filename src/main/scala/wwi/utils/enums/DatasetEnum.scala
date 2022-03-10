package wwi.utils.enums

object SourceNames extends Enumeration {
  type DataType = Value
  val
  BuyingGroups,
  Cities,
  Colors,
  Countries,
  CustomerCategories,
  Customers,
  CustomerTransactions,
  Date,
  InvoiceLines,
  Invoices,
  OrderLines,
  Orders,
  PackageTypes,
  PaymentMethods,
  People,
  PurchaseOrderLines,
  PurchaseOrders,
  StateProvince,
  StockItemHoldings,
  StockItems,
  StockItemTransactions,
  SupplierCategories,
  Suppliers,
  SupplierTransactions,
  TransactionTypes
  = Value

  def getAllValues: String = values.mkString(",")
}

object DimensionNames extends Enumeration {
  type DataType = Value
  val
  City,
  Customer,
  Date,
  Employee,
  PaymentMethod,
  StockItem,
  Supplier,
  TransactionType
  = Value

  def getAllValues: String = values.mkString(",")
}

object FactNames extends Enumeration {
  type DataType = Value
  val
  Order,
  Movement,
  Purchase,
  Sale,
  StockHolding,
  Transaction
  = Value

  def getAllValues: String = values.mkString(",")
}

object FileType extends Enumeration {
  type FileType = Value
  val CSV: FileType.Value = Value(".csv")
  val TSV: FileType.Value = Value(".tsv")
  val PARQUET: FileType.Value = Value(".parquet")

  def getAllValues: String = values.mkString(",")

  def get(value: String): FileType.Value = values.find(_.toString == value).getOrElse(
    throw new IllegalArgumentException("File Type - " + value + " doesn't exists. It should be one of - " + getAllValues))
}