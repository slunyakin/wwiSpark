package wwi.common.domain.staging

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object BuyingGroups {

  object Fields {
    val BuyingGroupID = "buyingGroupID"
    val BuyingGroupName = "buyingGroupName"
    val LastEditedBy = "lastEditedBy"
    val ValidFrom = "validFrom"
    val ValidTo = "validTo"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(BuyingGroupID, IntegerType),
    StructField(BuyingGroupName, StringType),
    StructField(LastEditedBy, IntegerType),
    StructField(ValidFrom, StringType),
    StructField(ValidTo, StringType)
  ))

  val columnList = Seq(
    BuyingGroupID,
    BuyingGroupName,
    LastEditedBy,
    ValidFrom,
    ValidTo
  )

}
