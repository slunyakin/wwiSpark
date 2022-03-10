package wwi.common.traits

import org.rogach.scallop.ScallopOption

trait RequiredParams {

  val outputDatabase: ScallopOption[String]
}