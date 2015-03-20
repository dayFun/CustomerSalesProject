package myProject.presenter;

import java.awt.event.ItemEvent;
import java.util.List;

import myProject.listeners.ISalesViewListener;
import myProject.model.Customer;
import myProject.model.DatabaseServiceJobs;
import myProject.view.SalesView;

public class Presenter implements ISalesViewListener {

    private DatabaseServiceJobs dbServiceJobs;
    private SalesView salesView;

    public Presenter(SalesView customerSalesView, DatabaseServiceJobs dbServiceJobs) {
        this.salesView = customerSalesView;
        this.dbServiceJobs = dbServiceJobs;
    }

    @Override
    public void handleLoadOrdersClicked() {
        List<Customer> customersList = dbServiceJobs.loadCustomers();
        salesView.getSelectCustomerPanel().populateComboBox(customersList);
    }

    @Override
    public void handleSelectCustomerClick(ItemEvent e) {
        // TODO Auto-generated method stub
    }
}
