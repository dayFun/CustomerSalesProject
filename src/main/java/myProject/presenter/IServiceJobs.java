package myProject.presenter;

import myProject.model.Customer;

public interface IServiceJobs {

	public void loadCustomers();

	public void showOrdersForCustomer(Customer customer);

	public void getNumberOfOrdersForCustomer(Customer customer);

	public void getTotalSalesAmountForCustomer(Customer customer);

	public void clear();

}
