package wwi.common.domain.dimensions

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object CustomerDim {

  object Fields {
    val WWICustomerID = "wwiCustomerId"
    val Customer = "customer"
    val BillToCustomer = "billToCustomer"
    val Category = "category"
    val BuyingGroup = "buyingGroup"
    val PrimaryContact = "primaryContact"
    val PostalCode = "postalCode"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(WWICustomerID, IntegerType),
    StructField(Customer, StringType),
    StructField(BillToCustomer, StringType),
    StructField(Category, StringType),
    StructField(BuyingGroup, StringType),
    StructField(PrimaryContact, StringType),
    StructField(PostalCode, StringType)
  ))

  val columnList = Seq(
    WWICustomerID,
    Customer,
    BillToCustomer,
    Category,
    BuyingGroup,
    PrimaryContact,
    PostalCode
  )

}
