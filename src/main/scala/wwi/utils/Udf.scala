package wwi.utils

import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

object Udf {
  def stringContains: UserDefinedFunction = udf((array: collection.mutable.WrappedArray[String], str: String) => array.contains(str))

  def randInt: UserDefinedFunction = udf((n: Integer) => scala.util.Random.nextInt(n))
}
