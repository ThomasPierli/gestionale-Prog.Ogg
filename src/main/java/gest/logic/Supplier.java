package gest.logic;

import java.util.ArrayList;

import gest.logic.principalclasscomponent.Order;
import gest.logic.principalclasscomponent.Person;

public class Supplier extends Person{


    private String Info;    
    private ArrayList<Order> Orders;

    public Supplier(String firstName, String lastName, String email, String phoneNumber, String info,
            ArrayList<Order> orders) {
        super(firstName, lastName, email, phoneNumber);
        Info = info;
        Orders = orders;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        Orders = orders;
    }   

}
