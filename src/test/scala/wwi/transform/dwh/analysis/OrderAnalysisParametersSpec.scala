package wwi.transform.dwh.analysis
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers
import wwi.transform.dwh.analysis.parameters.OrderAnalysisParameters
import wwi.common.constants.Constants

class OrderAnalysisParametersSpec extends AsyncFlatSpec with Matchers {

  "OrderAnalysisParameters" should "correctly parse valid arguments" in {
    // Arrange
    val args = Array(
      s"--${Constants.BaseRawLocation}", "/path/to/raw",
      s"--${Constants.OutputDatabase}", "my_output_db"
    )

    // Act
    val params = new OrderAnalysisParameters(args)

    // Assert
    assert(params.baseRawLocation.toOption.contains("/path/to/raw"), "baseRawLocation should be correctly parsed")
    assert(params.outputDatabase.toOption.contains("my_output_db"), "outputDatabase should be correctly parsed")

    succeed
  }

  it should "fail when required parameters are missing" in {
    // Arrange
    val args = Array.empty[String]

    // Act & Assert
    assertThrows[Exception] {
      new OrderAnalysisParameters(args)
    }

    succeed
  }

}
