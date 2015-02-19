package main.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import main.dao.CustomerDAO;
import main.model.Customer;

import org.junit.Test;

public class CustomerDAOTest {

	@Test
	public void testGetAllCustomersReturnsCorrectSize() throws Exception {
		CustomerDAO testObject = new CustomerDAO();
		List<Customer> customerList = testObject.getAllCustomers();

		assertEquals(33, customerList.size());
	}
}
