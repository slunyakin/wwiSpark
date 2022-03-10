package wwi.utils

import java.text.SimpleDateFormat
import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import org.rogach.scallop
import org.rogach.scallop.{ScallopConf, ScallopOption, ValueConverter}
import scala.util.{Failure, Success, Try}

import wwi.common.constants.Constants._

/**
 * Base class for Scallop (https://github.com/scallop/scallop/wiki) based parameter parsing component
 *
 * @param arguments
 */
class BaseParams(arguments: Seq[String]) extends ScallopConf(arguments) {

  def dateParam(name: String): ScallopOption[String] = opt[String](name, required = true, validate = isValidDate)

  def dateListParam(name: String, defaultValue: String): ScallopOption[String] =
    opt[String](name, default = Option(defaultValue))

  def stringParam(name: String): ScallopOption[String] = opt[String](name, required = true)

  // Method for optional parameters
  def optionalStringParam(name: String, defaultValue: String): ScallopOption[String] = opt[String](name, default = Option(defaultValue))
  def optionalIntParam(name: String, defaultValue: Int): ScallopOption[Int] = opt[Int](name, default = Option(defaultValue))

  def stringListParam(name: String): ScallopOption[List[String]] = opt[List[String]](name, required = true)

  def stringListParam(name: String, defaultValue: List[String]): ScallopOption[List[String]] =
    opt[List[String]](name, default = Option(defaultValue))

  def stringCommaSepListParam(name: String): ScallopOption[List[String]] = opt[List[String]](name, required = true)(commaSeparatedListConverter)

  def commaSeparatedListConverter: ValueConverter[List[String]] =
    scallop.singleArgConverter(_.split(',').toList)

  def configStringJsonParam(name: String): ScallopOption[JsonNode] = opt[JsonNode](name, required = true)(configJsonStringtoJsonNode)

  def configJsonStringtoJsonNode: ValueConverter[JsonNode] =
    scallop.singleArgConverter(configParseJson)


  def configParseJson(jsonString: String): JsonNode = {

    val mapper = new ObjectMapper()
    val jsonNode = mapper.readTree(jsonString.replace("\\","\\\\"))

    jsonNode
  }


  def doubleParam(name: String): ScallopOption[Double] = opt[Double](name, required = true)
  def intParam(name: String): ScallopOption[Int] = opt[Int](name, required = true)

  /**
   * Check if all the inputs in valid date format
   *
   * @param dates
   * @return
   */
  def isValidDate(dates: List[String]): Boolean = {
    val dateFormat = new SimpleDateFormat(PlatformDateFormat)

    Try(dates.map(date => dateFormat.parse(date).getTime)) match {
      case Success(v) => dates.nonEmpty
      case Failure(e) => false
    }
  }

  /**
   * Check if the input in valid date format
   *
   * @param date
   * @return
   */
  def isValidDate(date: String): Boolean = {
    isValidDate(List(date))
  }

  /**
   * Override Scallop default error handling, throw more reasonable exceptions than quit application quietly
   *
   * @param e
   */
  override def onError(e: Throwable): Unit = throw e
}
