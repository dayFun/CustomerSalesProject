package myProject.model;

import java.util.List;

public interface IServiceJobs {

    public List<Customer> loadCustomers();

    public void showOrdersForCustomer(Customer customer);

    public void loadOrdersForCustomer(Customer customer);

    public void getTotalSalesForCustomer(Customer customer);

    public void clear();

}
