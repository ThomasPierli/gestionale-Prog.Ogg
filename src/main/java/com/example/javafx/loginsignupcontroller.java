package com.example.javafx;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.database.getobjectdb;
import com.example.database.insertobjectindb;
import com.example.logic.UserSession;
import com.example.logic.UtilLogicFun;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Button forgotpassword;

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
    private Button GotoSignupQuestion;

    @FXML
    private AnchorPane SignupQuestionpane;
    @FXML
    private TextField Question1;
    @FXML
    private TextField Question2;
    @FXML
    private TextField Question3;
    @FXML
    private Button ChangeQuestion1;
    @FXML
    private Button ChangeQuestion2;
    @FXML
    private Button ChangeQuestion3;
    @FXML
    private Label ErrorQuestion;

    @FXML
    private AnchorPane passwordrecoverypane;
    @FXML
    private TextField EmailForPassword;
    @FXML
    private Button ControlEmailForPasswordButton;
    @FXML
    private Label resultconfirmemail;
    @FXML
    private TextField question01;
    @FXML
    private TextField question02;
    @FXML
    private TextField question03;
    @FXML
    private Label resultpasswordrecovery;
    @FXML
    private Button passwordrecoverybutton;

    @FXML
    private void initialize() {

        loginpane.setVisible(true);
        textinfo.setEditable(false);

        if (UtilLogicFun.GetUserRemember(userormail, Password)) {
            rememberme.setSelected(true);
        }
        setupinsertlogform();
        setupinsertsignup();

        viewpassword(ViewPasswordsignup, Passwordsignup, PasswordTextsignup);
        viewpassword(ViewPassword, Password, PasswordText);

        /*
         * Parent root;
         * try {
         * root = FXMLLoader.load(getClass().getResource("DashboardFinal.fxml"));
         * } catch (IOException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         * 
         * Stage stage = new Stage();
         * stage.setTitle("University Management System | Admin Portal");
         * 
         * stage.show();
         */

        loginButton.setOnMouseClicked(Event -> login());
        signupButton.setOnMouseClicked(Event -> LoginControlQuestionAndEnter());
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
        GotoSignupQuestion.setOnMouseClicked(Event -> {
            ValidateAndSignup();
        });
        ChangeQuestion1.setOnMouseClicked(Event -> {
            do {
                UtilLogicFun.GetQUestionRememberPassword(Question1);
            } while (Question1.getPromptText().equals(Question2.getPromptText())
                    || Question1.getPromptText().equals(Question3.getPromptText()));
        });
        ChangeQuestion2.setOnMouseClicked(Event -> {
            do {
                UtilLogicFun.GetQUestionRememberPassword(Question2);
            } while (Question2.getPromptText().equals(Question1.getPromptText())
                    || Question2.getPromptText().equals(Question3.getPromptText()));
        });
        ChangeQuestion3.setOnMouseClicked(Event -> {
            do {
                UtilLogicFun.GetQUestionRememberPassword(Question3);
            } while (Question3.getPromptText().equals(Question1.getPromptText())
                    || Question3.getPromptText().equals(Question2.getPromptText()));

        });
        forgotpassword.setOnMouseClicked(Event -> {
            loginpane.setVisible(false);
            passwordrecoverypane.setVisible(true);

        });
        ControlEmailForPasswordButton.setOnMouseClicked(Event -> {
            Integer ris = null;
            try {
                ris = getobjectdb.getobbytabByobb("ID_User", "User", "Email", EmailForPassword.getText().trim());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (ris != null) {
                resultconfirmemail.setText("Perfetto! adesso rispondi a queste domande\n e riotterrai la password");
                GestQuestionRecoveryPassword(ris);
            } else {
                resultconfirmemail.setText("sei sicuro che la mail sia giusta?\nnon trovo nessuna corrispondenza");
            }
        });
    }

    private void viewpassword(Button curr, PasswordField password, TextField passwordtxt) {

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
            UtilLogicFun.InsertUserRemember(userormail.getText(), Password.getText());
        }
        if (userormail.getText().trim().isEmpty() || Password.getText().trim().isEmpty()) {
            Errorlabel.setText("Non lasciare i campi vuoti!");

        } else if (getobjectdb.LoginandGetuser(userormail.getText().trim(), Password.getText().trim(), Errorlabel)) {
            UtilLogicFun.newscene((Stage) loginButton.getScene().getWindow(), "dashboard1");
        }
    }

    @FXML
    private void GestQuestionRecoveryPassword(Integer id) {
        Map<String, String> QuestionAndAnswer = getobjectdb.GetQuestionAndAnswerPassword(id, resultpasswordrecovery);
        List<String> question = new ArrayList<>(QuestionAndAnswer.keySet());
        question01.setPromptText(question.get(0));
        question02.setPromptText(question.get(1));
        question03.setPromptText(question.get(2));
        passwordrecoverybutton.setOnMouseClicked(Event -> {
            if (question01.getText().trim().equals(QuestionAndAnswer.get(question.get(0))) &&
                    question02.getText().trim().equals(QuestionAndAnswer.get(question.get(1))) &&
                    question03.getText().trim().equals(QuestionAndAnswer.get(question.get(2)))) {
                passwordrecoverypane.setVisible(false);
                loginpane.setVisible(true);
                Password.setText(getobjectdb.GetPasswordById(id, resultpasswordrecovery));
            } else {
                resultpasswordrecovery.setText("le risposte non sono");
            }
        });

    }

    @FXML
    private void LoginControlQuestionAndEnter() {

        if (!Question1.getText().trim().isEmpty() || !Question3.getText().trim().isEmpty()
                || !Question3.getText().isEmpty()) {
            insertobjectindb.InsertQuestionPassword(Question1.getPromptText(), Question1.getText().trim());
            insertobjectindb.InsertQuestionPassword(Question2.getPromptText(), Question2.getText().trim());
            insertobjectindb.InsertQuestionPassword(Question3.getPromptText(), Question3.getText().trim());
            UtilLogicFun.newscene((Stage) loginButton.getScene().getWindow(), "dashboard1");
        } else {
            ErrorQuestion
                    .setText("non lasciare le domande vuote!\n piuttosto cambia domanda con i pulsanti li accanto");
        }

    }

    @FXML
    private boolean ValidateAndSignup() {

        if (Firstname.getText().trim().isEmpty() || Lastname.getText().trim().isEmpty()
                || Email.getText().trim().isEmpty()
                || Username.getText().trim().isEmpty()) {

            Errorlabelsignup.setVisible(true);
            Errorlabelsignup.setText("Non lasciare campi vuoti!");
            return false;
        } else if (!idridingschool.getText().matches("\\d+")) {
            Errorlabelsignup.setText("il codice del maneggio può contenere solo cifre!");
            return false;

        } else if (!UtilLogicFun.controlPassword(Passwordsignup.getText())) {
            Errorlabelsignup.setText(
                    "la password deve contenere almeno una maiuscola,una\n minuscola, un numero e un carattere speciale (!£$%&-_)");
            return false;

        } else if (!UtilLogicFun.controlmail(Email.getText())) {
            Errorlabelsignup.setText("la mail non è compilata correttamente");
            return false;
        }
        UserSession.GetInstance().setId_ridingschool(Integer.parseInt(idridingschool.getText().trim()));
        UserSession.GetInstance().setFirstName(Firstname.getText().trim());
        UserSession.GetInstance().setLastName(Lastname.getText().trim());
        UserSession.GetInstance().setEmail(Email.getText().trim());
        UserSession.GetInstance().setUserName(Username.getText().trim());
        UserSession.GetInstance().setPassword(Passwordsignup.getText().trim());
        if (insertobjectindb.InsertNewUser(Errorlabelsignup)) {
            signuppane.setVisible(false);
            SignupQuestionpane.setVisible(true);
            return true;
        }
        return false;
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
    private void setupinsertsignup() {
        Firstname.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty() != null) {
                    signupempty().requestFocus();
                } else {
                    ValidateAndSignup();
                }
            }
        });
        Lastname.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty() != null) {
                    signupempty().requestFocus();
                } else {
                    ValidateAndSignup();
                }
            }
        });
        Email.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty() != null) {
                    signupempty().requestFocus();
                } else {
                    ValidateAndSignup();
                }
            }
        });
        Username.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty() != null) {
                    signupempty().requestFocus();
                } else {
                    ValidateAndSignup();
                }
            }
        });
        Passwordsignup.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty() != null) {
                    signupempty().requestFocus();
                } else {
                    ValidateAndSignup();
                }
            }
        });
        idridingschool.setOnKeyPressed(Event -> {
            if (Event.getCode() == KeyCode.ENTER) {
                if (signupempty() != null) {
                    signupempty().requestFocus();
                } else {
                    ValidateAndSignup();
                }
            }
        });
    }

    @FXML
    private Node signupempty() {
        if (Firstname.getText().trim().isEmpty()) {
            return Firstname;
        }
        if (Lastname.getText().trim().isEmpty()) {
            return Lastname;
        }
        if (Email.getText().trim().isEmpty()) {
            return Email;
        }
        if (Username.getText().trim().isEmpty()) {
            return Username;
        }
        if (Passwordsignup.getText().trim().isEmpty()) {
            return Passwordsignup;
        }
        if (idridingschool.getText().trim().isEmpty()) {
            return idridingschool;
        }
        return null;
    }
}
