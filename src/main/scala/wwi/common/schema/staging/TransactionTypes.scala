package wwi.common.schema.staging

case class TransactionTypes(
                             TransactionTypeID:               Integer,
                             TransactionTypeName:             String,
                             LastEditedBy:                    Integer,
                             ValidFrom:                       String,
                             ValidTo:                         String
                           )
