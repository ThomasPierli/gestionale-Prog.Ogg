package com.example.javafx;

import java.io.IOException;

import com.example.App;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class UtilFxFun {

    public static boolean newscene(@SuppressWarnings("exports") Stage stage,String fxmlname){
        try {
              Scene scene = new Scene(App.loadFXML(fxmlname));
              stage.setScene(scene);

        } catch (IOException e) {
        }
              
        return true;
    }
    
}
