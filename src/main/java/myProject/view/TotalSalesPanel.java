package myProject.view;

import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TotalSalesPanel extends JPanel {

    private static final long serialVersionUID = -8361348726960045430L;
    private JLabel totalSalesLabel;
    private JTextField totalSalesAmountLabel;

    public TotalSalesPanel() {
        setLayout(new FlowLayout());

        totalSalesLabel = new JLabel("Total Sales - All Orders: ", 10);
        totalSalesAmountLabel = new JTextField("$0.00", 10);

        add(totalSalesLabel);
        add(totalSalesAmountLabel);
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String totalSales = formatter.format(totalSalesAmount);

        totalSalesAmountLabel.setText(totalSales);
    }
}
