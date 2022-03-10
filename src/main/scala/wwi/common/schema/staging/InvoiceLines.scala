package wwi.common.schema.staging

import java.lang.Double

case class InvoiceLines(
                         InvoiceLineID:           Integer,
                         InvoiceID:               Integer,
                         StockItemID:             Integer,
                         Description:             String,
                         PackageTypeID:           Integer,
                         Quantity:                Integer,
                         UnitPrice:               Double,
                         TaxRate:                 Double,
                         TaxAmount:               Double,
                         LineProfit:              Double,
                         ExtendedPrice:           Double,
                         LastEditedBy:            Integer,
                         LastEditedWhen:          String
                       )
