package com.example.logic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;


public class UtilLogicFun {

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
}
