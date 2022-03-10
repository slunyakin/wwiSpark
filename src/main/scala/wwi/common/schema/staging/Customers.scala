package wwi.common.schema.staging

import java.lang.Double

case class Customers(
                      CustomerID:                     Integer,
                      CustomerName:                   String,
                      BillToCustomerID:               Integer,
                      CustomerCategoryID:             Integer,
                      BuyingGroupID:                  Integer,
                      PrimaryContactPersonID:         Integer,
                      AlternateContactPersonID:       Integer,
                      DeliveryMethodID:               Integer,
                      DeliveryCityID:                 Integer,
                      PostalCityID:                   Integer,
                      CreditLimit:                    Double,
                      AccountOpenedDate:              String,
                      StandardDiscountPercentage:     Double,
                      IsStatementSent:                Integer,
                      IsOnCreditHold:                 Integer,
                      PaymentDays:                    Integer,
                      PhoneNumber:                    String,
                      FaxNumber:                      String,
                      DeliveryRun:                    String,
                      RunPosition:                    String,
                      WebsiteURL:                     String,
                      DeliveryAddressLine1:           String,
                      DeliveryAddressLine2:           String,
                      DeliveryPostalCode:             String,
                      PostalAddressLine1:             String,
                      PostalAddressLine2:             String,
                      PostalPostalCode:               String,
                      LastEditedBy:                   Integer,
                      ValidFrom:                      String,
                      ValidTo:                        String
                    )
