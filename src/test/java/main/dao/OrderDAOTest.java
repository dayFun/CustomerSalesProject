package main.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import main.dao.OrdersDAO;
import main.model.Order;

import org.junit.Test;

public class OrderDAOTest {

	@Test
	public void testName() throws Exception {
		OrdersDAO orderDAO = new OrdersDAO();
		List<Order> ordersList = orderDAO.getAllOrdersForCustomer(208);
		assertEquals(11, ordersList.size());
	}
}
