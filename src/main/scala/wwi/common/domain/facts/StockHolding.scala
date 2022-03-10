package wwi.common.domain.facts

import org.apache.spark.sql.types._

object StockHolding {

  object Fields {
    val StockHoldingKey = "stockHoldingKey" //autoincr
    val StockItemKey = "stockItemKey"
    val QuantityOnHand = "quantityOnHand"
    val BinLocation = "binLocation"
    val LastStocktakeQuantity = "lastStocktakeQuantity"
    val LastCostPrice = "lastCostPrice"
    val ReorderLevel = "reorderLevel"
    val TargetStockLevel = "targetStockLevel"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(StockHoldingKey, StringType),
    StructField(StockItemKey, IntegerType),
    StructField(QuantityOnHand, IntegerType),
    StructField(BinLocation, StringType),
    StructField(LastStocktakeQuantity, IntegerType),
    StructField(LastCostPrice, DoubleType),
    StructField(ReorderLevel, IntegerType),
    StructField(TargetStockLevel, IntegerType)
  ))

  val columnList = Seq(
    StockHoldingKey,
    StockItemKey,
    QuantityOnHand,
    BinLocation,
    LastStocktakeQuantity,
    LastCostPrice,
    ReorderLevel,
    TargetStockLevel
  )

}
