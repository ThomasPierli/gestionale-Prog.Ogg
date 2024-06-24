package com.example.logic.principalclasscomponent;


public class Person {
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private Integer id_person;
    public Person(String firstName, String lastName, String email, String phoneNumber, Integer id_person) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
        this.id_person = id_person;
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
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public Integer getId_person() {
        return id_person;
    }
    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }
    
   
}
