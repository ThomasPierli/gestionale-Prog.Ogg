package gest.logic;

import java.util.ArrayList;
import gest.logic.principalclasscomponent.Order;
import gest.logic.principalclasscomponent.Person;

public class Provider extends Person{
    
    private ArrayList<Order> Orders;

    public Provider(String firstName, String lastName, String email, String phoneNumber, ArrayList<Order> orders) {
        super(firstName, lastName, email, phoneNumber);
        Orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        Orders = orders;
    }

    

}
