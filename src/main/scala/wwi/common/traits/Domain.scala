package wwi.common.traits

import org.apache.spark.sql.types.StructType

import wwi.common.constants.Constants
import wwi.common.domain.CommonEntity.Fields.{TaxRate, Amount}
import wwi.common.domain.CommonEntity
import wwi.utils.enums.FileType.{FileType, PARQUET}

trait Domain {

  /**
    * For all select in code, for choose only that columns what we need, for use same columns ordering
    */
  val columnList: Seq[String]

  /**
    * Map dataset enum to partition by columns
    *
    * default: Guid,Period
    */
  val partitionByColumns: Seq[String] = Seq[String](CommonEntity.Fields.Guid, CommonEntity.Fields.Period)


  val aggColumns: Option[Seq[String]] = Option(Seq[String](TaxRate, Amount))
  val fileType:FileType = PARQUET
  val schema: StructType = StructType(Seq())
  val header: String = Constants.True
}