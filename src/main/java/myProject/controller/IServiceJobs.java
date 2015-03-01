package myProject.controller;

import myProject.model.Customer;

public interface IServiceJobs {

	public void loadCustomers();

	public void showOrdersForCustomer(Customer customer);

	public void loadOrdersForCustomer(Customer customer);

	public void getTotalSalesForCustomer(Customer customer);

	public void clear();

}
