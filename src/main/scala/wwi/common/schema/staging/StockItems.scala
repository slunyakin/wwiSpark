package wwi.common.schema.staging

import java.lang.Double

case class StockItems(
                       StockItemID:                     Integer,
                       StockItemName:                   String,
                       SupplierID:                      Integer,
                       ColorID:                         Integer,
                       UnitPackageID:                   Integer,
                       OuterPackageID:                  Integer,
                       Brand:                           String,
                       Size:                            String,
                       LeadTimeDays:                    Integer,
                       QuantityPerOuter:                Integer,
                       IsChillerStock:                  Integer,
                       Barcode:                         String,
                       TaxRate:                         Double,
                       UnitPrice:                       Double,
                       RecommendedRetailPrice:          Double,
                       TypicalWeightPerUnit:            Double,
                       MarketingComments:               String,
                       InternalComments:                String,
                       CustomFields:                    String,
                       Tags:                            String,
                       SearchDetails:                   String,
                       LastEditedBy:                    Integer,
                       ValidFrom:                       String,
                       ValidTo:                         String
                     )
