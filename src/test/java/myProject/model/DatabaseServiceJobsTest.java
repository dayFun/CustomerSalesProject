package myProject.model;

import java.util.ArrayList;
import java.util.List;

import myProject.dao.ICustomerDao;
import myProject.dao.IOrdersDao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class DatabaseServiceJobsTest {

    @Mock
    private ICustomerDao customerDAO;
    @Mock
    private IOrdersDao ordersDAO;

    private DatabaseServiceJobs dbServiceJobs;

    @Before
    public void setup() {
        dbServiceJobs = new DatabaseServiceJobs(customerDAO, ordersDAO);
    }

    @Test
    public void testName() throws Exception {
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = makeCustomer(0, "Bob");
        Customer customer2 = makeCustomer(2, "Jane");
        customerList.add(customer1);
        customerList.add(customer2);


    }

    private Customer makeCustomer(int id, String name) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setSalesPersonId(id);
        customer.setName(name);

        return customer;

    }
}
