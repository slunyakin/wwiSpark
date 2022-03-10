package wwi.data

import org.apache.spark.sql.{DataFrame, Dataset, Row}

import wwi.transform.dwh.dimensions.SparkSuiteBase
import wwi.common.schema.staging.{Cities, StateProvince, Countries}

object DimensionsTestData {

  val sparkSession = SparkSuiteBase.sparkContext

  import sparkSession.implicits._


  val citiesData = sparkSession.createDataset(Seq(Cities(9,	"Abbotsford",	52,	2310,	1,	"2013-01-01 00:00:00.0000000",	"9999-12-31 23:59:59.9999999"),
    Cities(10,	"Abbott",	45,	356,	1,	"2013-01-01 00:00:00.0000000",	"9999-12-31 23:59:59.9999999"),
    Cities(11,	"Abbott",	4,	356,	1,	"2013-01-01 00:00:00.0000000",	"9999-12-31 23:59:59.9999999"),
    Cities(12,	"Abbott",	32, null ,	1,	"2013-01-01 00:00:00.0000000",	"9999-12-31 23:59:59.9999999"),
    Cities(13,	"Abbott",	49,	356,	1,	"2013-01-01 00:00:00.0000000",	"9999-12-31 23:59:59.9999999"),
    Cities(14,	"Abbott", 51, null,	1, "2013-01-01 00:00:00.0000000",	"9999-12-31 23:59:59.9999999")
  ))

  val stateProvinceData = sparkSession.createDataset(Seq(StateProvince(4,"AR","Arkansas",230,"Southeast",3077747,8,"2014-07-01 16:00:00.0000000","9999-12-31 23:59:59.9999999"),
    StateProvince(32,"NM","New Mexico",230,"Southwest",2345662,15,"2015-07-01 16:00:00.0000000","9999-12-31 23:59:59.9999999"),
    StateProvince(45,"TX","Texas",230,"Southwest",27506120,20,"2013-07-01 16:00:00.0000000","9999-12-31 23:59:59.9999999"),
    StateProvince(49,"VA","Virginia",230,"Southeast",8260405,1,"2013-01-01 00:03:00.0000000","9999-12-31 23:59:59.9999999"),
    StateProvince(51,"WV","West Virginia",230,"Southeast",2085839,15,"2015-07-01 16:00:00.0000000","9999-12-31 23:59:59.9999999"),
    StateProvince(52,"WI","Wisconsin",230,"Great Lakes",6211317,15,"2015-07-01 16:00:00.0000000","9999-12-31 23:59:59.9999999")
  ))

  val countriesData = sparkSession.createDataset(Seq(Countries(230,	"United States",	"United States of America",	"USA",	840,	"UN Member State",	313973000,	"North America",	"Americas",	"Northern", "America",	1,	"2013-01-01 00:00:00.0000000",	"9999-12-31 23:59:59.9999999")))
}
