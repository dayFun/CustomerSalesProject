package main.presenter;

import java.util.List;

import main.dao.ICustomerDAO;
import main.dao.IOrdersDAO;
import main.model.Customer;
import main.model.Order;
import main.model.OrdersTableModel;

public class ServiceJobs implements IServiceJobs {

	private List<Customer> customersList;
	private List<Order> ordersList; 
	private ICustomerDAO customerDAO;
	private IOrdersDAO ordersDAO;
	private OrdersTableModel ordersTableModel;
	
	public ServiceJobs(ICustomerDAO customerDAO, IOrdersDAO ordersDAO, OrdersTableModel ordersTableModel) {
		this.customerDAO = customerDAO;
		this.ordersDAO = ordersDAO;
		this.ordersTableModel = ordersTableModel;		
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
	public void getNumberOfOrdersForCustomer(Customer customer) {
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
