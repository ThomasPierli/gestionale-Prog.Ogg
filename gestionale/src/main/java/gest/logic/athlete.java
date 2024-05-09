package gest.logic;

import java.time.LocalDate;
import java.awt.image.BufferedImage;
import gest.logic.athletecomponent.Lessons;
import gest.logic.athletecomponent.Medicalcertificate;
import gest.logic.athletecomponent.Parent;
import gest.logic.athletecomponent.Subscription;


public class athlete {
    private String FirstName;
    private String LastName;
    private String PhomeNumber; 
    private LocalDate DateofBirth;
    private String Email;
    private Parent Parent1;
    private Parent Parent2;
    private Lessons lessons;
    private Subscription subscription;
    private Medicalcertificate medicalcertificate;
    private BufferedImage Idimage;

    public athlete(String firstName, String lastName, String phomeNumber, LocalDate dateofBirth, String email,
            Parent parent1, Parent parent2, Lessons lessons, Subscription subscription,
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

    public Parent getParent1() {
        return Parent1;
    }

    public void setParent1(Parent parent1) {
        Parent1 = parent1;
    }

    public Parent getParent2() {
        return Parent2;
    }

    public void setParent2(Parent parent2) {
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
