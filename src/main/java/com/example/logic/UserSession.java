package com.example.logic;

public class UserSession{
    private static UserSession instance;

    private String FirstName;
    private String LastName;
    private String UserName;
    private String Email;
    private String Password;
    private Integer id_ridingschool;
    private Integer id;

    private  UserSession() {
        FirstName = null;
        LastName = null;
        UserName = null;
        Email = null;
        Password = null;
        id_ridingschool=null;
        id=null;
    }
    public static UserSession GetInstance(){
        if (instance==null) {
            instance=new UserSession();
        }
        return instance;
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
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public Integer getId_ridingschool() {
        return id_ridingschool;
    }
    public void setId_ridingschool(Integer id_ridingschool) {
        this.id_ridingschool = id_ridingschool;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
   
}