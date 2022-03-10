package wwi.common.schema.staging

import java.lang.Double

case class PurchaseOrderLines(
                               PurchaseOrderLineID:               Integer,
                               PurchaseOrderID:                   Integer,
                               StockItemID:                       Integer,
                               OrderedOuters:                     Integer,
                               Description:                       String,
                               ReceivedOuters:                    Integer,
                               PackageTypeID:                     Integer,
                               ExpectedUnitPricePerOuter:         Double,
                               LastReceiptDate:                   String,
                               IsOrderLineFinalized:              Integer,
                               LastEditedBy:                      Integer,
                               LastEditedWhen:                    String
                             )
