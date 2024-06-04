package com.example.database;

import java.awt.Label;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.logic.UserSession;
import com.example.logic.UtilLogicFun;

public class getobjectdb {

    public static boolean  LoginandGetuser(String email, String password,Label label){
            String sqlIsValidLogin="SELECT * INTO User WHERE Email = ? AND Password = ?";
            Connection conn=null;
            PreparedStatement prepcontrol=null;
            ResultSet rs=null;
            boolean ris=false;            
            try {
                conn=ControlDB.connection();
                prepcontrol=conn.prepareStatement(sqlIsValidLogin);

                prepcontrol.setString(1, email);
                prepcontrol.setString(2, password);
                rs = prepcontrol.executeQuery();
                if (rs.next()) {
                   UserSession.GetInstance().setId(rs.getInt(1));
                   UserSession.getInstance().setEmail(rs.getString(2));
                   UserSession.getInstance().setPassword(rs.getString(3));
                   UserSession.getInstance().setUserName(rs.getString(4));
                   UserSession.getInstance().setFirstName(rs.getString(5));
                   UserSession.getInstance().setLastName(rs.getString(6));
                   UserSession.getInstance().setId_ridingschool(rs.getInt(7));
                   label.setText("Perfetto!");
                ris=true;
                }else{
                    label.setText("email o password errati o non registrati");
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
        String sqlIsValidMail="SELECT COUNT (*) INTO User WHERE Email = ? ";
        Connection conn=null;
        PreparedStatement prepcontrol=null;
        ResultSet rs=null;
        Boolean ris=true;
        try {
            conn=ControlDB.connection();
            prepcontrol=conn.prepareStatement(sqlIsValidMail);
            prepcontrol.setString(1, email);
            rs = prepcontrol.executeQuery();
            if (rs.next()) {
                ris=false;
                label.setText("questa mail è gia registrata");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            AutoCloseable[] clos={conn,prepcontrol};
            for (AutoCloseable clo : clos) {
                UtilLogicFun.resclose(clo);                    
            }
        }
        return ris;
    }



    public static Integer getIdtabByobb(String tab, String obb,String name) throws SQLException{
        String sql = "SELECT id FROM "+tab+" WHERE "+obb+" = ?";
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
            e.getMessage();
        } finally {
            AutoCloseable[] clos={conn,rs,pstmt};
            for (AutoCloseable clo : clos) {
                UtilLogicFun.resclose(clo);                    
            }
        }
        throw new SQLException("non sono riuscito a recuperare l'id_doctor");
    }

}
