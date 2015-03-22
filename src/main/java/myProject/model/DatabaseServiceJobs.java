package myProject.model;

import java.util.List;

import myProject.dao.ICustomerDao;
import myProject.dao.IOrdersDao;

public class DatabaseServiceJobs implements IServiceJobs {

    private ICustomerDao customerDAO;
    private IOrdersDao ordersDAO;

    public DatabaseServiceJobs(ICustomerDao customerDAO, IOrdersDao ordersDAO) {
        this.customerDAO = customerDAO;
        this.ordersDAO = ordersDAO;
    }

    @Override
    public List<Customer> loadCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public List<Order> loadOrdersForCustomer(int customerId) {
        return ordersDAO.loadOrdersForCustomer(customerId);
    }

    @Override
    public double getTotalSales(int customerId) {
        return ordersDAO.calculateTotalSalesForCustomer(customerId);
    }
}
