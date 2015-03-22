package myProject.model;


import java.util.List;

import javax.swing.table.AbstractTableModel;


public class OrdersTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 2882962431340365936L;
    private static final int NO_SALES_ON_FILE = 1;

    private String[] columnHeaders = {"Order Date", "Order ID", "Ship Date", "Item Count", "Order Total"};
    private List<Order> ordersList;

    public void setData(List<Order> ordersList) {
        if (ordersList != null) {
            this.ordersList = ordersList;
        }
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    @Override
    public int getRowCount() {
        if (getOrdersList() != null) {
            if (getOrdersList().isEmpty()) {
                return NO_SALES_ON_FILE;
            } else {
                return getOrdersList().size();
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
        if (getOrdersList().isEmpty()) {
            if (columnIndex == 4) {
                return "No Sales on File";
            } else {
                return null;
            }
        }
        Order order = getOrdersList().get(rowIndex);

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
                return order.getOrderTotal();
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
    }

}
