package com.example.logic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;

import com.example.App;

import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UtilLogicFun {

    public static boolean newscene(Stage stage,String fxmlname){
        try {
              Scene scene = new Scene(App.loadFXML(fxmlname));
              stage.setScene(scene);
              stage.show();
              System.out.println("ho cambiato scena");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("non va il cambio scena");
        }
              
        return true;
    }
    
    public static byte[] convertToByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    public static int getid(PreparedStatement prep) throws SQLException{
         ResultSet key = prep.getGeneratedKeys();
            if (key.next()) {
                return key.getInt(1);
            } else {
                throw new SQLException("non sono riuscito a recuperare l'id");
            }
    }

    public static void resclose(AutoCloseable res){
        if (res!=null){
            try { res.close();
                
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public static boolean controlPassword(String text) {
        return text.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[£$%&!_-]).+$") && (text.length()>8 && text.length()<50);
    }
    
    public static boolean controlengthstring(String text) {
        return (text.length()>2 && text.length()<30);
    }
    
    public static boolean controlmail(String text) {
        return (text.length()>2 && text.length()<30) && text.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
    }

    public static boolean  GetUserRemember(TextField userormail, PasswordField password){
        Properties prop= new Properties();
        try (InputStream input=new FileInputStream("src\\main\\resources\\com\\example\\credentials.properties")){
            prop.load(input);
            if (prop.get("CheckBox").equals("true")) {
                userormail.setText(prop.getProperty("userorname"));
                password.setText(prop.getProperty("password"));
                prop.setProperty("CheckBox", "false");
                OutputStream out=new FileOutputStream("src\\main\\resources\\com\\example\\credentials.properties");
                prop.store(out, "commento");
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean  InsertUserRemember(String userormail, String password) {
        Properties prop= new Properties();
        try (InputStream input=new FileInputStream("src\\main\\resources\\com\\example\\credentials.properties")){
            prop.load(input);
            prop.setProperty("CheckBox", "true");
            prop.setProperty("userorname", userormail);
            prop.setProperty("password", password);
            OutputStream out=new FileOutputStream("src\\main\\resources\\com\\example\\credentials.properties");
            prop.store(out, "commento");
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean GetQUestionRememberPassword(TextField question){
        Properties prop= new Properties();
        Random random = new Random();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("src\\main\\resources\\com\\example\\credentials.properties"), StandardCharsets.UTF_8)){
            prop.load(reader);
            String string=prop.getProperty("question"+random.nextInt(21));
            question.setPromptText("?" + string);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    


}
