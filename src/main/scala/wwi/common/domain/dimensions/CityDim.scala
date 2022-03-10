package wwi.common.domain.dimensions

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object CityDim {

  object Fields {
    val WWICityID = "wwiCityId"
    val City = "city"
    val StateProvince = "stateProvince"
    val Country = "country"
    val Continent = "continent"
    val SalesTerritory = "salesTerritory"
    val Region = "region"
    val Subregion = "subregion"
    val LatestRecordedPopulation = "latestRecordedPopulation"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(WWICityID, IntegerType),
    StructField(City, StringType),
    StructField(StateProvince, StringType),
    StructField(Country, StringType),
    StructField(Continent, StringType),
    StructField(SalesTerritory, StringType),
    StructField(Region, StringType),
    StructField(Subregion, StringType),
    StructField(LatestRecordedPopulation, IntegerType)
  ))

  val columnList = Seq(
    WWICityID,
    City,
    StateProvince,
    Country,
    Continent,
    SalesTerritory,
    Region,
    Subregion,
    LatestRecordedPopulation
  )

}
