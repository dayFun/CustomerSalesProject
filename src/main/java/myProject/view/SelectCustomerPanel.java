package myProject.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myProject.events.LoadCustomersEvent;
import myProject.listeners.ISelectCustomerListener;
import myProject.model.Customer;

public class SelectCustomerPanel extends JPanel {

    private static final long serialVersionUID = -4586190622428044897L;

    private JLabel selectCustomerLabel;
    private JComboBox<Customer> customerComboBox;
    private ISelectCustomerListener customerListener;

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

    public void setSelectCustomerListener(ISelectCustomerListener customerListener) {
        this.customerListener = customerListener;
    }

    public void populateComboBox(LoadCustomersEvent e) {
        for (Customer customer : e.getCustomerList()) {
            customerComboBox.addItem(customer);
        }
        customerComboBox.setSelectedIndex(-1);
        customerComboBox.setEnabled(true);

        addItemListenerToComboBox();
    }

    private void addItemListenerToComboBox() {
        customerComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent customerSelection) {
                int state = customerSelection.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    customerListener.selectedCustomerEvent(customerSelection);
                }
            }
        });
    }
}
