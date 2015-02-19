package myProject.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import myProject.model.Customer;

public class CustomerGUI extends JFrame {

	private static final long serialVersionUID = -729091611169270303L;

	public CustomerGUI() {
		setLayout(new GridBagLayout());

		JLabel selectCustomerLabel = new JLabel("Select Customer: ");
		JComboBox<Customer> customerComboBox = new JComboBox<>();
		customerComboBox.setPreferredSize(new Dimension(250, 20));
		customerComboBox.setEditable(false);
		customerComboBox.setEnabled(false);

		OrdersTablePanel tablePanel = new OrdersTablePanel();
		GridBagConstraints gc = new GridBagConstraints();
		// I'm a comment for a Git Test!
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		// //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(15, 0, 10, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;

		add(selectCustomerLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(12, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(customerComboBox, gc);

		// //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		gc.weightx = 3;
		gc.weighty = 3;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;

		add(tablePanel, gc);

		// //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		setWindowOptions();

	}

	private void setWindowOptions() {
		setTitle("Customer Sales History");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
