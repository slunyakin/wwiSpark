package wwi.common.schema.staging

case class PurchaseOrders(
                           PurchaseOrderID:           Integer,
                           SupplierID:                Integer,
                           OrderDate:                 String,
                           DeliveryMethodID:          Integer,
                           ContactPersonID:           Integer,
                           ExpectedDeliveryDate:      String,
                           SupplierReference:         String,
                           IsOrderFinalized:          Integer,
                           Comments:                  String,
                           InternalComments:          String,
                           LastEditedBy:              Integer,
                           LastEditedWhen:            String
                         )
