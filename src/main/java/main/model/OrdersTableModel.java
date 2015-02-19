package main.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class OrdersTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2882962431340365936L;
	private String[] columnHeaders = { "Order Date", "Order ID", "Ship Date", "Item Count", "Order Total" };
	private List<Order> orders;

	public OrdersTableModel() {
		orders = new ArrayList<>();
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public int getColumnCount() {
		return columnHeaders.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// switch (columnIndex) {
		// case 1:
		// return orders.get(rowIndex).getOrderDate();
		// default:
		// break;
		// }
		// return orders.get(rowIndex)
		return null;
	}

	// public void addOrders(List<Order> orders) {
	// for (Order order : orders) {
	//
	// }
	// }

	@Override
	public String getColumnName(int column) {
		return columnHeaders[column];
	}

}
