package wwi.transform.dwh.dimensions.processing

import org.apache.spark.sql.SparkSession
import wwi.transform.dwh.dimensions.helper.DimensionsHelper._
import wwi.transform.dwh.dimensions.parameters.PopulateDimsParameters
import wwi.utils.enums.{DimensionNames, SourceNames}
import wwi.utils.read.ReadUtils._
import wwi.utils.save.SaveUtils._

class PopulateCityDimTask {
  /**
   * This method runs the populate City dimension
   *
   * @param args arguments in spark job
   * @param sparkSession spark session
   */
  def run(params: PopulateDimsParameters, sparkSession: SparkSession): Unit = {

    val cityDF = sparkSession.readTable(SourceNames.Cities, params.inboundDatabase())
    val stateProvinceDF = sparkSession.readTable(SourceNames.StateProvince, params.inboundDatabase())
    val countriesDF = sparkSession.readTable(SourceNames.Countries, params.inboundDatabase())

    val cityDimDF = transformCityDim(cityDF, stateProvinceDF, countriesDF)

    cityDimDF.saveAsTable(params.outputDatabase() + "." + DimensionNames.City)
  }
}
/**
 * The spark task object for populating City dimension
 */
object PopulateCityDimTask {
  /**
   * Main method to call the Spark submit function for populating City dimension
   * @param args Job Parameter Argument
   */
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("PopulateCityDimTask")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    val params = PopulateDimsParameters(args)
    val sparkTask = new PopulateCityDimTask()

    sparkSession.sql(s"USE ${params.inboundDatabase()}")

    sparkTask.run(params, sparkSession)
    sparkSession.stop()
  }
}