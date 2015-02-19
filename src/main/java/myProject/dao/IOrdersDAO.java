package myProject.dao;

import java.util.List;

import myProject.model.Order;

public interface IOrdersDAO {

	public List<Order> getAllOrdersForCustomer(int customerID);
}
