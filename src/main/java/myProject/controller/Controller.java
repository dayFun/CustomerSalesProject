package myProject.controller;

import myProject.dao.CustomerDao;
import myProject.dao.OrdersDao;
import myProject.view.CustomerGUI;
import myProject.view.LoadCustomersEvent;

public class Controller {

    private ServiceJobs serviceJobs;
    private CustomerGUI customerGUI;

    public Controller() {
        serviceJobs = new ServiceJobs(new CustomerDao(), new OrdersDao());
    }

    public void getCustomers() {
        serviceJobs.loadCustomers();
        System.err.println("About to create load customers event");
        LoadCustomersEvent customersEvent = new LoadCustomersEvent(this, serviceJobs.getCustomersList());
    }

    public void exit() {
        System.exit(0);
    }


}
