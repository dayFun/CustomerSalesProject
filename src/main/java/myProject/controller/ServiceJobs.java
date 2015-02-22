package myProject.controller;

import java.util.List;

import myProject.dao.ICustomerDao;
import myProject.dao.IOrdersDao;
import myProject.model.Customer;
import myProject.model.Order;

public class ServiceJobs implements IServiceJobs {

    private List<Customer> customersList;
    private List<Order> ordersList;
    private ICustomerDao customerDAO;
    private IOrdersDao ordersDAO;

    public ServiceJobs(ICustomerDao customerDAO, IOrdersDao ordersDAO) {
        this.customerDAO = customerDAO;
        this.ordersDAO = ordersDAO;
    }

    @Override
    public void loadCustomers() {
        customersList = customerDAO.getAllCustomers();
    }

    @Override
    public void showOrdersForCustomer(Customer customer) {
        ordersDAO.getAllOrdersForCustomer(customer.getCustomerId());
    }

    @Override
    public void getNumberOrdersForCustomer(Customer customer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void getTotalSalesAmountForCustomer(Customer customer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
    }

}
