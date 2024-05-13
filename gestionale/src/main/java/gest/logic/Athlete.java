package gest.logic;

import java.time.LocalDate;

import gest.logic.principalclasscomponent.Lessons;
import gest.logic.principalclasscomponent.Medicalcertificate;
import gest.logic.principalclasscomponent.Person;
import gest.logic.principalclasscomponent.Subscription;

import java.awt.image.BufferedImage;


public class Athlete extends Person {
    
    public Athlete(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
        
    }
    private LocalDate DateofBirth;
    private Person Parent1;
    private Person Parent2;
    private Lessons lessons;
    private Subscription subscription;
    private Medicalcertificate medicalcertificate;
    private BufferedImage Idimage;

    

    //ci sono diverse funzioni di modifica e controllo da implementare che pero sono comuni a piu classi 
    //facciamo una classe util con dentro tutte queste funzioni? cosi evitiamo di scrivere lo stesso codice piu volte
    //in utils anche gestione IdImage
}
