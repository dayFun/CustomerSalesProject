package myProject.events;

import java.util.EventObject;
import java.util.List;

import myProject.model.Order;

public class LoadOrdersEvent extends EventObject {

    private static final long serialVersionUID = -2044247818419917976L;
    private List<Order> ordersList;

    public LoadOrdersEvent(Object source, List<Order> ordersList) {
        super(source);
        this.ordersList = ordersList;
    }

    public List<Order> getCustomerList() {
        return ordersList;
    }

    public void setCustomerList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }
}
