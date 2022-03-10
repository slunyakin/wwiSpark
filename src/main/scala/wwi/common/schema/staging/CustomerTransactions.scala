package wwi.common.schema.staging

import java.lang.Double

case class CustomerTransactions(
                                 CustomerTransactionID:             Integer,
                                 CustomerID:                        Integer,
                                 TransactionTypeID:                 Integer,
                                 InvoiceID:                         Integer,
                                 PaymentMethodID:                   Integer,
                                 TransactionDate:                   String,
                                 AmountExcludingTax:                Double,
                                 TaxAmount:                         Double,
                                 TransactionAmount:                 Double,
                                 OutstandingBalance:                Double,
                                 FinalizationDate:                  String,
                                 IsFinalized:                       Integer,
                                 LastEditedBy:                      Integer,
                                 LastEditedWhen:                    String
                               )
