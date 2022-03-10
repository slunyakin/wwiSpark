package wwi.common.schema.staging

case class Orders(
                   OrderID:                           Integer,
                   CustomerID:                        Integer,
                   SalespersonPersonID:               Integer,
                   PickedByPersonID:                  Integer,
                   ContactPersonID:                   Integer,
                   BackorderOrderID:                  Integer,
                   OrderDate:                         String,
                   ExpectedDeliveryDate:              String,
                   CustomerPurchaseOrderNumber:       String,
                   IsUndersupplyBackordered:          Integer,
                   Comments:                          String,
                   DeliveryInstructions:              String,
                   InternalComments:                  String,
                   PickingCompletedWhen:              String,
                   LastEditedBy:                      Integer,
                   LastEditedWhen:                    String
                 )
