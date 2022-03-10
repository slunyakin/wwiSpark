package wwi.transform.dwh.dimensions

import org.apache.spark.sql.SparkSession

// This object would help us avoid creating SparkContext again and again
object SparkSuiteBase {
  lazy val sparkContext = SparkSession.builder.
    master("local")
    .appName("Spark Test")
    .config("spark.driver.host", "localhost")
    .config("spark.sql.shuffle.partitions", "2")
    .config("spark.sql.legacy.timeParserPolicy", "LEGACY")
    .getOrCreate()
}
