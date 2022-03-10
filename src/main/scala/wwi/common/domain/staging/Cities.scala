package wwi.common.domain.staging

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Cities {

  object Fields {
    val CityID = "cityID"
    val CityName = "cityName"
    val StateProvinceID = "stateProvinceID"
    val LatestRecordedPopulation = "latestRecordedPopulation"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(CityID, IntegerType),
    StructField(CityName, StringType),
    StructField(StateProvinceID, StringType),
    StructField(LatestRecordedPopulation, IntegerType)
  ))

  val columnList = Seq(
    CityID,
    CityName,
    StateProvinceID,
    LatestRecordedPopulation
  )

}
