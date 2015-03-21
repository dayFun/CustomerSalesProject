package myProject.dao;

import java.util.List;

import myProject.model.Order;

public interface IOrdersDao {

    public List<Order> loadOrdersForCustomer(int customerID);

    public double calculateTotalSalesForCustomer(int customerID);

}
