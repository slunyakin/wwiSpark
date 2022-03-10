package wwi.utils

import org.apache.spark.sql.types.StructField

object ImplicitsHelper {

  implicit val converter: StructField => String = (sf) => sf.name

}
