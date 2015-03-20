package myProject.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myProject.model.Customer;

public class SelectCustomerPanel extends JPanel {

    private static final long serialVersionUID = -4586190622428044897L;

    private JLabel selectCustomerLabel;
    private JComboBox<Customer> customerComboBox;

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

    public void populateComboBox(List<Customer> customersList) {
        for (Customer customer : customersList) {
            customerComboBox.addItem(customer);
        }
        customerComboBox.setSelectedIndex(-1);
        customerComboBox.setEnabled(true);
    }

    private void addItemListenerToComboBox() {
        customerComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent customerSelection) {
                int state = customerSelection.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    // customerListener.selectedCustomerEvent(customerSelection);
                }
            }
        });
    }
}
