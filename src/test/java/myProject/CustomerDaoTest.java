package myProject;

import static org.junit.Assert.assertEquals;

import java.util.List;

import myProject.dao.CustomerDao;
import myProject.model.Customer;

import org.junit.Test;

public class CustomerDaoTest {

	@Test
	public void testGetAllCustomersReturnsCorrectSize() throws Exception {
		CustomerDao testObject = new CustomerDao();
		List<Customer> customerList = testObject.getAllCustomers();

		assertEquals(33, customerList.size());
	}
}
