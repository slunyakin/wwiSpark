package wwi.utils

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Column, DataFrame}

object JoinUtils {

  implicit class JoinUtils(df: DataFrame) {

    def leftJoin(secondDf: DataFrame, joinExpression: Column): DataFrame = {
      df.join(secondDf, joinExpression, JoinTypes.LEFT)
    }

    def leftJoin(secondDf: DataFrame, joinExpression: Column, dropRight: Boolean): DataFrame = {
      if (dropRight) {
        val columnsLeft = df.columns
        val columnsRight = secondDf.columns.filterNot(columnsLeft.contains(_))
        val expr = columnsLeft.map(df(_)) ++ columnsRight.map(secondDf(_))

        df.join(secondDf, joinExpression, JoinTypes.LEFT)
          .select(expr: _*)

      } else {
        df.join(secondDf, joinExpression, JoinTypes.LEFT)
      }
    }

    def leftJoin(secondDf: DataFrame, column: String): DataFrame = {
      df.join(secondDf, Seq(column), JoinTypes.LEFT)
        .drop(secondDf(column))
    }

    def leftJoin(secondDf: DataFrame, columns: Seq[String]): DataFrame = {
      val expr = df.columns.map(df(_)) ++ secondDf.columns.filterNot(columns.toArray.contains(_)).map(secondDf(_))
      df.join(secondDf, columns, JoinTypes.LEFT).select(expr: _*)
    }

    def leftJoin(secondDf: DataFrame, columns: Seq[String], dropRight: Boolean): DataFrame = {
      if (dropRight) {
        val columnsLeft = df.columns
        val columnsRight = secondDf.columns.filterNot(columnsLeft.contains(_))
        val expr = columnsLeft.map(df(_)) ++ columnsRight.map(col(_))

        df.join(secondDf, columns, JoinTypes.LEFT)
          .select(expr: _*)
      } else {
        df.join(secondDf, columns, JoinTypes.LEFT)
      }
    }

    def rightJoin(secondDf: DataFrame, joinExpression: Column): DataFrame = {
      df.join(secondDf, joinExpression, JoinTypes.RIGHT)
    }

    def rightJoin(secondDf: DataFrame, column: String): DataFrame = {
      df.join(secondDf, Seq(column), JoinTypes.RIGHT)
        .drop(secondDf(column))
    }

    def rightJoin(secondDf: DataFrame, columns: Seq[String]): DataFrame = {
      val expr = df.columns.map(df(_)) ++ secondDf.columns.filterNot(columns.toArray.contains(_)).map(secondDf(_))
      df.join(secondDf, columns, JoinTypes.RIGHT).select(expr: _*)
    }

    def innerJoin(secondDf: DataFrame, joinExpression: Column): DataFrame = {
      df.join(secondDf, joinExpression, JoinTypes.INNER)
    }

    def innerJoin(secondDf: DataFrame, column: String): DataFrame = {
      df.join(secondDf, Seq(column), JoinTypes.INNER)
        .drop(secondDf(column))
    }

    def innerJoin(secondDf: DataFrame, columns: Seq[String]): DataFrame = {
      df.join(secondDf, columns, JoinTypes.INNER)
    }

    def innerJoin(secondDf: DataFrame, columns: Seq[String], dropRight: Boolean): DataFrame = {
      if (dropRight) {
        val columnsLeft = df.columns
        val columnsRight = secondDf.columns.filterNot(columnsLeft.contains(_))
        val expr = columnsLeft.map(df(_)) ++ columnsRight.map(col(_))

        df.join(secondDf, columns, JoinTypes.INNER)
          .select(expr: _*)

      } else {
        df.join(secondDf, columns, JoinTypes.INNER)
      }
    }

    def innerJoin(secondDf: DataFrame, joinExpression: Column, dropRight: Boolean): DataFrame = {
      if (dropRight) {
        val columnsLeft = df.columns
        val columnsRight = secondDf.columns.filterNot(columnsLeft.contains(_))
        val expr = columnsLeft.map(df(_)) ++ columnsRight.map(secondDf(_))

        df.join(secondDf, joinExpression, JoinTypes.INNER)
          .select(expr: _*)

      } else {
        df.join(secondDf, joinExpression, JoinTypes.INNER)
      }
    }

    def leftAntiJoin(secondDf: DataFrame, joinExpression: Column): DataFrame = {
      df.join(secondDf, joinExpression, JoinTypes.LEFT_ANTI)
    }

    def leftAntiJoin(secondDf: DataFrame, column: String): DataFrame = {
      df.join(secondDf, Seq(column), JoinTypes.LEFT_ANTI)
        .drop(secondDf(column))
    }

    def leftAntiJoin(secondDf: DataFrame, columns: Seq[String]): DataFrame = {
      df.join(secondDf, columns, JoinTypes.LEFT_ANTI)
    }

    def leftSemiJoin(secondDf: DataFrame, joinExpression: Column): DataFrame = {
      df.join(secondDf, joinExpression, JoinTypes.LEFT_SEMI)
    }

    def leftSemiJoin(secondDf: DataFrame, column: String): DataFrame = {
      df.join(secondDf, Seq(column), JoinTypes.LEFT_SEMI)
    }

    def outerJoin(secondDf: DataFrame, columns: Seq[String]): DataFrame = {
      df.join(secondDf, columns, JoinTypes.OUTER)
    }

  }
}
