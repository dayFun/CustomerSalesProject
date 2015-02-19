package main.dao;

import java.util.List;

import main.model.Order;

public interface IOrdersDAO {

	public List<Order> getAllOrdersForCustomer(int customerID);
}
