package wwi.common.schema.staging

case class Invoices(
                     InvoiceID:                           Integer,
                     CustomerID:                          Integer,
                     BillToCustomerID:                    Integer,
                     OrderID:                             Integer,
                     DeliveryMethodID:                    Integer,
                     ContactPersonID:                     Integer,
                     AccountsPersonID:                    Integer,
                     SalespersonPersonID:                 Integer,
                     PackedByPersonID:                    Integer,
                     InvoiceDate:                         Integer,
                     CustomerPurchaseOrderNumber:         String,
                     IsCreditNote:                        Integer,
                     CreditNoteReason:                    String,
                     Comments:                            String,
                     DeliveryInstructions:                String,
                     InternalComments:                    String,
                     TotalDryItems:                       Integer,
                     TotalChillerItems:                   Integer,
                     DeliveryRun:                         String,
                     RunPosition:                         String,
                     ReturnedDeliveryData:                String,
                     ConfirmedDeliveryTime:               String,
                     ConfirmedReceivedBy:                 String,
                     LastEditedBy:                        Integer,
                     LastEditedWhen:                      String
                   )
