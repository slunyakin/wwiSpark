package wwi.utils.save

import org.apache.spark.sql._

object SaveUtils {

  implicit class SaveTableHelper(df: DataFrame) {

    /**
     * This method runs the save table in hive
     *
     * @param tableName      - table name
     */
    def saveAsTable(tableName: String) = {

      df.write
        .mode(SaveMode.Overwrite)
        .format("parquet")
        .saveAsTable(tableName)
    }

    /**
     * This method runs the save table in hive with separate location
     *
     * @param tableName      - table name
     * @param outputFullPath - output files location
     */
    def saveAsTable(tableName: String, outputFullPath: String): Unit = {

      df.write
        .mode(SaveMode.Overwrite)
        .format("parquet")
        .option("path", outputFullPath)
        .saveAsTable(tableName)
    }

    /**
     * This method runs the save table in hive
     *
     * @param tableName      - table name
     * @param outputFullPath - output files location
     * @param partitionCols  - partition by columns
     */
    def saveAsTable(tableName: String, outputFullPath: String, partitionCols: Seq[String]): Unit = {

      df.write
        .partitionBy(partitionCols: _*)
        .mode(SaveMode.Overwrite)
        .format("parquet")
        .option("path", outputFullPath)
        .saveAsTable(tableName)
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
  }
}
