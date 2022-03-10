package wwi.transform.raw.processing

import org.apache.spark.sql.{DataFrame, SparkSession}
import wwi.transform.raw.parameters.RawToStagingParameters
import wwi.transform.raw.readers.RawToStagingInputReader
import wwi.utils.enums.SourceNames
import wwi.utils.save.SaveUtils._

class RawToStagingTransformTask() {

  /**
   * This method runs the Raw to Staging
   *
   * @param args arguments in spark job
   * @param sparkSession spark session
   */
  def run(params: RawToStagingParameters, sparkSession: SparkSession): Unit = {

    val dataInputsDFS: Seq[DataFrame] = RawToStagingInputReader.read(params, sparkSession)

    val dfToDatasetNameTuple = dataInputsDFS zip SourceNames.values.toSeq

    dfToDatasetNameTuple.foreach(
      entity => {
        val (df: DataFrame, datasetName: SourceNames.Value) = entity
        df.saveAsTable(datasetName.toString())
      }
    )
  }
}
/**
 * The spark task object for Raw to Staging transformation
 */
object RawToStagingTransformTask {
  /*
   * Main method to call the Spark submit function for Raw to Staging transformation
   * @param args Job Parameter Argument
   */
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("RawToStagingTransformTask")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    val params = RawToStagingParameters(args)
    val sparkTask = new RawToStagingTransformTask()

    sparkSession.sql(s"USE ${params.outputDatabase()}")

    sparkTask.run(params, sparkSession)
    sparkSession.stop()
  }
}