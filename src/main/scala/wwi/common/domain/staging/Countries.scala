package wwi.common.domain.staging

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Countries {

  object Fields {
    val CountryID = "countryID"
    val CountryName = "countryName"
    val FormalName = "formalName"
    val IsoAlpha3Code = "isoAlpha3Code"
    val IsoNumericCode = "isoNumericCode"
    val CountryType = "countryType"
    val LatestRecordedPopulation = "latestRecordedPopulation"
    val Continent = "continent"
    val Region = "region"
    val Subregion = "subregion"
    val Border = "Border"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(CountryID, IntegerType),
    StructField(CountryName, StringType),
    StructField(FormalName, StringType),
    StructField(IsoAlpha3Code, StringType),
    StructField(IsoNumericCode, IntegerType),
    StructField(CountryType, StringType),
    StructField(LatestRecordedPopulation, IntegerType),
    StructField(Continent, StringType),
    StructField(Region, StringType),
    StructField(Subregion, StringType),
    StructField(Border, StringType)
  ))

  val columnList = Seq(
    CountryID,
    CountryName,
    FormalName,
    IsoAlpha3Code,
    IsoNumericCode,
    CountryType,
    LatestRecordedPopulation,
    Continent,
    Region,
    Subregion,
    Border
  )

}
