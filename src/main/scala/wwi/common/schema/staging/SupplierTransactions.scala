package wwi.common.schema.staging

case class SupplierTransactions(
                                 SupplierTransactionID:               Integer,
                                 SupplierID:                          Integer,
                                 TransactionTypeID:                   Integer,
                                 PurchaseOrderID:                     Integer,
                                 PaymentMethodID:                     Integer,
                                 SupplierInvoiceNumber:               String,
                                 TransactionDate:                     String,
                                 AmountExcludingTax:                  Double,
                                 TaxAmount:                           Double,
                                 TransactionAmount:                   Double,
                                 OutstandingBalance:                  Double,
                                 FinalizationDate:                    String,
                                 IsFinalized:                         Integer,
                                 LastEditedBy:                        Integer,
                                 LastEditedWhen:                      String
                               )
