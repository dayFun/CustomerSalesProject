package myProject.presenter;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;

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
        addItemListenerToComboBox();
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
        salesView.getStatisticsPanel().disableLabels();
    }

    private void addItemListenerToComboBox() {
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
