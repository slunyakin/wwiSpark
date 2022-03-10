package wwi.common.schema.staging

import java.lang.Double

case class StockItemTransactions(
                                  StockItemTransactionID:                 Integer,
                                  StockItemID:                            Integer,
                                  TransactionTypeID:                      Integer,
                                  CustomerID:                             Integer,
                                  InvoiceID:                              Integer,
                                  SupplierID:                             Integer,
                                  PurchaseOrderID:                        Integer,
                                  TransactionOccurredWhen:                String,
                                  Quantity:                               Double,
                                  LastEditedBy:                           Integer,
                                  LastEditedWhen:                         String
                                )
