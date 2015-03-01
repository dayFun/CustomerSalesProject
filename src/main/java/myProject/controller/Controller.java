package myProject.controller;

import java.util.List;

import myProject.dao.CustomerDao;
import myProject.dao.OrdersDao;
import myProject.model.Customer;
import myProject.model.Order;

public class Controller {

    private DatabaseServiceJobs dbServiceJobs;

    public Controller() {
        dbServiceJobs = new DatabaseServiceJobs(new CustomerDao(), new OrdersDao());
    }

    public List<Customer> getCustomers() {
        return dbServiceJobs.getCustomersList();
    }

    public List<Order> getOrdersForCustomer() {
        return dbServiceJobs.getOrdersListForCustomer();
    }

    public void loadCustomers() {
        dbServiceJobs.loadCustomers();
    }

    public void loadOrdersForCustomer(Customer customer) {
        dbServiceJobs.loadOrdersForCustomer(customer);
    }

    public void exit() {
        System.exit(0);
    }


}
