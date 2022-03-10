package wwi.common.schema.staging

case class People(
                   PersonID:                  Integer,
                   FullName:                  String,
                   PreferredName:             String,
                   SearchName:                String,
                   IsPermittedToLogon:        String,
                   LogonName:                 String,
                   IsExternalLogonProvider:   String,
                   IsSystemUser:              String,
                   IsEmployee:                String,
                   IsSalesperson:             String,
                   UserPreferences:           String,
                   PhoneNumber:               String,
                   FaxNumber:                 String,
                   EmailAddress:              String,
                   CustomFields:              String,
                   OtherLanguages:            String,
                   LastEditedBy:              Integer,
                   ValidFrom:                 String,
                   ValidTo:                   String
                 )
