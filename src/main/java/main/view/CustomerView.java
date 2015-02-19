package main.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import main.model.Customer;

public class CustomerView extends JFrame {

	private static final long serialVersionUID = -25439378044847998L;
	private JPanel panel;
	private ICustomerViewListener viewListener;

	public CustomerView() {
		createAndShowGUI();

	}

	private void createAndShowGUI() {
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		getContentPane().add(panel);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		Container selectCustomerContainer = new Container();

		JLabel selectCustomerLabel = new JLabel("Select Customer: ");

		JComboBox<Customer> customerComboBox = new JComboBox<>();
		customerComboBox.setPreferredSize(new Dimension(250, 20));
		customerComboBox.setEditable(false);
		customerComboBox.setEnabled(false);
		panel.add(selectCustomerContainer);
		selectCustomerContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		selectCustomerContainer.add(selectCustomerLabel);
		selectCustomerContainer.add(customerComboBox);

		// OrdersTableModel tableModel = new OrdersTableModel();
		// JTable ordersTable = new JTable(tableModel);
		// ordersTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// ordersTable.setEnabled(false);
		//
		// JScrollPane scrollPane = new JScrollPane(ordersTable);
		// selectCustomerContainer.add(scrollPane);
		//
		// Container totalSalesContainer = new Container();
		// getContentPane().add(totalSalesContainer);
		// FlowLayout fl_totalSalesContainer = new FlowLayout();
		// fl_totalSalesContainer.setAlignment(FlowLayout.RIGHT);
		// totalSalesContainer.setLayout(fl_totalSalesContainer);
		//
		// JLabel totalSalesLabel = new JLabel("Total Sales - All Orders: ");
		// totalSalesContainer.add(totalSalesLabel);
		//
		// JTextField totalSalesAmountLabel = new JTextField("$0.00");
		// totalSalesAmountLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		// totalSalesContainer.add(totalSalesAmountLabel);
		// totalSalesAmountLabel.setHorizontalAlignment(JTextField.RIGHT);
		// totalSalesAmountLabel.setPreferredSize(new Dimension(125, 20));
		// Container clearButtonContainer = new Container();
		// getContentPane().add(clearButtonContainer);
		// clearButtonContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5,
		// 5));
		//
		// JButton clearButton = new JButton("Clear");
		// clearButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		// clearButton.setPreferredSize(new Dimension(75, 25));
		// clearButtonContainer.add(clearButton);
		// clearButton.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// viewListener.clear();
		// }
		// });
		// clearButton.setVisible(true);
		// JPanel salesOnFileContainer = new JPanel();
		// salesOnFileContainer.setBorder(BorderFactory.createEmptyBorder(0, 0,
		// 0, 200));
		// getContentPane().add(salesOnFileContainer);
		// salesOnFileContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 5,
		// 5));
		//
		// JLabel salesOnFileLabel = new JLabel("Sales on file = ",
		// SwingConstants.LEFT);
		// salesOnFileContainer.add(salesOnFileLabel);
		//
		// JLabel totalSalesOnFile = new JLabel("0");
		// salesOnFileContainer.add(totalSalesOnFile);

		setWindowOptions();
	}

	private void setWindowOptions() {
		setTitle("Customer Sales History");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(createMenuBar());
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createHelpMenu());
		return menuBar;
	}

	private JMenu createHelpMenu() {
		return new JMenu("Help");
	}

	private JMenu createFileMenu() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenuItem loadCustomersMenuItem = new JMenuItem("Load Customers");
		loadCustomersMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewListener.loadCustomersFromDatabase();
			}
		});
		file.add(loadCustomersMenuItem);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setToolTipText("Exit application");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		file.add(exitMenuItem);
		return file;
	}

	public void setViewListener(ICustomerViewListener viewListener) {
		this.viewListener = viewListener;
	}
}
