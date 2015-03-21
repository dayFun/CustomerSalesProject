package myProject.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import myProject.model.Customer;
import myProject.model.Order;

import org.junit.Test;

public class OrdersDaoTest {


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

    @Test
    public void test() throws Exception {
        OrdersDao orderDAO = new OrdersDao();
        List<Order> ordersList = orderDAO.loadOrdersForCustomer(208);
        assertEquals(10, ordersList.size());
    }
}
