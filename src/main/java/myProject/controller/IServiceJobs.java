package myProject.controller;

import java.util.List;

import myProject.model.Customer;

public interface IServiceJobs {

    public List<Customer> loadCustomers();

    public void showOrdersForCustomer(Customer customer);

    public void loadOrdersForCustomer(Customer customer);

    public void getTotalSalesForCustomer(Customer customer);

    public void clear();

}
