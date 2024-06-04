package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlDB {
    public static  Connection connection(){
        Connection conn= null;
        String url= "jdbc:sqlite:gestionale.db";
        try {
            conn=DriverManager.getConnection(url);
            System.out.println("ridi ridi che la nonna ha fatto gli gnocchi e si è collegato bene");
        } catch (SQLException e) {
        System.out.println("qualcosa non va: non ci siamo connessi ");
        System.out.println(e.getMessage());
        }
        return conn;
    }
    
}
