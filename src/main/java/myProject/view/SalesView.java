package myProject.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import myProject.listeners.IPreferencesListener;
import myProject.listeners.ISalesViewListener;

public class SalesView extends JFrame {

    private static final long serialVersionUID = -729091611169270303L;

    private MainMenuBar mainMenuBar;
    private PreferencesDialog preferencesDialog;
    private SelectCustomerPanel selectCustomerPanel;
    private OrdersTablePanel ordersTablePanel;
    private TotalSalesPanel totalSalesPanel;
    private JButton clearTableButton;
    private JSeparator separator;
    private StatisticsPanel statisticsPanel;
    private IPreferencesListener preferencesListener;
    private Preferences preferences;

    public SalesView() {
        setLayout(new GridBagLayout());

        preferences = Preferences.userRoot().node("db");

        mainMenuBar = new MainMenuBar();
        // mainMenuBar.setMenuItemListener(menuListener);
        setJMenuBar(mainMenuBar);

        preferencesDialog = new PreferencesDialog(this);
        preferencesDialog.setPreferencesListener(preferencesListener);
        setDefaultPreferences();

        selectCustomerPanel = new SelectCustomerPanel();

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

    public void attachListeners(final ISalesViewListener viewListener) {
        mainMenuBar.getLoadCustomersMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewListener.handleLoadOrdersClicked();
            }
        });

        clearTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewListener.handleClearButtonClick();
            }
        });
    }

    private void setDefaultPreferences() {
        String user = preferences.get("url", "");
        String password = preferences.get("password", "");
        Integer port = preferences.getInt("port", 3306);

        preferencesDialog.setDefaultPreferences(user, password, port);
    }


    // private void initSelectCustomerListener() {
    // selectCustomerListener = new ICustomerListener() {
    // @Override
    // public void customersLoaded(LoadCustomersEvent e) {
    // selectCustomerPanel.populateComboBox(e);
    // }
    //
    // @Override
    // public void selectedCustomerEvent(ItemEvent e) {
    // Customer selectedCustomer = (Customer) e.getItem();
    // controller.loadOrdersForCustomer(selectedCustomer);
    // ordersTablePanel.clear();
    // ordersTablePanel.setData(controller.getOrdersForCustomer());
    // ordersTablePanel.refresh();
    // }
    // };
    // }

    // private void initMenuItemListener() {
    // menuListener = new IMenuItemListener() {
    // @Override
    // public void getCustomersFromDatabase() {
    // controller.loadCustomers();
    // selectCustomerListener.customersLoaded(new LoadCustomersEvent(this,
    // controller.getCustomers()));
    //
    // }
    //
    // @Override
    // public void showPreferencesDialog() {
    // preferencesDialog.setVisible(true);
    // }
    //
    // @Override
    // public void exitApplication() {
    // int action =
    // JOptionPane.showConfirmDialog(MainGUI.this, "Are you sure you want to exit the application?",
    // "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
    //
    // if (action == JOptionPane.OK_OPTION) {
    // controller.exit();
    // }
    // }
    // };
    //
    // }
    //
    // private void initPreferencesListener() {
    // preferencesListener = new IPreferencesListener() {
    // @Override
    // public void preferencesSet(String user, String password, int port) {
    // preferences.put("url", user);
    // preferences.put("password", password);
    // preferences.putInt("port", port);
    // }
    // };
    //
    // }

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


    public MainMenuBar getMainMenuBar() {
        return mainMenuBar;
    }

    public SelectCustomerPanel getSelectCustomerPanel() {
        return selectCustomerPanel;
    }

    public OrdersTablePanel getOrdersTablePanel() {
        return ordersTablePanel;
    }

    public TotalSalesPanel getTotalSalesPanel() {
        return totalSalesPanel;
    }

    public StatisticsPanel getStatisticsPanel() {
        return statisticsPanel;
    }
}
