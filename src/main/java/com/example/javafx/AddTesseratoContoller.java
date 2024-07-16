package com.example.javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AddTesseratoContoller<AlertMessage, string> implements Initializable {

    @FXML
    private DatePicker DataDiNascita_atleta;

    @FXML
    private TextField Email_atleta;

    @FXML
    private ChoiceBox<?> abbonamento_atleta;

    @FXML
    private Button aggiornaBtn_atleta;

    @FXML
    private TextField cavallo_atleta;

    @FXML
    private TextField cell_atleta;

    @FXML
    private AnchorPane certificatoMedico_atleta;

    @FXML
    private TextField cognome_atleta;

    @FXML
    private Button creaBtn_atleta;

    @FXML
    private ImageView imageView_atleta;

    @FXML
    private Button importBtn_atleta;

    @FXML
    private TextField lezioni_atleta;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField nome_atleta;


    Errorlabel alert = new Errorlabel("Questo è un messaggio di avviso!");
        alert.show();
        
    //public AlertMessage alert = new AlertMessage();

    private void creaBtn_atleta(){

        if(nome_atleta.getText().isEmpty()
        || Email_atleta.getText().isEmpty()
        ||cavallo_atleta.getText().isEmpty()
        ||cell_atleta.getText().isEmpty()
        ||cognome_atleta.getText().isEmpty()
        ||lezioni_atleta.getText().isEmpty()
        ||abbonamento_atleta.getSelectionModel().isEmpty()
        ||imageView_atleta.getImage().isError()
        ) {
            alert.Errorlabel("Riempi tutti i campi vuoti!");
        } else {

        }
    
    
    }

    
/*
   public void yearList(){
    List<string> listY = new ArrayList<>();

        for(String data : ListData.year){
            listY.add((string) data);
        }

        ObservableList listData = FXCollections.observableArrayList(listY);
        abbonamento_atleta.setItems(listData);


   }
*/


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        yearList();
    }

}
