package gest.logic;

import gest.logic.principalclasscomponent.Person;

import java.util.ArrayList;

import gest.logic.principalclasscomponent.HorseVisit;


public class Doctor extends Person {
   
    private ArrayList<HorseVisit> visitNum;
    

    public Doctor(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
        
    }
    
}