package wwi.common.domain.staging

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object CustomerCategories {

  object Fields {
    val CustomerCategoryID = "customerCategoryID"
    val CustomerCategoryName = "customerCategoryName"
    val LastEditedBy = "lastEditedBy"
    val ValidFrom = "validFrom"
    val ValidTo = "validTo"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(CustomerCategoryID, IntegerType),
    StructField(CustomerCategoryName, StringType),
    StructField(LastEditedBy, IntegerType),
    StructField(ValidFrom, StringType),
    StructField(ValidTo, StringType)
  ))

  val columnList = Seq(
    CustomerCategoryID,
    CustomerCategoryName,
    LastEditedBy,
    ValidFrom,
    ValidTo
  )

}
