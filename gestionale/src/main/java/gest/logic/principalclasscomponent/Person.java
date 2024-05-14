package gest.logic.principalclasscomponent;


public class Person {
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    
    public Person(String firstName, String lastName, String email, String phoneNumber) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
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

    //direi che in questa classe non servono altre funzioni ecc,
    // magari riprendiamo la stessa nelle utils solo per controllare la mail e numeroS
}
