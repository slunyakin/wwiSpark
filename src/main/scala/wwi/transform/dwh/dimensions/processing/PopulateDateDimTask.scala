package wwi.transform.dwh.dimensions.processing

import org.apache.spark.sql.SparkSession
import wwi.transform.dwh.dimensions.parameters.PopulateDimsParameters
import wwi.utils.enums.{DimensionNames, SourceNames}
import wwi.utils.read.ReadUtils._
import wwi.utils.save.SaveUtils._

class PopulateDateDimTask {
  /**
   * This method runs the populate Date dimension
   *
   * @param args arguments in spark job
   * @param sparkSession spark session
   */
  def run(params: PopulateDimsParameters, sparkSession: SparkSession): Unit = {

    val dateDF = sparkSession.readTable(SourceNames.Date, params.inboundDatabase())

    dateDF.saveAsTable(params.outputDatabase() + "." + DimensionNames.Date)
  }
}
/**
 * The spark task object for populating Date dimension
 */
object PopulateDateDimTask {
  /**
   * Main method to call the Spark submit function for populating Date dimension
   * @param args Job Parameter Argument
   */
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("PopulateDateDimTask")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    val params = PopulateDimsParameters(args)
    val sparkTask = new PopulateDateDimTask()

    sparkSession.sql(s"USE ${params.inboundDatabase()}")

    sparkTask.run(params, sparkSession)
    sparkSession.stop()
  }
}