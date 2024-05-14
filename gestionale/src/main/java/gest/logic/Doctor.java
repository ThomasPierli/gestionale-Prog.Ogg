package gest.logic;

import gest.logic.principalclasscomponent.Person;
import gest.logic.principalclasscomponent.Visit;
import java.util.ArrayList;




public class Doctor extends Person {
   private ArrayList<Visit> visits;

    public Doctor(String firstName, String lastName, String email, String phoneNumber, ArrayList<Visit> visits) {
        super(firstName, lastName, email, phoneNumber);
        this.visits = visits;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
    }
    
}