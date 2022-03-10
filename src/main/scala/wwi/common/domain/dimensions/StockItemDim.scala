package wwi.common.domain.dimensions

import org.apache.spark.sql.types._

object StockItemDim {

  object Fields {
    val WWIStockItemID = "wwiStockItemId"
    val StockItem = "stockItem"
    val Color = "color"
    val SellingPackage = "sellingPackage"
    val BuyingPackage = "buyingPackage"
    val Brand = "brand"
    val Size = "size"
    val LeadTimeDays = "leadTimeDays"
    val QuantityPerOuter = "quantityPerOuter"
    val IsChillerStock = "isChillerStock"
    val Barcode = "barcode"
    val TaxRate = "taxRate"
    val UnitPrice = "unitPrice"
    val RecommendedRetailPrice = "recommendedRetailPrice"
    val TypicalWeightPerUnit = "typicalWeightPerUnit"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(WWIStockItemID, IntegerType),
    StructField(StockItem, StringType),
    StructField(Color, StringType),
    StructField(SellingPackage, StringType),
    StructField(BuyingPackage, StringType),
    StructField(Brand, StringType),
    StructField(Size, StringType),
    StructField(LeadTimeDays, IntegerType),
    StructField(QuantityPerOuter, IntegerType),
    StructField(IsChillerStock, IntegerType),
    StructField(Barcode, StringType),
    StructField(TaxRate, DoubleType),
    StructField(UnitPrice, DoubleType),
    StructField(RecommendedRetailPrice, DoubleType),
    StructField(TypicalWeightPerUnit, DoubleType)
  ))

  val columnList = Seq(
    WWIStockItemID,
    StockItem,
    Color,
    SellingPackage,
    BuyingPackage,
    Brand,
    Size,
    LeadTimeDays,
    QuantityPerOuter,
    IsChillerStock,
    Barcode,
    TaxRate,
    UnitPrice,
    RecommendedRetailPrice,
    TypicalWeightPerUnit
  )

}
