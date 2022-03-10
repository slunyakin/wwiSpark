package wwi.transform.dwh.dimensions.parameters

import org.rogach.scallop.ScallopOption

import wwi.common.constants.Constants
import wwi.common.traits.RequiredParams
import wwi.utils.BaseParams

case class PopulateDimsParameters(val arguments: Seq[String]) extends BaseParams(arguments) with RequiredParams {

  val inboundDatabase: ScallopOption[String] = stringParam(Constants.InboundDatabase)
  val outputDatabase: ScallopOption[String] = stringParam(Constants.OutputDatabase)

  verify

}