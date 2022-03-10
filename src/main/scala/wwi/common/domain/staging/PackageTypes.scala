package wwi.common.domain.staging

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object PackageTypes {

  object Fields {
    val PackageTypeID = "packageTypeID"
    val PackageTypeName = "packageTypeName"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(PackageTypeID, IntegerType),
    StructField(PackageTypeName, StringType)
  ))

  val columnList = Seq(
    PackageTypeID,
    PackageTypeName
  )

}
