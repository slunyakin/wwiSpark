package wwi.common.schema.staging

case class Countries(
                      countryID:                      Integer,
                      countryName:                    String,
                      formalName:                     String,
                      isoAlpha3Code:                  String,
                      isoNumericCode:                 Integer,
                      countryType:                    String,
                      latestRecordedPopulation:       Integer,
                      continent:                      String,
                      region:                         String,
                      subregion:                      String,
                      border:                         String,
                      lastEditedBy:                   Integer,
                      validFrom:                      String,
                      validTo:                        String
                    )
