package myProject.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myProject.listeners.ICustomerListener;
import myProject.model.Customer;

public class SelectCustomerPanel extends JPanel {

    private static final long serialVersionUID = -4586190622428044897L;

    private JLabel selectCustomerLabel;
    private JComboBox<Customer> customerComboBox;
    private ICustomerListener customerListener;

    public SelectCustomerPanel() {
        setLayout(new FlowLayout());

        selectCustomerLabel = new JLabel("Select Customer: ");

        customerComboBox = new JComboBox<>();
        customerComboBox.setPreferredSize(new Dimension(250, 20));
        customerComboBox.setEditable(false);
        customerComboBox.setEnabled(false);

        add(selectCustomerLabel);
        add(customerComboBox);
    }

    public void setCustomerListener(ICustomerListener customerListener) {
        this.customerListener = customerListener;
    }

    public void populateComboBox(LoadCustomersEvent e) {
        for (Customer customer : e.getCustomerList()) {
            customerComboBox.addItem(customer);
        }
        customerComboBox.setEnabled(true);
        customerComboBox.setSelectedIndex(-1);
    }
}
