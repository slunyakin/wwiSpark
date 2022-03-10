package wwi.common.schema.staging

case class Cities(
                   cityID:                      Integer,
                   cityName:                    String,
                   stateProvinceID:             Integer,
                   latestRecordedPopulation:    Integer,
                   lastEditedBy:                Integer,
                   validFrom:                   String,
                   validTo:                     String
                 )
