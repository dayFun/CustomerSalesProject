package myProject.listeners;

import java.util.EventListener;

import myProject.view.LoadCustomersEvent;

public interface ICustomerListener extends EventListener {
    public void doStuff(LoadCustomersEvent e);
}
