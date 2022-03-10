package wwi.common.schema.staging

case class Date(
                 Date:                    String,
                 DayNumber:               Integer,
                 Day:                     String,
                 Month:                   String,
                 ShortMonth:              String,
                 CalendarMonthNumber:     Integer,
                 CalendarMonthLabel:      String,
                 CalendarYear:            Integer,
                 CalendarYearLabel:       String,
                 FiscalMonthNumber:       Integer,
                 FiscalMonthLabel:        String,
                 FiscalYear:              Integer,
                 FiscalYearLabel:         String,
                 ISOWeekNumber:           Integer
               )
