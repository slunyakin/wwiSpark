package wwi.common.domain.dimensions

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object PaymentMethodDim {

  object Fields {
    val WWIPaymentMethodID = "wwiPaymentMethodId"
    val PaymentMethod = "paymentMethod"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(WWIPaymentMethodID, IntegerType),
    StructField(PaymentMethod, StringType)
  ))

  val columnList = Seq(
    WWIPaymentMethodID,
    PaymentMethod
  )

}
