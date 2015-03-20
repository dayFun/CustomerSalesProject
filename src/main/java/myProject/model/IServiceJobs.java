package myProject.model;

import java.util.List;

public interface IServiceJobs {

    public List<Customer> loadCustomers();

    public List<Order> loadOrdersForCustomer(Customer customer);

    public void getTotalSalesForCustomer(Customer customer);

    public void clear();

}
