package com.example.logic;

import java.util.ArrayList;

import com.example.logic.principalclasscomponent.Order;
import com.example.logic.principalclasscomponent.Person;

public class Supplier extends Person {

    private String Info;
    private ArrayList<Order> Orders;

    public Supplier(String firstName, String lastName, String email, String phoneNumber, String info,
            ArrayList<Order> orders) {
        super(firstName, lastName, email, phoneNumber, id_person);
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
