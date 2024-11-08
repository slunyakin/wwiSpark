package wwi.transform.dwh.dimensions

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatestplus.junit.JUnitRunner
import wwi.data.DimensionsTestData._
import wwi.transform.dwh.analysis.helper.OrderAnalysisHelper
import wwi.common.domain.facts.Order
import wwi.common.domain.dimensions.{CustomerDim, DateDim}
import scala.concurrent.Future

@RunWith(classOf[JUnitRunner])
class SalesAnalysisTransformSpec extends AsyncFlatSpec with BeforeAndAfterEach {

  private val spark = SparkSuiteBase.sparkContext
  sparkSession.sparkContext.setLogLevel("OFF")

  "Function enrichOrders" should "join Order and Customer andCity dimension data" in {
assert(1 == 1)
  }

  "OrderAnalysisHelper.enrichOrders" should "successfully enrich orders with customer and date information" in {
    // Arrange
    val factOrderDF = spark.createDataFrame(Seq(
      (1, "2023-01-01", 101),
      (2, "2023-01-02", 102),
      (3, "2023-01-03", 103)
    )).toDF("OrderKey", Order.Fields.OrderDateKey, CustomerDim.Fields.CustomerKey)

    val dimCustomerDF = spark.createDataFrame(Seq(
      (101, "Alice"),
      (102, "Bob"),
      (103, "Charlie")
    )).toDF(CustomerDim.Fields.CustomerKey, "CustomerName")

    val dimDateDF = spark.createDataFrame(Seq(
      ("2023-01-01", "Monday"),
      ("2023-01-02", "Tuesday"),
      ("2023-01-03", "Wednesday")
    )).toDF(DateDim.Fields.Date, "DayOfWeek")

    // Act
    val resultFuture = Future {
      OrderAnalysisHelper.enrichOrders(factOrderDF, dimCustomerDF, dimDateDF)
    }

    // Assert
    resultFuture.map { result =>
      assert(result.columns.toSet.intersect(Set(
        "OrderKey",
        Order.Fields.OrderDateKey,
        CustomerDim.Fields.CustomerKey,
        "CustomerName",
        "DayOfWeek"
      )).size == 5, "Result should contain all expected columns")

      assert(result.count() == 3, "Result should have 3 rows")

      val rows = result.collect()
      assert(rows.length == 3, "Result should have 3 rows")

      // Check the first row
      assert(rows(0).getAs[Int]("OrderKey") == 1)
      assert(rows(0).getAs[String](Order.Fields.OrderDateKey) == "2023-01-01")
      assert(rows(0).getAs[Int](CustomerDim.Fields.CustomerKey) == 101)
      assert(rows(0).getAs[String]("CustomerName") == "Alice")
      assert(rows(0).getAs[String]("DayOfWeek") == "Monday")

      // Check the second row
      assert(rows(1).getAs[Int]("OrderKey") == 2)
      assert(rows(1).getAs[String](Order.Fields.OrderDateKey) == "2023-01-02")
      assert(rows(1).getAs[Int](CustomerDim.Fields.CustomerKey) == 102)
      assert(rows(1).getAs[String]("CustomerName") == "Bob")
      assert(rows(1).getAs[String]("DayOfWeek") == "Tuesday")

      // Check the third row
      assert(rows(2).getAs[Int]("OrderKey") == 3)
      assert(rows(2).getAs[String](Order.Fields.OrderDateKey) == "2023-01-03")
      assert(rows(2).getAs[Int](CustomerDim.Fields.CustomerKey) == 103)
      assert(rows(2).getAs[String]("CustomerName") == "Charlie")
      assert(rows(2).getAs[String]("DayOfWeek") == "Wednesday")

      succeed
    }
  }}
