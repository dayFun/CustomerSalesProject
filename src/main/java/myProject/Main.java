package myProject;

import java.awt.EventQueue;

import myProject.dao.CustomerDao;
import myProject.dao.OrdersDao;
import myProject.model.DatabaseServiceJobs;
import myProject.presenter.Presenter;
import myProject.view.CustomerSalesView;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CustomerSalesView customerSalesView = new CustomerSalesView();
                DatabaseServiceJobs dbServiceJobs = new DatabaseServiceJobs(new CustomerDao(), new OrdersDao());

                Presenter controller = new Presenter(customerSalesView, dbServiceJobs);

                customerSalesView.setVisible(true);
            }
        });

    }
}
