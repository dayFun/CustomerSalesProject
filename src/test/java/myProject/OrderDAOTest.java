package myProject;

import static org.junit.Assert.assertEquals;

import java.util.List;

import myProject.dao.OrdersDAO;
import myProject.model.Order;

import org.junit.Test;

public class OrderDAOTest {

	@Test
	public void testName() throws Exception {
		OrdersDAO orderDAO = new OrdersDAO();
		List<Order> ordersList = orderDAO.getAllOrdersForCustomer(208);
		assertEquals(10, ordersList.size());
	}
}
