package wwi.common.domain.staging

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object StateProvince {

  object Fields {
    val StateProvinceID = "stateProvinceId"
    val StateProvinceCode = "stateProvinceCode"
    val StateProvinceName = "stateProvinceName"
    val CountryID = "countryId"
    val SalesTerritory = "salesTerritory"
    val LatestRecordedPopulation = "latestRecordedPopulation"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(StateProvinceID, IntegerType),
    StructField(StateProvinceCode, StringType),
    StructField(StateProvinceName, StringType),
    StructField(CountryID, IntegerType),
    StructField(SalesTerritory, StringType),
    StructField(LatestRecordedPopulation, IntegerType)
  ))

  val columnList = Seq(
    StateProvinceID,
    StateProvinceCode,
    StateProvinceName,
    CountryID,
    SalesTerritory,
    LatestRecordedPopulation
  )

}
