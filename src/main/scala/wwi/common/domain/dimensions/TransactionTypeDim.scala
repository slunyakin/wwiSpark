package wwi.common.domain.dimensions

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object TransactionTypeDim {

  object Fields {
    val WWITransactionTypeID = "wwiTransactionTypeId"
    val TransactionType = "transactionType"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(WWITransactionTypeID, IntegerType),
    StructField(TransactionType, StringType)
  ))

  val columnList = Seq(
    WWITransactionTypeID,
    TransactionType
  )

}
