package myProject.presenter;

import myProject.model.DatabaseServiceJobs;
import myProject.view.CustomerSalesView;

public class Presenter {

    private DatabaseServiceJobs dbServiceJobs;
    private CustomerSalesView mainGUI;

    public Presenter(CustomerSalesView customerSalesView, DatabaseServiceJobs dbServiceJobs) {
        this.mainGUI = customerSalesView;
        this.dbServiceJobs = dbServiceJobs;
    }
}
