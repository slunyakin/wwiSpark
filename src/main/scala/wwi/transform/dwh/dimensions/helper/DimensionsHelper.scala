package wwi.transform.dwh.dimensions.helper

import org.apache.spark.sql.{Column, DataFrame}
import org.apache.spark.sql.functions.{col, upper}
import wwi.common.domain.dimensions.{CityDim, CustomerDim}
import wwi.common.domain.staging.{BuyingGroups, Cities, Countries, CustomerCategories, Customers, People, StateProvince}
import wwi.common.domain.dimensions.EmployeeDim
import wwi.utils.JoinUtils._

import scala.reflect.internal.util.TriState.True

object DimensionsHelper {
  implicit class transformationLogic(df: DataFrame) {

  }
  def transformCityDim(cityDF: DataFrame, stateProvinceDF: DataFrame, countriesDF: DataFrame): DataFrame = {

    val citiesDimDF =
      cityDF
        .leftJoin(stateProvinceDF, cityDF(StateProvince.Fields.StateProvinceID)===stateProvinceDF(StateProvince.Fields.StateProvinceID),true)
        .leftJoin(countriesDF, Seq(Countries.Fields.CountryID))
        .select(
          cityDF(Cities.Fields.CityID).as(CityDim.Fields.WWICityID),
          cityDF(Cities.Fields.CityName).as(CityDim.Fields.City),
          stateProvinceDF(StateProvince.Fields.StateProvinceName).as(CityDim.Fields.StateProvince),
          countriesDF(Countries.Fields.CountryName).as(CityDim.Fields.Country),
          countriesDF(Countries.Fields.Continent).as(CityDim.Fields.Continent),
          stateProvinceDF(StateProvince.Fields.SalesTerritory).as(CityDim.Fields.SalesTerritory),
          countriesDF(Countries.Fields.Region).as(CityDim.Fields.Region),
          countriesDF(Countries.Fields.Subregion).as(CityDim.Fields.Subregion)
        )

    citiesDimDF
  }

  def transformCustomerDim(customersDF: DataFrame, buyingGroupsDF: DataFrame, customerCategoryDF: DataFrame, peopleDF: DataFrame): DataFrame = {

    val customersDimDF =
      customersDF
        .leftJoin(buyingGroupsDF, customersDF(Customers.Fields.BuyingGroupID) === buyingGroupsDF(BuyingGroups.Fields.BuyingGroupID),true)
        .leftJoin(customerCategoryDF, customersDF(Customers.Fields.CustomerCategoryID) === customerCategoryDF(CustomerCategories.Fields.CustomerCategoryID), true)
        .leftJoin(customersDF.as("customersBT"), customersDF(Customers.Fields.BillToCustomerID) === col("customersBT." + Customers.Fields.CustomerID))
        .leftJoin(peopleDF, customersDF(Customers.Fields.PrimaryContactPersonID) === peopleDF(People.Fields.PersonID))
        .select(
          customersDF(Customers.Fields.CustomerID).as(CustomerDim.Fields.WWICustomerID),
          customersDF(Customers.Fields.CustomerName).as(CustomerDim.Fields.Customer),
          col("customersBT." + Customers.Fields.CustomerName).as(CustomerDim.Fields.BillToCustomer),
          customerCategoryDF(CustomerCategories.Fields.CustomerCategoryName).as(CustomerDim.Fields.Category),
          buyingGroupsDF(BuyingGroups.Fields.BuyingGroupName).as(CustomerDim.Fields.BuyingGroup),
          peopleDF(People.Fields.FullName).as(CustomerDim.Fields.PrimaryContact),
          customersDF(Customers.Fields.DeliveryPostalCode)as(CustomerDim.Fields.PostalCode)
        )

    customersDimDF
  }

  val employeeColumns: Seq[Column] = Seq(
    col(People.Fields.PersonID).as(EmployeeDim.Fields.WWIEmployeeID),
    col(People.Fields.FullName).as(EmployeeDim.Fields.Employee),
    col(People.Fields.PreferredName).as(EmployeeDim.Fields.PreferredName),
    col(People.Fields.IsSalesperson).as(EmployeeDim.Fields.IsSalesPerson)
  )

}
