package wwi.transform.raw.readers

import org.apache.spark.sql.{DataFrame, SparkSession}
import wwi.common.schema.staging._
import wwi.transform.raw.parameters.RawToStagingParameters
import wwi.utils.enums.{FileType, SourceNames}
import wwi.utils.read.ReadUtils

object RawToStagingInputReader {

  def read(params: RawToStagingParameters, sparkSession: SparkSession): Seq[DataFrame] = {

    import sparkSession.implicits._

    // Data location
    val buyingGroupsPath = params.baseRawLocation() + SourceNames.BuyingGroups + FileType.CSV
    val citiesPath = params.baseRawLocation() + SourceNames.Cities + FileType.CSV
    val colorsPath = params.baseRawLocation() + SourceNames.Colors + FileType.CSV
    val countriesPath = params.baseRawLocation() + SourceNames.Countries + FileType.CSV
    val customersPath = params.baseRawLocation() + SourceNames.Customers + FileType.CSV
    val customerCategoriesPath = params.baseRawLocation() + SourceNames.CustomerCategories + FileType.CSV
    val customerTransactionsPath = params.baseRawLocation() + SourceNames.CustomerTransactions + FileType.CSV
    val datePath = params.baseRawLocation() + SourceNames.Date + FileType.CSV
    val invoiceLinesPath = params.baseRawLocation() + SourceNames.InvoiceLines + FileType.CSV
    val invoicesPath = params.baseRawLocation() + SourceNames.Invoices + FileType.CSV
    val orderLinesPath = params.baseRawLocation() + SourceNames.OrderLines + FileType.CSV
    val ordersPath = params.baseRawLocation() + SourceNames.Orders + FileType.CSV
    val packageTypesPath = params.baseRawLocation() + SourceNames.PackageTypes + FileType.CSV
    val paymentMethodsPath = params.baseRawLocation() + SourceNames.PaymentMethods + FileType.CSV
    val peoplePath = params.baseRawLocation() + SourceNames.People + FileType.CSV
    val purchaseOrderLinesPath = params.baseRawLocation() + SourceNames.PurchaseOrderLines + FileType.CSV
    val purchaseOrdersPath = params.baseRawLocation() + SourceNames.PurchaseOrders + FileType.CSV
    val stateProvincePath = params.baseRawLocation() + SourceNames.StateProvince + FileType.CSV
    val stockItemHoldingsPath = params.baseRawLocation() + SourceNames.StockItemHoldings + FileType.CSV
    val stockItemsPath = params.baseRawLocation() + SourceNames.StockItems + FileType.CSV
    val stockItemTransactionsPath = params.baseRawLocation() + SourceNames.StockItemTransactions + FileType.CSV
    val supplierCategoriesPath = params.baseRawLocation() + SourceNames.SupplierCategories + FileType.CSV
    val suppliersPath = params.baseRawLocation() + SourceNames.Suppliers + FileType.CSV
    val supplierTransactionsPath = params.baseRawLocation() + SourceNames.StockItemTransactions + FileType.CSV
    val transactionTypesPath = params.baseRawLocation() + SourceNames.TransactionTypes + FileType.CSV

    // Reading data
    val buyingGroupsDF = ReadUtils.readTSVDataset[BuyingGroups](sparkSession, buyingGroupsPath).toDF()
    val citiesDF = ReadUtils.readTSVDataset[Cities](sparkSession, citiesPath).toDF()
    val colorsDF = ReadUtils.readTSVDataset[Colors](sparkSession, colorsPath).toDF()
    val countriesDF = ReadUtils.readTSVDataset[Countries](sparkSession, countriesPath).toDF()
    val customerCategoriesDF = ReadUtils.readTSVDataset[CustomerCategories](sparkSession, customerCategoriesPath).toDF()
    val customersDF = ReadUtils.readTSVDataset[Customers](sparkSession, customersPath).toDF()
    val customersTransactionsDF = ReadUtils.readTSVDataset[CustomerTransactions](sparkSession, customerTransactionsPath).toDF()
    val dateDF = ReadUtils.readTSVDataset[Date](sparkSession, datePath).toDF()
    val invoiceLinesDF = ReadUtils.readTSVDataset[InvoiceLines](sparkSession, invoiceLinesPath).toDF()
    val invoicesDF = ReadUtils.readTSVDataset[Invoices](sparkSession, invoicesPath).toDF()
    val orderLinesDF = ReadUtils.readTSVDataset[OrderLines](sparkSession, orderLinesPath).toDF()
    val ordersDF = ReadUtils.readTSVDataFrame(sparkSession, ordersPath)
    val packageTypesDF = ReadUtils.readTSVDataset[PackageTypes](sparkSession, packageTypesPath).toDF()
    val paymentMethodsDF = ReadUtils.readTSVDataset[PaymentMethods](sparkSession, paymentMethodsPath).toDF()
    val peopleDF = ReadUtils.readTSVDataset[People](sparkSession, peoplePath).toDF()
    val purchaseOrderLinesDF = ReadUtils.readTSVDataset[PurchaseOrderLines](sparkSession, purchaseOrderLinesPath).toDF()
    val purchaseOrdersDF = ReadUtils.readTSVDataset[PurchaseOrders](sparkSession, purchaseOrdersPath).toDF()
    val stateProvinceDF = ReadUtils.readTSVDataset[StateProvince](sparkSession, stateProvincePath).toDF()
    val stockItemHoldingDF = ReadUtils.readTSVDataset[StockItemHoldings](sparkSession, stockItemHoldingsPath).toDF()
    val stockItemsDF = ReadUtils.readTSVDataset[StockItems](sparkSession, stockItemsPath).toDF()
    val stockItemTransactionsDF = ReadUtils.readTSVDataset[StockItemTransactions](sparkSession, stockItemTransactionsPath).toDF()
    val supplierCategoriesDF = ReadUtils.readTSVDataset[SupplierCategories](sparkSession, supplierCategoriesPath).toDF()
    val suppliersDF = ReadUtils.readTSVDataset[Suppliers](sparkSession, suppliersPath).toDF()
    val supplierTransactionsDF = ReadUtils.readTSVDataset[SupplierTransactions](sparkSession, supplierTransactionsPath).toDF()
    val transactionTypesDF = ReadUtils.readTSVDataset[TransactionTypes](sparkSession, transactionTypesPath).toDF()

    // Return data
    Seq(buyingGroupsDF,
      citiesDF,
      colorsDF,
      countriesDF,
      customerCategoriesDF,
      customersDF,
      customersTransactionsDF,
      dateDF,
      invoiceLinesDF,
      invoicesDF,
      orderLinesDF,
      ordersDF,
      packageTypesDF,
      paymentMethodsDF,
      peopleDF,
      purchaseOrderLinesDF,
      purchaseOrdersDF,
      stateProvinceDF,
      stockItemHoldingDF,
      stockItemsDF,
      stockItemTransactionsDF,
      supplierCategoriesDF,
      suppliersDF,
      supplierTransactionsDF,
      transactionTypesDF
    )
  }
}
