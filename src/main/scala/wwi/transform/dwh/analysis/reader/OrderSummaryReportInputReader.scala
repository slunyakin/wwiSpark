package wwi.transform.dwh.analysis.reader

import org.apache.spark.sql.{DataFrame, SparkSession}
import wwi.common.schema.staging._
import wwi.transform.dwh.analysis.parameters.OrderAnalysisParameters
import wwi.utils.enums.{FileType, SourceNames}
import wwi.utils.read.ReadUtils

object OrderSummaryReportInputReader {

  def read(params: OrderAnalysisParameters, sparkSession: SparkSession): Seq[DataFrame] = {

    import sparkSession.implicits._

    // Data location
    val customersPath = params.baseRawLocation() + SourceNames.Customers + FileType.CSV
    val datePath = params.baseRawLocation() + SourceNames.Date + FileType.CSV
    val ordersPath = params.baseRawLocation() + SourceNames.Orders + FileType.CSV

    // Reading data
    val customersDF = ReadUtils.readTSVDataset[Customers](sparkSession, customersPath).toDF()
    val dateDF = ReadUtils.readTSVDataset[Date](sparkSession, datePath).toDF()
    val ordersDF = ReadUtils.readTSVDataFrame(sparkSession, ordersPath).toDF()


    // Return data
    Seq(
      customersDF,
      dateDF,
      ordersDF
    )
  }
}
