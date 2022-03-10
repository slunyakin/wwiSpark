package wwi.utils.read

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql._
import org.apache.spark.sql.types._

import wwi.utils.enums.SourceNames

object ReadUtils {

  /**
   * Read TSV format input with specific Type(Case Class) definition
   *
   * @param sparkSession Spark Session Context
   * @param inputFullPath Full S3/HDFS Prefix
   * @return Dataset Object with the Schema
   */
  def readTSVDataset[T: Encoder](sparkSession: SparkSession, inputFullPath: String): Dataset[T] = {
    val schema = implicitly[Encoder[T]].schema
    readTSVDataFrame(sparkSession, inputFullPath, schema).as[T]
  }

  /**
   * Read TSV format input with specific Type(Case Class) definition
   *
   * @param sparkSession Spark Session Context
   * @param inputFullPath List of S3/HDFS Paths
   * @return Dataset Object with the Schema
   */
  def readTSVDatasetMutliplePaths[T: Encoder](sparkSession: SparkSession, inputFullPath: List[String]): Dataset[T] = {
    val schema = implicitly[Encoder[T]].schema
    readTSVDataFrameMutliplePaths(sparkSession, schema, inputFullPath:_*).as[T]
  }

  /**
   * Read TSV format input with headers
   *
   * @param sparkSession Spark Session Context
   * @param inputFullPath Full S3/HDFS Prefix
   * @return DataFrame object
   */
  def readTSVDataFrame(sparkSession: SparkSession, inputFullPath: String): DataFrame =
    sparkSession.read
      .option("header", "true")
      .option("delimiter", "\t")
      .option("mode", "PERMISSIVE")
      .option("timestampFormat", "yyyy/MM/dd HH:mm:ss ZZ") //TODO : Need to fix this.
      .csv(inputFullPath)

  /**
   * Read TSV format input with specific schema definition
   *
   * @param sparkSession Spark Session Context
   * @param inputFullPath Full S3/HDFS Prefix
   * @param schema Schema of dataset
   * @return DataFrame object
   */
  def readTSVDataFrame(sparkSession: SparkSession, inputFullPath: String, schema: StructType): DataFrame =
    sparkSession.read
      .option("header", "true")
      .option("delimiter", "\t")
      .option("mode", "PERMISSIVE")
      .schema(schema)
      .option("timestampFormat", "yyyy/MM/dd HH:mm:ss ZZ") //TODO : Need to fix this.
      .csv(inputFullPath)

  /**
   * Read TSV format input with specific schema definition
   *
   * @param sparkSession Spark Session Context
   * @param schema Schema of dataset
   * @param inputFullPath List of S3/HDFS Paths
   * @return DataFrame object
   */
  def readTSVDataFrameMutliplePaths(sparkSession: SparkSession, schema: StructType, inputFullPath: String*): DataFrame =
    sparkSession.read
      .option("header", "false")
      .option("delimiter", "\t")
      .schema(schema)
      .option("timestampFormat", "yyyy/MM/dd HH:mm:ss ZZ") //TODO : Need to fix this.
      .csv(inputFullPath:_*)

  /**
   * Read CSV format input with specific Type(Case Class) definition
   *
   * @param sparkSession Spark Session Context
   * @param inputFullPath Full S3/HDFS Prefix
   * @return Dataset Object with the Schema
   */
  def readCSVDataset[T: Encoder](sparkSession: SparkSession, inputFullPath: String): Dataset[T] = {
    val schema = implicitly[Encoder[T]].schema
    readCSVDataFrame(sparkSession, inputFullPath, schema).as[T]
  }

  /**
   * Read CSV format input with specific schema definition
   *
   * @param sparkSession Spark Session Context
   * @param inputFullPath Full S3/HDFS Prefix
   * @param schema Dataset Object with the Schema
   * @return
   */
  def readCSVDataFrame(sparkSession: SparkSession, inputFullPath: String, schema: StructType): DataFrame =
    sparkSession.read
      .option("header", "false")
      .option("delimiter", ",")
      .schema(schema)
      .option("timestampFormat", "yyyy/MM/dd HH:mm:ss ZZ") //TODO : Need to fix this.
      .csv(inputFullPath)

  /**
   * Save data frame as one combined files.
   *
   * @param dataframe DataFrame
   * @param outputFullPath Full Prefix Path for Dataframe
   */
  def saveAsOneCombinedTsvDataset(dataframe: DataFrame, outputFullPath: String): Unit = {
    dataframe
      .repartition(1)
      .write
      .mode(SaveMode.Overwrite)
      .option("sep", "\t")
      .option("treatEmptyValuesAsNulls","true")
      .option("nullValue", null)
      .csv(outputFullPath)
  }

  /**
   * Save data frame as TSV with
   * combination of files.
   *
   * @param dataframe DataFrame
   * @param outputFullPath Full Prefix Path for Dataframe
   */
  def saveTsvDataset(dataframe: DataFrame, outputFullPath: String): Unit = {
    dataframe
      .write
      .mode(SaveMode.Overwrite)
      .option("quoteMode","NONE")
      //.option("nullValue", "unknown")
      .option("treatEmptyValuesAsNulls", "True")
      .option("sep", "\t")
      .csv(outputFullPath)
  }

  /** Overloaded method with repartition parameter to Save data frame as TSV with
   * combination of files.
   *
   * @param dataframe DataFrame
   * @param outputFullPath Full Prefix Path for Dataframe
   * @param numPartitions Number of partitions
   */
  def saveTsvDataset(dataframe: DataFrame, outputFullPath: String, numPartitions: Integer): Unit = {
    dataframe
      .repartition(numPartitions)
      .write
      .mode(SaveMode.Overwrite)
      .option("sep", "\t")
      .csv(outputFullPath)
  }

  /** Save data frame as TSV with partition columns parameter
   * combination of files.
   * @param dataframe DataFrame
   * @param outputFullPath Full Prefix Path for Dataframe
   * @param partitionCols Partition columns
   */
  def saveTsvDataset(dataframe: DataFrame, outputFullPath: String, partitionCols: String*): Unit = {
    dataframe
      .write
      .partitionBy(partitionCols:_*)
      .mode(SaveMode.Overwrite)
      .option("sep", "\t")
      .csv(outputFullPath)
  }

  /** Save data frame as TSV with partition columns and number of partition as parameter
   * combination of files.
   * @param dataframe DataFrame
   * @param outputFullPath Full Prefix Path for Dataframe
   * @param numPartitions Number of partitions
   * @param partitionCols Partition columns
   */
  def saveTsvDataset(dataframe: DataFrame, outputFullPath: String, numPartitions: Integer, partitionCols: String*): Unit = {
    dataframe
      .repartition(numPartitions)
      .write
      .partitionBy(partitionCols:_*)
      .mode(SaveMode.Overwrite)
      .option("sep", "\t")
      .csv(outputFullPath)
  }

  implicit class ReadTableHelper(sparkSession: SparkSession) {
    /**
     * This method runs the read table in hive catalog
     *
     * @param dataset       - dataset
     * @param inputDatabase - inputDatabase
     */
    def readTable(
                   dataset: SourceNames.Value,
                   inputDatabase: String
                 ): DataFrame = {

      sparkSession.read.table(inputDatabase + "." + dataset)

    }
  }
}
