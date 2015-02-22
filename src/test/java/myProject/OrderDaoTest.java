package myProject;

import static org.junit.Assert.assertEquals;

import java.util.List;

import myProject.dao.OrdersDao;
import myProject.model.Order;

import org.junit.Test;

public class OrderDaoTest {

	@Test
	public void testName() throws Exception {
		OrdersDao orderDAO = new OrdersDao();
		List<Order> ordersList = orderDAO.getAllOrdersForCustomer(208);
		assertEquals(10, ordersList.size());
	}
}
