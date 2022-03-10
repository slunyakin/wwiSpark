package wwi.transform.dwh.dimensions

import org.apache.spark.sql.DataFrame
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatestplus.junit.JUnitRunner
import wwi.transform.dwh.dimensions.helper.DimensionsHelper._
import wwi.data.DimensionsTestData._

@RunWith(classOf[JUnitRunner])
class DimensionsSpec extends AsyncFlatSpec with BeforeAndAfterEach {

  private val sparkSession = SparkSuiteBase.sparkContext
  sparkSession.sparkContext.setLogLevel("OFF")

  import sparkSession.implicits._
  "Function transformCityDim" should "generate City dimension data" in {
    val citiesDF: DataFrame = citiesData.toDF()
    val stateProvinceDF: DataFrame = stateProvinceData.toDF()
    val countriesDF: DataFrame = countriesData.toDF()

    val cityDimDF = transformCityDim(citiesDF, stateProvinceDF, countriesDF)

    assert(cityDimDF.count() === 6)
  }
}
