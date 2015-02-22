package myProject.controller;

import myProject.model.Customer;

public interface IServiceJobs {

	public void loadCustomers();

	public void showOrdersForCustomer(Customer customer);

	public void getNumberOrdersForCustomer(Customer customer);

	public void getTotalSalesAmountForCustomer(Customer customer);

	public void clear();

}
