package gest.logic;

public class UserSession{
    private static UserSession instance;
    private String Name;
    private String Email;
    private String Password;
    private Integer id_ridingschool;

    private  UserSession() {
        Name = null;
        Email = null;
        Password = null;
        id_ridingschool=null;
    }
    public static UserSession GetInstance(){
        if (instance==null) {
            instance=new UserSession();
        }
        return instance;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
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
    public int getId_ridingschool() {
        return id_ridingschool;
    }
    public void setId_ridingschool(int id_ridingschool) {
        this.id_ridingschool = id_ridingschool;
    }    
}