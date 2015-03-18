package myProject.controller;

import java.util.List;

import myProject.dao.ICustomerDao;
import myProject.dao.IOrdersDao;
import myProject.model.Customer;

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
    public void showOrdersForCustomer(Customer customer) {
        ordersDAO.getAllOrdersForCustomer(customer.getCustomerId());
    }

    @Override
    public void loadOrdersForCustomer(Customer customer) {
        // ordersList = ordersDAO.getAllOrdersForCustomer(customer.getCustomerId());
    }

    @Override
    public void getTotalSalesForCustomer(Customer customer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
    }
}
