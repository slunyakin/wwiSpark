package wwi.common.domain.dimensions

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object SupplierDim {

  object Fields {
    val WWISupplierID = "wwiSupplierId"
    val Supplier = "supplier"
    val Category = "category"
    val PrimaryContact = "primaryContact"
    val SupplierReference = "supplierReference"
    val PaymentDays = "paymentDays"
    val PostalCode = "postalCode"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(WWISupplierID, IntegerType),
    StructField(Supplier, StringType),
    StructField(Category, StringType),
    StructField(PrimaryContact, StringType),
    StructField(SupplierReference, StringType),
    StructField(PaymentDays, StringType),
    StructField(PostalCode, IntegerType)
  ))

  val columnList = Seq(
    WWISupplierID,
    Supplier,
    Category,
    PrimaryContact,
    SupplierReference,
    PaymentDays,
    PostalCode
  )

}
