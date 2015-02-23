package myProject.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myProject.listeners.ICustomerListener;
import myProject.model.Customer;

public class SelectCustomerPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = -4586190622428044897L;

    private JLabel selectCustomerLabel;
    private JComboBox<Customer> customerComboBox;
    private ICustomerListener customerListener;

    public SelectCustomerPanel() {
        setLayout(new FlowLayout());

        selectCustomerLabel = new JLabel("Select Customer: ");

        customerComboBox = new JComboBox<>();
        customerComboBox.addActionListener(this);
        customerComboBox.setPreferredSize(new Dimension(250, 20));
        customerComboBox.setEditable(false);
        customerComboBox.setEnabled(false);

        add(selectCustomerLabel);
        add(customerComboBox);
    }

    public void setCustomerListener(ICustomerListener customerListener) {
        this.customerListener = customerListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
