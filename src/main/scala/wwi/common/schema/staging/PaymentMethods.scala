package wwi.common.schema.staging

case class PaymentMethods(
                           PaymentMethodID:             Integer,
                           PaymentMethodName:           String,
                           LastEditedBy:                Integer,
                           ValidFrom:                   String,
                           ValidTo:                     String
                         )
