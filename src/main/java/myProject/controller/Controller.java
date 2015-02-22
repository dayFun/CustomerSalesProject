package myProject.controller;

import myProject.dao.CustomerDao;
import myProject.dao.OrdersDao;

public class Controller {

    private ServiceJobs serviceJobs;

    public Controller() {
        serviceJobs = new ServiceJobs(new CustomerDao(), new OrdersDao());
    }
}
