package myProject.model;

import java.util.List;

public interface IServiceJobs {

    public List<Customer> loadCustomers();

    public List<Order> loadOrdersForCustomer(int customerId);

    public double getTotalSales(int customerId);

}
