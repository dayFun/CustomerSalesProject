package myProject.listeners;

import java.awt.event.ItemEvent;
import java.util.EventListener;

import myProject.events.LoadCustomersEvent;

public interface ISelectCustomerListener extends EventListener {

    public void populateComboBox(LoadCustomersEvent e);

    public void selectedCustomerEvent(ItemEvent e);
}
