package gest.logic;

import java.util.ArrayList;
import gest.logic.principalclasscomponent.Order;
import gest.logic.principalclasscomponent.Person;

public class Supplier extends Person{
    
    private ArrayList<Order> Orders;

    public Supplier(String firstName, String lastName, String email, String phoneNumber, ArrayList<Order> orders) {
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
