package myProject.events;

import java.util.EventObject;
import java.util.List;

import myProject.model.Customer;

public class LoadCustomersEvent extends EventObject {

    private static final long serialVersionUID = -2044247818419917976L;
    private List<Customer> customerList;

    public LoadCustomersEvent(Object source, List<Customer> customerList) {
        super(source);
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
