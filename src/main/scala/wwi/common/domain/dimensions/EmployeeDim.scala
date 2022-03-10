package wwi.common.domain.dimensions

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object EmployeeDim {

  object Fields {
    val WWIEmployeeID = "wwiEmployeeId"
    val Employee = "employee"
    val PreferredName = "preferredName"
    val IsSalesPerson = "isSalesPerson"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(WWIEmployeeID, IntegerType),
    StructField(Employee, StringType),
    StructField(PreferredName, StringType),
    StructField(IsSalesPerson, IntegerType)
  ))

  val columnList = Seq(
    WWIEmployeeID,
    Employee,
    PreferredName,
    IsSalesPerson
  )

}
