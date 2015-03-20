package myProject.listeners;

import java.awt.event.ItemEvent;
import java.util.EventListener;

import myProject.events.LoadCustomersEvent;

public interface ICustomerListener extends EventListener {

    public void customersLoaded(LoadCustomersEvent e);

    public void selectedCustomerEvent(ItemEvent e);
}
