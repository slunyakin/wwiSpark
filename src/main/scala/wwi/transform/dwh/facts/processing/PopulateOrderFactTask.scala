package wwi.transform.dwh.facts.processing

import org.apache.spark.sql.SparkSession
import wwi.transform.dwh.facts.helper.FactsHelper._
import wwi.transform.dwh.facts.parameters.PopulateFactsParameters
import wwi.utils.enums.{FactNames, SourceNames}
import wwi.utils.read.ReadUtils._
import wwi.utils.save.SaveUtils._

class PopulateOrderFactTask {
  /**
   * This method runs the populate Order fact
   *
   * @param args arguments in spark job
   * @param sparkSession spark session
   */
  def run(params: PopulateFactsParameters, sparkSession: SparkSession): Unit = {

    val ordersDF = sparkSession.readTable(SourceNames.Orders, params.inboundDatabase())
    val orderLinesDF = sparkSession.readTable(SourceNames.OrderLines, params.inboundDatabase())
    val packageTypesDF = sparkSession.readTable(SourceNames.PackageTypes, params.inboundDatabase())
    val customersDF = sparkSession.readTable(SourceNames.Customers, params.inboundDatabase())

    val orderFactDF = transformOrderFact(ordersDF, orderLinesDF, packageTypesDF, customersDF)

    orderFactDF.saveAsTable(params.outputDatabase() + "." + FactNames.Order)
  }
}
/**
 * The spark task object for populating Order fact
 */
object PopulateOrderFactTask {
  /**
   * Main method to call the Spark submit function for populating Order fact
   * @param args Job Parameter Argument
   */
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("PopulateOrderFactTask")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    val params = PopulateFactsParameters(args)
    val sparkTask = new PopulateOrderFactTask()

    sparkSession.sql(s"USE ${params.inboundDatabase()}")

    sparkTask.run(params, sparkSession)
    sparkSession.stop()
  }
}