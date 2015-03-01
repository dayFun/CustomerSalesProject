package myProject.controller;

import java.util.List;

import myProject.dao.CustomerDao;
import myProject.dao.OrdersDao;
import myProject.model.Customer;

public class Controller {

    private DatabaseServiceJobs dbServiceJobs;

    public Controller() {
        dbServiceJobs = new DatabaseServiceJobs(new CustomerDao(), new OrdersDao());
    }

    public List<Customer> getCustomers() {
        return dbServiceJobs.getCustomersList();
    }

    public void loadCustomers() {
        dbServiceJobs.loadCustomers();
    }

    public void exit() {
        System.exit(0);
    }


}
