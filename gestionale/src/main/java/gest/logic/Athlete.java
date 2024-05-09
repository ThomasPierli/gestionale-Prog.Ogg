package gest.logic;

import java.time.LocalDate;

import gest.logic.principalclasscomponent.Lessons;
import gest.logic.principalclasscomponent.Medicalcertificate;
import gest.logic.principalclasscomponent.Person;
import gest.logic.principalclasscomponent.Subscription;

import java.awt.image.BufferedImage;


public class Athlete {
    private String FirstName;
    private String LastName;
    private String PhomeNumber; 
    private LocalDate DateofBirth;
    private String Email;
    private Person Parent1;
    private Person Parent2;
    private Lessons lessons;
    private Subscription subscription;
    private Medicalcertificate medicalcertificate;
    private BufferedImage Idimage;

    public Athlete(String firstName, String lastName, String phomeNumber, LocalDate dateofBirth, String email,
            Person parent1, Person parent2, Lessons lessons, Subscription subscription,
            Medicalcertificate medicalcertificate, BufferedImage idimage) {
        FirstName = firstName;
        LastName = lastName;
        PhomeNumber = phomeNumber;
        DateofBirth = dateofBirth;
        Email = email;
        Parent1 = parent1;
        Parent2 = parent2;
        this.lessons = lessons;
        this.subscription = subscription;
        this.medicalcertificate = medicalcertificate;
        Idimage = idimage;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhomeNumber() {
        return PhomeNumber;
    }

    public void setPhomeNumber(String phomeNumber) {
        PhomeNumber = phomeNumber;
    }

    public LocalDate getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Person getParent1() {
        return Parent1;
    }

    public void setParent1(Person parent1) {
        Parent1 = parent1;
    }

    public Person getParent2() {
        return Parent2;
    }

    public void setParent2(Person parent2) {
        Parent2 = parent2;
    }

    public Lessons getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lessons) {
        this.lessons = lessons;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Medicalcertificate getMedicalcertificate() {
        return medicalcertificate;
    }

    public void setMedicalcertificate(Medicalcertificate medicalcertificate) {
        this.medicalcertificate = medicalcertificate;
    }

    public BufferedImage getIdimage() {
        return Idimage;
    }

    public void setIdimage(BufferedImage idimage) {
        Idimage = idimage;
    }

    
    
    

    //ci sono diverse funzioni di modifica e controllo da implementare che pero sono comuni a piu classi 
    //facciamo una classe util con dentro tutte queste funzioni? cosi evitiamo di scrivere lo stesso codice piu volte
    //in utils anche gestione IdImage
}
