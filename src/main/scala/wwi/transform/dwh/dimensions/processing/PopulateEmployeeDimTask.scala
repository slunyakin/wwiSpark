package wwi.transform.dwh.dimensions.processing

import org.apache.spark.sql.SparkSession
import wwi.transform.dwh.dimensions.helper.DimensionsHelper._
import wwi.transform.dwh.dimensions.parameters.PopulateDimsParameters
import wwi.utils.enums.{DimensionNames, SourceNames}
import wwi.utils.read.ReadUtils._
import wwi.utils.save.SaveUtils._

class PopulateEmployeeDimTask {
  /**
   * This method runs the populate Employee dimension
   *
   * @param args arguments in spark job
   * @param sparkSession spark session
   */
  def run(params: PopulateDimsParameters, sparkSession: SparkSession): Unit = {

    val peopleDF = sparkSession.readTable(SourceNames.People, params.inboundDatabase())

    val employeeDimDF = peopleDF.select(employeeColumns: _*)

    employeeDimDF.saveAsTable(params.outputDatabase() + "." + DimensionNames.Employee)
  }
}
/**
 * The spark task object for populating Employee dimension
 */
object PopulateEmployeeDimTask {
  /**
   * Main method to call the Spark submit function for populating Employee dimension
   * @param args Job Parameter Argument
   */
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("PopulateEmployeeDimTask")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    val params = PopulateDimsParameters(args)
    val sparkTask = new PopulateEmployeeDimTask()

    sparkSession.sql(s"USE ${params.inboundDatabase()}")

    sparkTask.run(params, sparkSession)
    sparkSession.stop()
  }
}