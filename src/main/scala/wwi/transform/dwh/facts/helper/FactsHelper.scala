package wwi.transform.dwh.facts.helper

import org.apache.spark.sql.functions.{col, round}
import org.apache.spark.sql.{Column, DataFrame}
import wwi.common.domain.facts.Order
import wwi.common.domain.staging._
import wwi.utils.JoinUtils._

object FactsHelper {

  implicit class filters(df: DataFrame) {

    def filterByColumn(columnName: String, columnValue: String): DataFrame = {
      df.filter(col(columnName) === columnValue)
    }
  }

  def calculateTotal(quantity: Column, unitPrice: Column): Column = {
    quantity * unitPrice
  }

  def transformOrderFact(ordersDF: DataFrame, orderLinesDF: DataFrame, packageTypesDF: DataFrame, customersDF: DataFrame): DataFrame = {

    val orderFactDF =
      ordersDF
        .innerJoin(orderLinesDF, ordersDF(Orders.Fields.OrderID) === orderLinesDF(OrderLines.Fields.OrderID))
        .innerJoin(packageTypesDF, Seq(OrderLines.Fields.PackageTypeID))
        .innerJoin(customersDF, customersDF(Customers.Fields.CustomerID) === ordersDF(Orders.Fields.CustomerID))
        .select(
          ordersDF(Orders.Fields.OrderDate).as(Order.Fields.OrderDateKey),
          orderLinesDF(OrderLines.Fields.PickingCompletedWhen).as(Order.Fields.PickedDateKey),
          ordersDF(Orders.Fields.OrderID).as(Order.Fields.WWIOrderId),
          ordersDF(Orders.Fields.BackorderOrderID).as(Order.Fields.WWIBackorderId),
          orderLinesDF(OrderLines.Fields.Description).as(Order.Fields.Description),
          packageTypesDF(PackageTypes.Fields.PackageTypeName).as(Order.Fields.Package),
          orderLinesDF(OrderLines.Fields.Quantity).as(Order.Fields.Quantity),
          orderLinesDF(OrderLines.Fields.UnitPrice).as(Order.Fields.UnitPrice),
          orderLinesDF(OrderLines.Fields.TaxRate).as(Order.Fields.TaxRate),
          round(calculateTotal(orderLinesDF(OrderLines.Fields.Quantity) ,orderLinesDF(OrderLines.Fields.UnitPrice)), 2).as(Order.Fields.TotalExcludingTax),
          round(orderLinesDF(OrderLines.Fields.Quantity) * orderLinesDF(OrderLines.Fields.UnitPrice) * orderLinesDF(OrderLines.Fields.TaxRate)/100.0, 2).as(Order.Fields.TaxAmount),
          (round(orderLinesDF(OrderLines.Fields.Quantity) * orderLinesDF(OrderLines.Fields.UnitPrice), 2) + round(orderLinesDF(OrderLines.Fields.Quantity) * orderLinesDF(OrderLines.Fields.UnitPrice) * orderLinesDF(OrderLines.Fields.TaxRate)/100.0, 2)).as(Order.Fields.TotalIncludingTax),
          customersDF(Customers.Fields.DeliveryCityID).as(Order.Fields.CityKey),
          customersDF(Customers.Fields.CustomerID).as(Order.Fields.CustomerKey),
          orderLinesDF(OrderLines.Fields.StockItemID).as(Order.Fields.StockItemKey),
          ordersDF(Orders.Fields.SalespersonPersonID).as(Order.Fields.SalespersonKey),
          ordersDF(Orders.Fields.PickedByPersonID).as(Order.Fields.PickerKey)
        )

    orderFactDF
  }

}
