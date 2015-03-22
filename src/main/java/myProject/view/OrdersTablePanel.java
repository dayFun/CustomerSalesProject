package myProject.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import myProject.model.Order;
import myProject.model.OrdersTableModel;

public class OrdersTablePanel extends JPanel {

    private static final long serialVersionUID = 4231571761716281861L;
    private JTable table;
    private OrdersTableModel tableModel;

    public OrdersTablePanel() {
        tableModel = new OrdersTableModel();
        table = new JTable(tableModel);

        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setColumnAlignment(SwingConstants.RIGHT);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void setColumnAlignment(int alignment) {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(alignment);

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(cellRenderer);
        }
    }

    public void setData(List<Order> dbOrdersList) {
        tableModel.setData(dbOrdersList);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    public void clear() {
        tableModel.clear();
        refresh();
    }
}
