package myProject.dao;

import java.util.List;

import myProject.model.Order;

public interface IOrdersDao {

	public List<Order> getAllOrdersForCustomer(int customerID);
}
