package myProject.presenter;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.prefs.Preferences;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import myProject.listeners.IPreferencesListener;
import myProject.listeners.ISalesViewListener;
import myProject.model.Customer;
import myProject.model.DatabaseServiceJobs;
import myProject.model.Order;
import myProject.view.SalesView;

public class Presenter implements ISalesViewListener {

    private DatabaseServiceJobs dbServiceJobs;
    private SalesView salesView;

    public Presenter(SalesView salesView, DatabaseServiceJobs dbServiceJobs) {
        this.salesView = salesView;
        this.dbServiceJobs = dbServiceJobs;
    }

    @Override
    public void handleLoadOrdersClicked() {
        List<Customer> customersList = dbServiceJobs.loadCustomers();
        salesView.getSelectCustomerPanel().populateComboBox(customersList);
        initComboBoxListener();
        salesView.getStatisticsPanel().setRecordsRead(customersList.size());
    }

    @Override
    public void handleSelectCustomerClick(ItemEvent event) {
        salesView.getOrdersTablePanel().clear();
        Customer selectedCustomer = (Customer) event.getItem();
        int customerId = selectedCustomer.getCustomerId();

        List<Order> ordersList = dbServiceJobs.loadOrdersForCustomer(customerId);
        salesView.getOrdersTablePanel().setData(ordersList);
        salesView.getTotalSalesPanel().setTotalSalesAmount(dbServiceJobs.getTotalSales(customerId));
        salesView.getStatisticsPanel().setSalesOnFile(ordersList.size());
    }

    @Override
    public void handleClearButtonClick() {
        salesView.getOrdersTablePanel().clear();
        salesView.getSelectCustomerPanel().resetComboBox();
        salesView.getTotalSalesPanel().resetTotalSales();
        salesView.getStatisticsPanel().setRecordsRead(dbServiceJobs.loadCustomers().size());
    }

    @Override
    public void handleExitButtonClick() {
        int action =
                JOptionPane.showConfirmDialog(salesView, "Are you sure you want to exit the application?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

        if (action == JOptionPane.OK_OPTION) {
            System.exit(0);
        }

    }

    @Override
    public void handlePreferencesClicked() {
        setDefaultPreferences();
        salesView.getPreferencesDialog().setVisible(true);
        initPreferencesListener();
    }

    private void setDefaultPreferences() {
        Preferences prefs = salesView.getPreferencesDialog().getPreferences();
        String url = prefs.get("url", "jdbc:mysql://localhost:3306/SALESDB");
        String user = prefs.get("user", "root");
        String password = prefs.get("password", "root");
        String port = prefs.get("port", "3306");

        salesView.getPreferencesDialog().setDefaultPreferences(url, user, password, port);
    }

    private void initPreferencesListener() {
        salesView.getPreferencesDialog().setPreferencesListener(new IPreferencesListener() {
            @Override
            public void preferencesSet(String url, String user, String password, String port) {
                Preferences prefs = salesView.getPreferencesDialog().getPreferences();
                prefs.put("url", url);
                prefs.put("user", user);
                prefs.put("password", password);
                prefs.put("port", port);
            }
        });
    }

    private void initComboBoxListener() {
        JComboBox<Customer> customerComboBox = salesView.getSelectCustomerPanel().getCustomerComboBox();
        customerComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent selection) {
                int state = selection.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    handleSelectCustomerClick(selection);
                }
            }
        });
    }

}
