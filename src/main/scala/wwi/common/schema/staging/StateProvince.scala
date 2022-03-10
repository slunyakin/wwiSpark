package wwi.common.schema.staging

case class StateProvince(
                          stateProvinceID:              Integer,
                          stateProvinceCode:            String,
                          stateProvinceName:            String,
                          countryID:                    Integer,
                          salesTerritory:               String,
                          latestRecordedPopulation:     Integer,
                          lastEditedBy:                 Integer,
                          validFrom:                    String,
                          validTo:                      String
                        )
