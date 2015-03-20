package myProject;

import java.awt.EventQueue;

import myProject.dao.CustomerDao;
import myProject.dao.OrdersDao;
import myProject.model.DatabaseServiceJobs;
import myProject.presenter.Presenter;
import myProject.view.SalesView;

public class Application {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SalesView customerSalesView = new SalesView();
                DatabaseServiceJobs dbServiceJobs = new DatabaseServiceJobs(new CustomerDao(), new OrdersDao());

                Presenter presenter = new Presenter(customerSalesView, dbServiceJobs);
                customerSalesView.attachListeners(presenter);

                customerSalesView.setVisible(true);
            }
        });

    }
}
