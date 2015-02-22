package myProject.controller;

import myProject.view.CustomerView;
import myProject.view.ICustomerViewListener;

public class Presenter {

    private IServiceJobs serviceJobs;
    private CustomerView customerView;

    public Presenter(CustomerView customerView, final IServiceJobs serviceJobs) {
        this.customerView = customerView;
        this.serviceJobs = serviceJobs;
        customerView.setViewListener(new ICustomerViewListener() {

            @Override
            public void clear() {
                serviceJobs.clear();
            }

            @Override
            public void loadCustomersFromDatabase() {

            }
        });

    }

    public CustomerView getCustomerTableView() {
        return customerView;
    }

    public void refreshView() {
        // customerView.set
    }
}
