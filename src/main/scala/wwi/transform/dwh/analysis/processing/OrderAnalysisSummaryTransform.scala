package wwi.transform.dwh.analysis.processing

import org.apache.spark.sql.{DataFrame, SparkSession}
import wwi.transform.dwh.analysis.parameters.OrderAnalysisParameters
import wwi.transform.dwh.analysis.helper.OrderAnalysisHelper._
import wwi.transform.dwh.analysis.reader.OrderSummaryReportInputReader
import wwi.utils.enums.FactNames
import wwi.utils.save.SaveUtils._

class OrderAnalysisSummaryTransform {
  /**
   * This method prepares Order Summary Report
   *
   * @param args arguments in spark job
   * @param sparkSession spark session
   */
  def run(customersDF: DataFrame, dateDF: DataFrame, ordersDF: DataFrame, sparkSession: SparkSession): DataFrame = {

    //Write code for Summary Report
ordersDF
  }
}
/**
 * The spark task object for preparing Order Summary Report
 */
object OrderAnalysisSummaryTransform {
  /**
   * Main method to call the Spark submit function for preparing Order Summary Report
   * @param args Job Parameter Argument
   */
  def main(args: Array[String]): Unit = {

    //Create spark session
    val sparkSession = SparkSession.builder
      .appName("OrderAnalysisSummaryTransform")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    //Get the parameters passed to spark-submit and create an instance of transformation class
    val params = OrderAnalysisParameters(args)
    val sparkTask = new OrderAnalysisSummaryTransform()

    val Seq(customersDF, dateDF, ordersDF): Seq[DataFrame] = OrderSummaryReportInputReader.read(params, sparkSession)

    //Set the current hive database
    sparkSession.sql(s"USE ${params.outputDatabase()}")

    //Run the spark task for transformation
    val orderSummaryReportDF = sparkTask.run(customersDF, dateDF, ordersDF,sparkSession)

    //Save the transformed data to hive table
    orderSummaryReportDF.saveAsTable(params.outputDatabase() + "." + FactNames.Order)

    //Stop Spark session
    sparkSession.stop()
  }
}