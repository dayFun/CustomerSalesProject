package myProject.model;


import java.text.NumberFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class OrdersTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 2882962431340365936L;
    private static final int NO_SALES_ON_FILE = 1;

    private String[] columnHeaders = {"Order Date", "Order ID", "Ship Date", "Item Count", "Order Total"};
    private List<Order> ordersList;

    public void setData(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int getRowCount() {
        if (ordersList != null) {
            if (ordersList.isEmpty()) {
                return NO_SALES_ON_FILE;
            } else {
                return ordersList.size();
            }
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnHeaders.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (ordersList.isEmpty()) {
            if (columnIndex == columnHeaders.length - 1) {
                return "No Sales on File";
            } else {
                return null;
            }
        }
        Order order = ordersList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return order.getOrderDate();
            case 1:
                return order.getOrderID();
            case 2:
                return order.getShipDate();
            case 3:
                return order.getItemCount();
            case 4:
                return formatTotalAsCurrency(order.getOrderTotal());
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnHeaders[column];
    }

    public void clear() {
        if (ordersList != null) {
            ordersList.clear();
        }
        ordersList = null;
    }

    private Object formatTotalAsCurrency(double orderTotal) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String total = formatter.format(orderTotal);
        return total;
    }
}
