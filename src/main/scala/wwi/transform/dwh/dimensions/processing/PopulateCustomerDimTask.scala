package wwi.transform.dwh.dimensions.processing

import org.apache.spark.sql.SparkSession
import wwi.transform.dwh.dimensions.helper.DimensionsHelper._
import wwi.transform.dwh.dimensions.parameters.PopulateDimsParameters
import wwi.utils.enums.{DimensionNames, SourceNames}
import wwi.utils.read.ReadUtils._
import wwi.utils.save.SaveUtils._

class PopulateCustomerDimTask {
  /**
   * This method runs the populate Customer dimension
   *
   * @param args arguments in spark job
   * @param sparkSession spark session
   */
  def run(params: PopulateDimsParameters, sparkSession: SparkSession): Unit = {

    val customersDF = sparkSession.readTable(SourceNames.Customers, params.inboundDatabase())
    val buyingGroupsDF = sparkSession.readTable(SourceNames.BuyingGroups, params.inboundDatabase())
    val customerCategoryDF = sparkSession.readTable(SourceNames.CustomerCategories, params.inboundDatabase())
    val peopleDF = sparkSession.readTable(SourceNames.People, params.inboundDatabase())

    val customersDimDF = transformCustomerDim(customersDF, buyingGroupsDF, customerCategoryDF, peopleDF)

    customersDimDF.saveAsTable(params.outputDatabase() + "." + DimensionNames.Customer)
  }
}
/**
 * The spark task object for populating Customer dimension
 */
object PopulateCustomerDimTask {
  /**
   * Main method to call the Spark submit function for populating Customer dimension
   * @param args Job Parameter Argument
   */
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder
      .appName("PopulateCustomerDimTask")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("OFF")

    val params = PopulateDimsParameters(args)
    val sparkTask = new PopulateCustomerDimTask()

    sparkSession.sql(s"USE ${params.inboundDatabase()}")

    sparkTask.run(params, sparkSession)
    sparkSession.stop()
  }
}