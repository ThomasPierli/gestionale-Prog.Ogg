package com.example.logic;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

import com.example.logic.principalclasscomponent.Lessons;
import com.example.logic.principalclasscomponent.Medicalcertificate;
import com.example.logic.principalclasscomponent.Person;
import com.example.logic.principalclasscomponent.Subscription;



public class Athlete extends Person {
    
    private LocalDate DateofBirth;
    private Person Parent1;
    private Person Parent2;
    private Lessons lessons;
    private Subscription subscription;
    private Medicalcertificate medicalcertificate;
    private BufferedImage Idimage;
    private Integer ID_athlete;
    public Athlete(String firstName, String lastName, String email, String phoneNumber, Integer id_person,
            LocalDate dateofBirth, Person parent1, Person parent2, Lessons lessons, Subscription subscription,
            Medicalcertificate medicalcertificate, BufferedImage idimage, Integer iD_athlete) {
        super(firstName, lastName, email, phoneNumber, id_person);
        DateofBirth = dateofBirth;
        Parent1 = parent1;
        Parent2 = parent2;
        this.lessons = lessons;
        this.subscription = subscription;
        this.medicalcertificate = medicalcertificate;
        Idimage = idimage;
        ID_athlete = iD_athlete;
    }
    public LocalDate getDateofBirth() {
        return DateofBirth;
    }
    public void setDateofBirth(LocalDate dateofBirth) {
        DateofBirth = dateofBirth;
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
    public Integer getID_athlete() {
        return ID_athlete;
    }
    public void setID_athlete(Integer iD_athlete) {
        ID_athlete = iD_athlete;
    }
}
