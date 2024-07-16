package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.example.logic.UserSession;
import com.example.logic.UtilLogicFun;

import javafx.scene.control.Label;

public class getobjectdb {

    public static boolean  LoginandGetuser(String emailoruser, String password,Label label){
            String sqlIsValidLogin="SELECT * FROM User WHERE (Email = ? OR UserName = ?) AND Password = ?";
            Connection conn=null;
            PreparedStatement prepcontrol=null;
            ResultSet rs=null;
            boolean ris=false;            
            try {
                conn=ControlDB.connection();
                prepcontrol=conn.prepareStatement(sqlIsValidLogin);

                prepcontrol.setString(1, emailoruser);
                prepcontrol.setString(2, emailoruser);
                prepcontrol.setString(3, password);
                rs = prepcontrol.executeQuery();
                if (rs.next()) {
                   UserSession.GetInstance().setId(rs.getInt(1));
                   UserSession.GetInstance().setEmail(rs.getString(2));
                   UserSession.GetInstance().setPassword(rs.getString(3));
                   UserSession.GetInstance().setUserName(rs.getString(4));
                   UserSession.GetInstance().setFirstName(rs.getString(5));
                   UserSession.GetInstance().setLastName(rs.getString(6));
                   UserSession.GetInstance().setId_ridingschool(rs.getInt(7));
                   label.setText("Perfetto!");
                ris=true;
                }else{
                    label.setText("Email o Password errati!");
                }        
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                label.setText("errori nel controllo delle credenziali");
            } finally {
                AutoCloseable[] clos={conn,prepcontrol};
                for (AutoCloseable clo : clos) {
                    UtilLogicFun.resclose(clo);                    
                }
            }
            return ris;
        }

    public static boolean ControlEmail(String email, Label label){
        String sqlIsValidMail="SELECT COUNT (*) FROM User WHERE Email = ? ";
        Connection conn=null;
        PreparedStatement prepcontrol=null;
        ResultSet rs=null;
        Boolean ris=true;
        try {
            conn=ControlDB.connection();
            prepcontrol=conn.prepareStatement(sqlIsValidMail);
            prepcontrol.setString(1, email);
            rs = prepcontrol.executeQuery();
            if (rs.getInt(1)>0) {
                ris=false;
                label.setText("questa mail è gia registrata");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ris=false;
            label.setText("errori nel controllo del codice maneggio");
        } finally {
            AutoCloseable[] clos={conn,prepcontrol};
            for (AutoCloseable clo : clos) {
                UtilLogicFun.resclose(clo);                    
            }
        }
        return ris;
    }

    public static boolean Controlidridingschool(Integer idridingschool, Label label){
        String sqlIsValidMail="SELECT COUNT (*) From RidingSchool WHERE ID_RidingSchool = ? ";
        Connection conn=null;
        PreparedStatement prepcontrol=null;
        ResultSet rs=null;
        Boolean ris=true;
        try {
            conn=ControlDB.connection();
            prepcontrol=conn.prepareStatement(sqlIsValidMail);
            prepcontrol.setInt(1, idridingschool);
            rs = prepcontrol.executeQuery();
            if (rs.getInt(1)==0) {
                ris=false;
                label.setText("questo codice maneggio non corrisponde\na nessun maneggio registrato");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ris=false;
            label.setText("errori nel controllo del codice maneggio");
        } finally {
            AutoCloseable[] clos={conn,prepcontrol};
            for (AutoCloseable clo : clos) {
                UtilLogicFun.resclose(clo);                    
            }
        }
        return ris;
    }

    public static Integer getobbytabByobb(String getob,String tab, String obb,String name) throws SQLException{
        String sql = "SELECT "+getob+" FROM "+tab+" WHERE "+obb+" = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=ControlDB.connection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, name); 

            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
           System.err.println(e.getMessage());
        } finally {
            AutoCloseable[] clos={conn,rs,pstmt};
            for (AutoCloseable clo : clos) {
                UtilLogicFun.resclose(clo);                    
            }
        }
        throw new SQLException("non sono riuscito a recuperare l'id");
    }

    public static Map<String,String> GetQuestionAndAnswerPassword(Integer id, Label errorlLabel){
        String sql = "SELECT Question, Answer FROM QuestionPassword WHERE id_User=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Map<String,String> resultmap=new HashMap<>();
        try {
            conn=ControlDB.connection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, id); 
            rs = pstmt.executeQuery();
            while (rs.next()) {
                resultmap.put(rs.getString("Question"), rs.getString("Answer"));
                System.err.println("ho recuperato una domanda e risposta");
            }
        } catch (SQLException e) {
            e.getMessage();
            errorlLabel.setText("abbiamo avuto problemi nel ritrovare le domande");
        } finally {
            AutoCloseable[] clos={conn,rs,pstmt};
            for (AutoCloseable clo : clos) {
                UtilLogicFun.resclose(clo);                    
            }
        }
        return resultmap;
    }

    public static String GetPasswordById(Integer id, Label errorLabel){
        String sql = "SELECT Password FROM User WHERE ID_User=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=ControlDB.connection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, id); 
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.getMessage();
            errorLabel.setText("abbiamo avuto problemi nel ritrovare la tua password");
        } finally {
            AutoCloseable[] clos={conn,rs,pstmt};
            for (AutoCloseable clo : clos) {
                UtilLogicFun.resclose(clo);                    
            }
        }
        return null;
    }

}
