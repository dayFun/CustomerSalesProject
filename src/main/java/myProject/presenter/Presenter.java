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
    }

    @Override
    public void handleSelectCustomerClick(ItemEvent event) {
        Customer selectedCustomer = (Customer) event.getItem();
        List<Order> orders = dbServiceJobs.loadOrdersForCustomer(selectedCustomer);
        salesView.getOrdersTablePanel().setData(orders);
    }

    @Override
    public void handleClearButtonClick() {
        salesView.getOrdersTablePanel().clear();
        salesView.getSelectCustomerPanel().resetComboBox();
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
