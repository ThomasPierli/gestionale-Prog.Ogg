package gest.logic;

import java.util.ArrayList;

import gest.logic.principalclasscomponent.Person;
import gest.logic.principalclasscomponent.Visit;



public class Doctor extends Person {
   private ArrayList<Visit> visits;

public Doctor(String firstName, String lastName, String email, String phoneNumber, Integer id_person, ArrayList<Visit> visits) {
    super(firstName, lastName, email, phoneNumber, id_person);
    this.visits = visits;
}

public ArrayList<Visit> getVisits() {
    return visits;
}

public void setVisits(ArrayList<Visit> visits) {
    this.visits = visits;
}
    
}