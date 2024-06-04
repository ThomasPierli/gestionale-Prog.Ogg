
 package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainPageCont {

    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML
    private Label wel;

    @FXML
    public void initialize(){
        wel.setText("welcome");
        loginButton.setText("sono gia registrato");
        signupButton.setText("registrati");
        loginButton.setOnMouseClicked(e->handleloginbutton());
        signupButton.setOnMouseClicked(e->handlesignupbutton());
        
    }

    public void handleloginbutton(){
        UtilFxFun.newscene((Stage)loginButton.getScene().getWindow(),"MainPage");//sostituire con il nome della prossima pagina
    }

    public void handlesignupbutton(){
        UtilFxFun.newscene((Stage)loginButton.getScene().getWindow(), "MainPage");//pure qua;

    }


    

    
}