package myProject.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import myProject.controller.Controller;
import myProject.listeners.ICustomerListener;
import myProject.listeners.IMenuItemListener;

public class CustomerGUI extends JFrame {

    private static final long serialVersionUID = -729091611169270303L;

    private MainMenuBar mainMenuBar;
    private PreferencesDialog preferencesDialog;
    private SelectCustomerPanel selectCustomerPanel;
    private OrdersTablePanel ordersTablePanel;
    private TotalSalesPanel totalSalesPanel;
    private JButton clearTableButton;
    private JSeparator separator;
    private StatisticsPanel statisticsPanel;
    private Controller controller;
    private IMenuItemListener menuListener;
    private ICustomerListener selectCustomerListener;

    public CustomerGUI() {
        setLayout(new GridBagLayout());

        controller = new Controller();

        initListeners();

        mainMenuBar = new MainMenuBar();
        mainMenuBar.setMenuItemListener(menuListener);
        setJMenuBar(mainMenuBar);

        preferencesDialog = new PreferencesDialog(this);

        selectCustomerPanel = new SelectCustomerPanel();
        selectCustomerPanel.setCustomerListener(selectCustomerListener);

        ordersTablePanel = new OrdersTablePanel();
        totalSalesPanel = new TotalSalesPanel();

        clearTableButton = new JButton("Clear");

        separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1, 1));
        separator.setForeground(Color.GRAY); // top line color
        separator.setBackground(Color.GRAY); // bottom line color

        statisticsPanel = new StatisticsPanel();

        layoutComponents();

        setWindowOptions();

    }

    private void initListeners() {
        initMenuItemListener();
        initSelectCustomerListener();
    }

    private void initSelectCustomerListener() {
        selectCustomerListener = new ICustomerListener() {
            public void doStuff(LoadCustomersEvent e) {
                System.err.println("Caught load customers event");
            }
        };
    }

    private void initMenuItemListener() {
        menuListener = new IMenuItemListener() {
            public void getCustomersFromDatabase() {
                controller.getCustomers();
            }

            public void showPreferencesDialog() {
                preferencesDialog.setVisible(true);
            }

            public void exitApplication() {
                controller.exit();
            }
        };

    }

    private void layoutComponents() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(15, 0, 10, 5);
        gc.anchor = GridBagConstraints.CENTER;

        add(selectCustomerPanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(5, 30, 5, 30);
        gc.anchor = GridBagConstraints.CENTER;

        add(ordersTablePanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_END;

        add(totalSalesPanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        gc.gridx = 0;
        gc.gridy = 3;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.CENTER;

        add(clearTableButton, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        gc.gridx = 0;
        gc.gridy = 4;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.HORIZONTAL;

        add(separator, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        gc.gridx = 0;
        gc.gridy = 5;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.HORIZONTAL;

        add(statisticsPanel, gc);
    }

    private void setWindowOptions() {
        setTitle("Customer Sales History");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
