package myProject.presenter;

import java.util.List;

import myProject.dao.ICustomerDAO;
import myProject.dao.IOrdersDAO;
import myProject.model.Customer;
import myProject.model.Order;
import myProject.model.OrdersTableModel;

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
