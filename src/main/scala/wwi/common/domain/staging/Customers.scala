package wwi.common.domain.staging

import jodd.io.StreamUtil
import org.apache.spark.sql.types
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType, DoubleType}

object Customers {

  object Fields {
    val CustomerID = "customerID"
    val CustomerName = "customerName"
    val BillToCustomerID = "billToCustomerID"
    val CustomerCategoryID = "customerCategoryID"
    val BuyingGroupID = "buyingGroupID"
    val PrimaryContactPersonID = "primaryContactPersonID"
    val AlternateContactPersonID = "alternateContactPersonID"
    val DeliveryMethodID = "deliveryMethodID"
    val DeliveryCityID = "deliveryCityID"
    val PostalCityID = "postalCityID"
    val CreditLimit = "creditLimit"
    val AccountOpenedDate = "accountOpenedDate"
    val StandardDiscountPercentage = "standardDiscountPercentage"
    val IsStatementSent = "isStatementSent"
    val IsOnCreditHold = "isOnCreditHold"
    val PaymentDays = "paymentDays"
    val PhoneNumber = "phoneNumber"
    val FaxNumber = "faxNumber"
    val DeliveryRun = "deliveryRun"
    val RunPosition = "runPosition"
    val WebsiteURL = "websiteURL"
    val DeliveryAddressLine1 = "deliveryAddressLine1"
    val DeliveryAddressLine2 = "deliveryAddressLine2"
    val DeliveryPostalCode = "deliveryPostalCode"
    val PostalAddressLine1 = "postalAddressLine1"
    val PostalAddressLine2 = "postalAddressLine2"
    val PostalPostalCode = "postalPostalCode"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(CustomerID, IntegerType),
    StructField(CustomerName, StringType),
    StructField(BillToCustomerID, IntegerType),
    StructField(CustomerCategoryID, IntegerType),
    StructField(BuyingGroupID, IntegerType),
    StructField(PrimaryContactPersonID, IntegerType),
    StructField(AlternateContactPersonID, IntegerType),
    StructField(DeliveryMethodID, IntegerType),
    StructField(DeliveryCityID, IntegerType),
    StructField(PostalCityID, IntegerType),
    StructField(CreditLimit, DoubleType),
    StructField(AccountOpenedDate, StringType),
    StructField(StandardDiscountPercentage, DoubleType),
    StructField(IsStatementSent, IntegerType),
    StructField(IsOnCreditHold, IntegerType),
    StructField(PaymentDays, IntegerType),
    StructField(PhoneNumber, StringType),
    StructField(FaxNumber, StringType),
    StructField(DeliveryRun, StringType),
    StructField(RunPosition, StringType),
    StructField(WebsiteURL, StringType),
    StructField(DeliveryAddressLine1, StringType),
    StructField(DeliveryAddressLine2, StringType),
    StructField(DeliveryPostalCode, StringType),
    StructField(PostalAddressLine1, StringType),
    StructField(PostalAddressLine2, StringType),
    StructField(PostalPostalCode, StringType)
  ))

  val columnList = Seq(
    CustomerID,
    CustomerName,
    BillToCustomerID,
    CustomerCategoryID,
    BuyingGroupID,
    PrimaryContactPersonID,
    AlternateContactPersonID,
    DeliveryMethodID,
    DeliveryCityID,
    PostalCityID,
    CreditLimit,
    AccountOpenedDate,
    StandardDiscountPercentage,
    IsStatementSent,
    IsOnCreditHold,
    PaymentDays,
    PhoneNumber,
    FaxNumber,
    DeliveryRun,
    RunPosition,
    WebsiteURL,
    DeliveryAddressLine1,
    DeliveryAddressLine2,
    DeliveryPostalCode,
    PostalAddressLine1,
    PostalAddressLine2,
    PostalPostalCode
  )

}
