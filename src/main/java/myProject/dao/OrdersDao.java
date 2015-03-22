package myProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import myProject.model.Order;

public class OrdersDao implements IOrdersDao {

    private static final String SELECT_ORDERS_QUERY =
            "SELECT s.order_date, s.order_id, s.ship_date, count(i.item_id) As ItemCount, s.total FROM SALES_ORDER s, ITEM i WHERE s.order_id = i.order_id AND s.customer_id = ? GROUP BY s.order_date, s.order_id, s.ship_date, s.total ORDER BY s.order_date, s.order_id";

    private List<Order> ordersList = new ArrayList<>();

    @Override
    public List<Order> loadOrdersForCustomer(int customerID) {
        DataSource mySqlDataSource = DataSourceFactory.getMySqlDataSource();

        try (Connection connection = mySqlDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_QUERY);
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();

            if (!resultSet.next()) {

            } else {

                do {
                    Order order = new Order();
                    order.setOrderDate(resultSet.getDate("ORDER_DATE"));
                    order.setOrderID(resultSet.getInt("ORDER_ID"));
                    order.setShipDate(resultSet.getDate("SHIP_DATE"));
                    order.setItemCount(resultSet.getInt("ItemCount"));
                    order.setOrderTotal(resultSet.getDouble("TOTAL"));

                    ordersList.add(order);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordersList;
    }

    @Override
    public double calculateTotalSalesForCustomer(int customerID) {
        double total = 0;

        for (Order order : loadOrdersForCustomer(customerID)) {
            total += order.getOrderTotal();
        }
        return total;
    }
}
