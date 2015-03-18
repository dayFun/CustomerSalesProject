package myProject.controller;

import java.awt.event.ItemEvent;

import myProject.dao.CustomerDao;
import myProject.dao.OrdersDao;
import myProject.events.LoadCustomersEvent;
import myProject.listeners.ILoadCustomersListener;
import myProject.listeners.ISelectCustomerListener;
import myProject.view.MainGUI;

public class Controller {

    private DatabaseServiceJobs dbServiceJobs;
    private MainGUI mainGUI;

    public Controller(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
        dbServiceJobs = new DatabaseServiceJobs(new CustomerDao(), new OrdersDao());
        initListeners();
    }

    private void initListeners() {
        mainGUI.setLoadCustomersListener(new ILoadCustomersListener() {
            @Override
            public void loadCustomers() {
                dbServiceJobs.loadCustomers();
            }
        });

        mainGUI.setSelectCustomerListener(new ISelectCustomerListener() {
            @Override
            public void populateComboBox(LoadCustomersEvent e) {
                System.err.println("Did I make it here???");

            }

            @Override
            public void selectedCustomerEvent(ItemEvent e) {}
        });
    }

    public MainGUI getCustomerGUI() {
        return mainGUI;
    }
}
