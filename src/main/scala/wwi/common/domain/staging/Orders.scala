package wwi.common.domain.staging

import org.apache.spark.sql.types._

object Orders {

  object Fields {
    val OrderID = "orderID"
    val CustomerID = "customerID"
    val SalespersonPersonID = "salespersonPersonID"
    val PickedByPersonID = "pickedByPersonID"
    val ContactPersonID = "contactPersonID"
    val BackorderOrderID = "backorderOrderID"
    val OrderDate = "orderDate"
    val ExpectedDeliveryDate = "expectedDeliveryDate"
    val CustomerPurchaseOrderNumber = "customerPurchaseOrderNumber"
    val IsUndersupplyBackordered = "isUndersupplyBackordered"
    val Comments = "comments"
    val DeliveryInstructions = "deliveryInstructions"
    val InternalComments = "internalComments"
    val PickingCompletedWhen = "pickingCompletedWhen"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(OrderID, IntegerType, false),
    StructField(CustomerID, IntegerType, false),
    StructField(SalespersonPersonID, IntegerType, false),
    StructField(PickedByPersonID, IntegerType, false),
    StructField(ContactPersonID, IntegerType, false),
    StructField(BackorderOrderID, IntegerType, false),
    StructField(OrderDate, StringType, false),
    StructField(ExpectedDeliveryDate, StringType, false),
    StructField(CustomerPurchaseOrderNumber, StringType, false),
    StructField(IsUndersupplyBackordered, IntegerType, false),
    StructField(Comments, StringType, false),
    StructField(DeliveryInstructions, StringType, false),
    StructField(InternalComments, StringType, false),
    StructField(PickingCompletedWhen, StringType, false)
  ))

  val columnList = Seq(
    OrderID,
    CustomerID,
    SalespersonPersonID,
    PickedByPersonID,
    ContactPersonID,
    BackorderOrderID,
    OrderDate,
    ExpectedDeliveryDate,
    CustomerPurchaseOrderNumber,
    IsUndersupplyBackordered,
    Comments,
    DeliveryInstructions,
    InternalComments,
    PickingCompletedWhen
  )

}
