package myProject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import myProject.model.Customer;

public class CustomerDAO implements ICustomerDAO {

	private final String SELECT_ALL_CUSTOMERS_QUERY = "SELECT * FROM CUSTOMER ORDER BY Name";
	private List<Customer> customerList = new ArrayList<>();

	@Override
	public List<Customer> getAllCustomers() {
		DataSource mySqlDataSource = DataSourceFactory.getMySqlDataSource();

		try (Connection connection = mySqlDataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_CUSTOMERS_QUERY);) {

			resultSet.first();

			do {
				// TODO: Use BasicRowProcessor!!!
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
				customer.setName(resultSet.getString("NAME"));
				customer.setAddress(resultSet.getString("ADDRESS"));
				customer.setCity(resultSet.getString("CITY"));
				customer.setZipCode(resultSet.getString("ZIP_CODE"));
				customer.setAddress(resultSet.getString("AREA_CODE"));
				customer.setPhoneNumber(resultSet.getInt("PHONE_NUMBER"));
				customer.setSalesPersonId(resultSet.getInt("SALESPERSON_ID"));
				customer.setCreditLimit(resultSet.getDouble("CREDIT_LIMIT"));
				customer.setComments(resultSet.getString("COMMENTS"));
				customerList.add(customer);
			} while (resultSet.next());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
}
