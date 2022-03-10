package wwi.common.domain.staging

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object People {

  object Fields {
    val PersonID = "personID"
    val FullName = "fullName"
    val PreferredName = "preferredName"
    val SearchName = "searchName"
    val IsPermittedToLogon = "isPermittedToLogon"
    val LogonName = "logonName"
    val IsExternalLogonProvider = "isExternalLogonProvider"
    val HashedPassword = "hashedPassword"
    val IsSystemUser = "isSystemUser"
    val IsEmployee = "isEmployee"
    val IsSalesperson = "isSalesperson"
    val UserPreferences = "userPreferences"
    val PhoneNumber = "phoneNumber"
    val FaxNumber = "faxNumber"
    val EmailAddress = "emailAddress"
    val CustomFields = "customFields"
    val OtherLanguages = "otherLanguages"
    val LastEditedBy = "lastEditedBy"
    val ValidFrom = "validFrom"
    val ValidTo = "validTo"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(PersonID, IntegerType),
    StructField(FullName, StringType),
    StructField(PreferredName, StringType),
    StructField(SearchName, StringType),
    StructField(IsPermittedToLogon, StringType),
    StructField(LogonName, StringType),
    StructField(IsExternalLogonProvider, IntegerType),
    StructField(HashedPassword, StringType),
    StructField(IsSystemUser, StringType),
    StructField(IsEmployee, StringType),
    StructField(IsSalesperson, StringType),
    StructField(UserPreferences, StringType),
    StructField(PhoneNumber, StringType),
    StructField(FaxNumber, StringType),
    StructField(EmailAddress, StringType),
    StructField(CustomFields, StringType),
    StructField(OtherLanguages, StringType),
    StructField(LastEditedBy, IntegerType),
    StructField(ValidFrom, StringType),
    StructField(ValidTo, StringType)
  ))

  val columnList = Seq(
    PersonID,
    FullName,
    PreferredName,
    SearchName,
    IsPermittedToLogon,
    LogonName,
    IsExternalLogonProvider,
    HashedPassword,
    IsSystemUser,
    IsEmployee,
    IsSalesperson,
    UserPreferences,
    PhoneNumber,
    FaxNumber,
    EmailAddress,
    CustomFields,
    OtherLanguages,
    LastEditedBy,
    ValidFrom,
    ValidTo
  )

}
