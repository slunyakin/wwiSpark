package wwi.common.schema.staging

import java.lang.Double

case class StockItemHoldings(
                              StockItemID:              Integer,
                              QuantityOnHand:           Integer,
                              BinLocation:              String,
                              LastStocktakeQuantity:    Integer,
                              LastCostPrice:            Double,
                              ReorderLevel:             Integer,
                              TargetStockLevel:         Integer,
                              LastEditedBy:             Integer,
                              LastEditedWhen:           String
                            )
