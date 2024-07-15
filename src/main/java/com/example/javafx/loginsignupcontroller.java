package com.example.javafx;

import com.example.database.getobjectdb;
import com.example.database.insertobjectindb;
import com.example.logic.UserSession;
import com.example.logic.UtilLogicFun;

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class loginsignupcontroller {

    @FXML
    private SplitPane prova;

    @FXML
    private AnchorPane loginpane;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField userormail;
    @FXML
    private Button loginButton;
    @FXML
    private Button ViewPassword;
    @FXML
    private Label Errorlabel;
    @FXML
    private TextField PasswordText;
    @FXML
    private Button gotosignup;
    @FXML
    private CheckBox rememberme;

    @FXML
    private AnchorPane signuppane;
    @FXML
    private Button gotologin;
    @FXML
    private Button signupButton;
    @FXML
    private Button infobutton;
    @FXML
    private PasswordField Passwordsignup;
    @FXML
    private TextField PasswordTextsignup;
    @FXML
    private Button ViewPasswordsignup;
    @FXML
    private TextField Username;
    @FXML
    private TextField Email;
    @FXML
    private TextField Lastname;
    @FXML
    private TextField Firstname;
    @FXML
    private TextField idridingschool;
    @FXML
    private Label Errorlabelsignup;
    @FXML
    private TextArea textinfo;

    @FXML
    private void initialize() {

        loginpane.setVisible(true);
        textinfo.setEditable(false);
        if(UtilLogicFun.GetUserRemember(userormail,Password)){
            rememberme.setSelected(true);
        }
        setupinsertlogform();
        setupinsertsignup();

        viewpassword(ViewPasswordsignup, Passwordsignup, PasswordTextsignup);
        viewpassword(ViewPassword, Password, PasswordText);

        loginButton.setOnMouseClicked(Event -> login());
        signupButton.setOnMouseClicked(Event -> signup());

        infobutton.setOnMouseEntered(Event -> textinfo.setVisible(true));
        infobutton.setOnMouseExited(Event -> textinfo.setVisible(false));

        gotosignup.setOnMouseClicked(Event -> {
            prova.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            signuppane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            signuppane.setVisible(true);
            loginpane.setVisible(false);
        });
        gotologin.setOnMouseClicked(Event -> {
            prova.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            signuppane.setVisible(false);
            loginpane.setVisible(true);
        });
    }

    private void viewpassword(Button curr, PasswordField password, TextField passwordtxt){

        curr.setOnMousePressed(Event -> {
            passwordtxt.setText(password.getText());
            passwordtxt.setVisible(true);
            password.setVisible(false);
        });
        curr.setOnMouseReleased(Event -> {
            passwordtxt.setVisible(false);
            password.setVisible(true);
        });

    }

    @FXML
    private void login() {
        if (rememberme.isSelected()) { 
            UtilLogicFun.InsertUserRemember(userormail.getText(),Password.getText());                
        }
        if (userormail.getText().trim().isEmpty() || Password.getText().trim().isEmpty() ) {
            Errorlabel.setText("Non lasciare i campi vuoti!");
            
        } else if(getobjectdb.LoginandGetuser(userormail.getText().trim(), Password.getText().trim(), Errorlabel)) {
            UtilLogicFun.newscene((Stage) loginButton.getScene().getWindow(), "dashboard1");
        }
        userormail.clear();
        Password.clear();
        userormail.requestFocus();
    }

    @FXML
    private void signup() {

        if (Firstname.getText().trim().isEmpty() || Lastname.getText().trim().isEmpty() || Email.getText().trim().isEmpty()
                || Username.getText().trim().isEmpty()) {

            Errorlabelsignup.setVisible(true);
            Errorlabelsignup.setText("Non lasciare campi vuoti!");
            return;
        } else if (!idridingschool.getText().matches("\\d+")) {
            Errorlabelsignup.setText("il codice del maneggio può contenere solo cifre!");
            return;

        } else if(!UtilLogicFun.controlPassword(Passwordsignup.getText())){
            Errorlabelsignup.setText("la password deve contenere almeno una maiuscola,una\n minuscola, un numero e un carattere speciale (!£$%&-_)");
            return;

        }else if(!UtilLogicFun.controlmail(Email.getText())){
            Errorlabelsignup.setText("la mail non è compilata correttamente");
            return;

        }

        UserSession.GetInstance().setId_ridingschool(Integer.parseInt(idridingschool.getText().trim()));                
        UserSession.GetInstance().setFirstName(Firstname.getText().trim());
        UserSession.GetInstance().setLastName(Lastname.getText().trim());
        UserSession.GetInstance().setEmail(Email.getText().trim());
        UserSession.GetInstance().setUserName(Username.getText().trim());
        UserSession.GetInstance().setPassword(Passwordsignup.getText().trim());
        boolean ris = insertobjectindb.InsertNewUser(Errorlabelsignup);
        System.out.println(ris);

    }
    @FXML
    private void setupinsertlogform() {

        userormail.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (Password.getText().trim().isEmpty()) {
                    Password.requestFocus();
                } else {
                    login();
                }
            }
        });
        Password.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (userormail.getText().trim().isEmpty()) {
                    userormail.requestFocus();
                } else {
                    login();
                }
            }
        });
    }
    @FXML
    private void setupinsertsignup(){
        Firstname.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty()!=null) {
                    signupempty().requestFocus();
                } else {
                    signup();
                }
            }
        });
        Lastname.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty()!=null) {
                    signupempty().requestFocus();
                } else {
                    signup();
                }
            }
        });
        Email.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty()!=null) {
                    signupempty().requestFocus();
                } else {
                    signup();
                }
            }
        });
        Username.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty()!=null) {
                    signupempty().requestFocus();
                } else {
                    signup();
                }
            }
        });
        Passwordsignup.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty()!=null) {
                    signupempty().requestFocus();
                } else {
                    signup();
                }
            }
        });
        idridingschool.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty()!=null) {
                    signupempty().requestFocus();
                } else {
                    signup();
                }
            }
        });
    }
    @FXML
    private Node signupempty(){
        if(Firstname.getText().trim().isEmpty()) return Firstname;
        if(Lastname.getText().trim().isEmpty()) return Lastname;
        if(Email.getText().trim().isEmpty()) return Email;
        if(Username.getText().trim().isEmpty()) return Username;
        if(Passwordsignup.getText().trim().isEmpty()) return Passwordsignup;
        if(idridingschool.getText().trim().isEmpty()) return idridingschool;
        return null;
    }
}