package wwi.transform.raw.parameters

import org.rogach.scallop.ScallopOption
import wwi.common.constants.Constants
import wwi.common.traits.RequiredParams
import wwi.utils.BaseParams

case class RawToStagingParameters(val arguments: Seq[String]) extends BaseParams(arguments) with RequiredParams {

  val baseRawLocation: ScallopOption[String] = stringParam(Constants.BaseRawLocation)
  val outputDatabase: ScallopOption[String] = stringParam(Constants.OutputDatabase)

  verify
}
