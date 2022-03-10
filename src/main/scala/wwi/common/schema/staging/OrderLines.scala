package wwi.common.schema.staging

import java.lang.Double

case class OrderLines(
                       OrderLineID:             Integer,
                       OrderID:                 Integer,
                       StockItemID:             Integer,
                       Description:             String,
                       PackageTypeID:           Integer,
                       Quantity:                Integer,
                       UnitPrice:               Double,
                       TaxRate:                 Double,
                       PickedQuantity:          Integer,
                       PickingCompletedWhen:    String,
                       LastEditedBy:            Integer,
                       LastEditedWhen:          String
                     )
