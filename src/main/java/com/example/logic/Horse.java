package com.example.logic;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.List;

import com.example.logic.principalclasscomponent.Person;
import com.example.logic.principalclasscomponent.Visit.HorseVisitDetails;


public class Horse {
    private String Name;
    private LocalDate DateofBirth;
    private String Breed;
    private String Gender;
    private String CoatColor;
    private Double Height;
    private Person Owner;
    private String Description;
    private BufferedImage ImageHorse;
    private List<HorseVisitDetails> HealtList;
    public Horse(String name, LocalDate dateofBirth, String breed, String gender, String coatColor, Double height,
            Person owner, String description, BufferedImage imageHorse, List<HorseVisitDetails> healtList) {
        Name = name;
        DateofBirth = dateofBirth;
        Breed = breed;
        Gender = gender;
        CoatColor = coatColor;
        Height = height;
        Owner = owner;
        Description = description;
        ImageHorse = imageHorse;
        HealtList = healtList;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public LocalDate getDateofBirth() {
        return DateofBirth;
    }
    public void setDateofBirth(LocalDate dateofBirth) {
        DateofBirth = dateofBirth;
    }
    public String getBreed() {
        return Breed;
    }
    public void setBreed(String breed) {
        Breed = breed;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public String getCoatColor() {
        return CoatColor;
    }
    public void setCoatColor(String coatColor) {
        CoatColor = coatColor;
    }
    public Double getHeight() {
        return Height;
    }
    public void setHeight(Double height) {
        Height = height;
    }
    public Person getOwner() {
        return Owner;
    }
    public void setOwner(Person owner) {
        Owner = owner;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public BufferedImage getImageHorse() {
        return ImageHorse;
    }
    public void setImageHorse(BufferedImage imageHorse) {
        ImageHorse = imageHorse;
    }
    public List<HorseVisitDetails> getHealtList() {
        return HealtList;
    }
    public void setHealtList(List<HorseVisitDetails> healtList) {
        HealtList = healtList;
    }
}
