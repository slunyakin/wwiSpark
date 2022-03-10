package wwi.common.domain.dimensions

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object DateDim {

  object Fields {
    val Date = "date"
    val DayNumber = "dayNumber"
    val Day = "day"
    val Month = "month"
    val ShortMonth = "shortMonth"
    val CalendarMonthNumber = "calendarMonthNumber"
    val CalendarMonthLabel = "calendarMonthLabel"
    val CalendarYear = "calendarYear"
    val CalendarYearLabel ="calendarYearLabel"
    val FiscalMonthNumber = "fiscalMonthNumber"
    val FiscalMonthLabel = "fiscalMonthLabel"
    val FiscalYear = "fiscalMonth"
    val FiscalYearLabel = "fiscalYearLabel"
    val ISOWeekNumber = "isoWeekNumber"
  }

  import Fields._

  val schema: StructType = StructType(Seq(
    StructField(Date, StringType),
    StructField(DayNumber, IntegerType),
    StructField(Day, StringType),
    StructField(Month, StringType),
    StructField(ShortMonth, StringType),
    StructField(CalendarMonthNumber, IntegerType),
    StructField(CalendarMonthLabel, StringType),
    StructField(CalendarYear, IntegerType),
    StructField(CalendarYearLabel, StringType),
    StructField(FiscalMonthNumber, IntegerType),
    StructField(FiscalMonthLabel, StringType),
    StructField(FiscalYear, IntegerType),
    StructField(FiscalYearLabel, StringType),
    StructField(ISOWeekNumber, IntegerType)
  ))

  val columnList = Seq(
    Date,
    DayNumber,
    Day,
    Month,
    ShortMonth,
    CalendarMonthNumber,
    CalendarMonthLabel,
    CalendarYear,
    CalendarYearLabel,
    FiscalMonthNumber,
    FiscalMonthLabel,
    FiscalYear,
    FiscalYearLabel,
    ISOWeekNumber
  )

}
