package com.example.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.example.logic.Athlete;
import com.example.logic.Doctor;
import com.example.logic.Horse;
import com.example.logic.UserSession;
import com.example.logic.UtilLogicFun;
import com.example.logic.principalclasscomponent.Person;
import com.example.logic.principalclasscomponent.Visit;

import javafx.scene.control.Label;




public class insertobjectindb {

    public static boolean InsertNewUser(Label label){

        
        String sqluser = "INSERT INTO User (Email, Password, UserName, FirstName, LastName, id_ridingschool) VALUES (?,?,?,?,?,?)";
        PreparedStatement prepuser = null;
        Connection conn = null;
        boolean ris=false;
        if (!getobjectdb.ControlEmail(UserSession.GetInstance().getEmail(), label) || !getobjectdb.Controlidridingschool(UserSession.GetInstance().getId_ridingschool(), label)) {
            return false;
        }

        try {
            conn = ControlDB.connection();
            prepuser = conn.prepareStatement(sqluser);
            prepuser.setString(1, UserSession.GetInstance().getEmail());
            prepuser.setString(2, UserSession.GetInstance().getPassword());
            prepuser.setString(3, UserSession.GetInstance().getUserName());
            prepuser.setString(4, UserSession.GetInstance().getFirstName());
            prepuser.setString(5, UserSession.GetInstance().getLastName());
            prepuser.setInt(6, UserSession.GetInstance().getId_ridingschool());
            prepuser.executeUpdate();
            UserSession.GetInstance().setId(UtilLogicFun.getid(prepuser));
            label.setText("credenziali inserite correttamente!");
            ris=true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } finally {
            AutoCloseable[] clos = { conn, prepuser};
            for (AutoCloseable i : clos) {
                UtilLogicFun.resclose(i);
            }
        }
        return ris;
    }

    public static boolean InsertQuestionPassword(String question, String answer){
        String sqlquestion="INSERT INTO QuestionPassword (Question, Answer, ID_User) VALUES (?, ?, ?)";
        PreparedStatement prep=null;
        Connection conn=null;
        Boolean ris=false;
        try {
            conn = ControlDB.connection();
            prep = conn.prepareStatement(sqlquestion);
            prep.setString(1, question);
            prep.setString(2, answer);
            prep.setInt(3, UserSession.GetInstance().getId());
            prep.executeUpdate();
            ris=true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            AutoCloseable[] clos = { conn, prep};
            for (AutoCloseable i : clos) {
                UtilLogicFun.resclose(i);
            }
        }
        return ris;

    }

    public static boolean InsertNewAthlete(Athlete athlete) throws SQLException {

        String sqlAthlete = "INSERT INTO athlete (FirstName, LastName, Email, DateofBirth, IDimage, PhoneNumber, id_ridingschool) VALUES (?,?,?,?,?,?,?)";
        String sqlLessons = "INSERT INTO LessonsCount (PendingLessons ,ToDoLessons, id_athlete) VALUES (?,?,?)";
        String sqlLessonsHistory = "INSERT INTO LessonsHistory (Date, Trainer, id_lessonsCount) VALUES (?,?,?)";
        String sqlSubscription = " INSERT INTO Subscription (PlanPrice, PlanType, id_athlete) VALUES (?,?,?)";
        String sqlSubscriptionHistory = "INSERT INTO SubscriptionHistory (Date, Price, id_subscription) VALUES (?,?,?)";
        String sqlMedicalCertificate = "INSERT INTO MedicalCertificate (ExpireDate, MedicalScan, id_athlete) VALUES (?, ?, ?)";
        PreparedStatement prepPerson1 = null;
        PreparedStatement prepPerson2 = null;
        PreparedStatement prepAthlete = null;
        PreparedStatement PrepLessons = null;
        PreparedStatement PrepLessonsHistory = null;
        PreparedStatement prepSubscription = null;
        PreparedStatement prepSubscriptionHistory = null;
        PreparedStatement prepMedicalCertificate = null;

        Connection conn = null;

        int athleteid;
        int lessonscountid;
        int subscriptionid;
        boolean ris=false;

        try {
            conn = ControlDB.connection();
            conn.setAutoCommit(false);
            System.out.println("connessione effettuata!");

            //query athlete
            prepAthlete = conn.prepareStatement(sqlAthlete, Statement.RETURN_GENERATED_KEYS);

            prepAthlete.setString(1, athlete.getFirstName());
            prepAthlete.setString(2, athlete.getLastName());
            prepAthlete.setString(3, athlete.getEmail());
            prepAthlete.setString(4, athlete.getDateofBirth().toString());
            if (athlete.getIdimage() != null) {
                //prepAthlete.setBlob(5, UtilLogicFun.convertToByteArray(athlete.getIdimage()));
                //prepAthlete.setBinaryStream(5,  UtilLogicFun.convertToByteArray(athlete.getIdimage()));
                prepAthlete.setBytes(5, UtilLogicFun.convertToByteArray(athlete.getIdimage()));
            } else {
                prepAthlete.setNull(5, java.sql.Types.BLOB);
            }

            prepAthlete.setString(6, athlete.getPhoneNumber());
            prepAthlete.setInt(7, UserSession.GetInstance().getId_ridingschool());
            prepAthlete.executeUpdate();
            //get id_athlete
            athleteid=UtilLogicFun.getid(prepAthlete);

            if (athlete.getParent1() != null) {
                InsertNewPerson(athlete.getParent1(), athleteid);
            }

            if (athlete.getParent2() != null) {
                InsertNewPerson(athlete.getParent1(), athleteid);
            }

            //insert lessonscount
            PrepLessons = conn.prepareStatement(sqlLessons, Statement.RETURN_GENERATED_KEYS);

            PrepLessons.setInt(1, athlete.getLessons().getPendingLessons());
            PrepLessons.setInt(2, athlete.getLessons().getMissedLessons());
            PrepLessons.setInt(3, athleteid);
            PrepLessons.executeUpdate();
            //get id lessonscount
            lessonscountid=UtilLogicFun.getid(PrepLessons);

            PrepLessonsHistory = conn.prepareStatement(sqlLessonsHistory, Statement.RETURN_GENERATED_KEYS);
            for (LocalDate key : athlete.getLessons().getLessonHistory().keySet()) {

                PrepLessonsHistory.setString(1, key.toString());
                PrepLessonsHistory.setString(2, athlete.getLessons().getLessonHistory().get(key));
                PrepLessonsHistory.setInt(3, lessonscountid);
                PrepLessonsHistory.executeUpdate();
            }

            //insert subscription
            prepSubscription = conn.prepareStatement(sqlSubscription, Statement.RETURN_GENERATED_KEYS);

            prepSubscription.setDouble(1, athlete.getSubscription().getPlanPrice());
            prepSubscription.setString(2, athlete.getSubscription().getPlanType());
            prepSubscription.setInt(3, athleteid);
            prepSubscription.executeUpdate();
            //get id_subscriptio
            subscriptionid=UtilLogicFun.getid(prepSubscription);
            //insert subscriptionHistory
            prepSubscriptionHistory = conn.prepareStatement(sqlSubscriptionHistory, Statement.RETURN_GENERATED_KEYS);
            for (LocalDate key : athlete.getSubscription().getPaymentDate().keySet()) {

                prepSubscriptionHistory.setString(1, key.toString());
                prepSubscriptionHistory.setDouble(2, athlete.getSubscription().getPaymentDate().get(key));
                prepSubscriptionHistory.setInt(3, subscriptionid);
                prepSubscriptionHistory.executeUpdate();
            }

            //insert medical certificate
            prepMedicalCertificate = conn.prepareStatement(sqlMedicalCertificate, Statement.RETURN_GENERATED_KEYS);

            prepMedicalCertificate.setString(1, athlete.getMedicalcertificate().getExpiryDate().toString());
            if (athlete.getMedicalcertificate().getCertificateImage() != null) {
                prepMedicalCertificate.setBytes(2, UtilLogicFun.convertToByteArray(athlete.getMedicalcertificate().getCertificateImage()));
            } else {
                prepMedicalCertificate.setNull(2, java.sql.Types.BLOB);
            }
            prepMedicalCertificate.setInt(3, athleteid);
            prepMedicalCertificate.executeUpdate();
            //terminate le query da fare
            conn.commit();
            conn.close();
            ris=true;
            
        } catch (SQLException | IOException e) {
            if (conn != null) {
                conn.rollback();
                conn.close();
            }
            System.err.println(e.getMessage());
        } finally {
            PreparedStatement[] clos = {prepPerson1, prepPerson2, prepAthlete, PrepLessons, PrepLessonsHistory, prepSubscription, prepSubscriptionHistory, prepMedicalCertificate};
            for (PreparedStatement i : clos) {
                UtilLogicFun.resclose(i);
            }
        }
        return ris;
    }

    public static boolean InsertNewDoctor(Doctor doctor) throws SQLException {

        String sqldoctor = "INSERT INTO Doctor (FirstName, LastName, Email, PhoneNumber, id_ridingschool) VALUES (?,?,?,?,?)";
        PreparedStatement prepDoctor = null;
        Connection conn = null;
        boolean ris=false;

        try {
            conn = ControlDB.connection();
            //insert doctor
            prepDoctor = conn.prepareStatement(sqldoctor);
            prepDoctor.setString(1, doctor.getFirstName());
            prepDoctor.setString(2, doctor.getLastName());
            prepDoctor.setString(3, doctor.getEmail());
            prepDoctor.setString(4, doctor.getPhoneNumber());
            prepDoctor.setInt(5, UserSession.GetInstance().getId_ridingschool());
            prepDoctor.executeUpdate();
            conn.close();
            ris=true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } finally {
            if (conn!=null) {
                conn.close();
            }
            if (prepDoctor!=null) {
                prepDoctor.close();
            }
        }
        return ris;

    }

    public static boolean InsertNewHorse(Horse horse) throws SQLException{
        String sqlhorse="INSERT INTO Horse (DateofBirth, Gender, CoatColor, Name, Breed, Height, Description, ImageHorse, id_Owner, id_ridingschool) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prephorse=null;
        Connection conn=null;
        boolean ris=false;

        try {
            conn=ControlDB.connection();
            prephorse=conn.prepareStatement(sqlhorse);

            prephorse.setString(1, horse.getDateofBirth().toString());
            prephorse.setString(2, horse.getGender());
            prephorse.setString(3, horse.getCoatColor());
            prephorse.setString(4, horse.getName());
            prephorse.setString(5, horse.getBreed());
            prephorse.setDouble(6, horse.getHeight());
            prephorse.setString(7, horse.getDescription());
            prephorse.setBytes(8, UtilLogicFun.convertToByteArray(horse.getImageHorse()));
            prephorse.setInt(9, horse.getOwner().getId_person());
            prephorse.setInt(10, UserSession.GetInstance().getId_ridingschool());
            prephorse.executeLargeUpdate();
            ris=true;            
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (conn!=null) conn.close();
            if(prephorse!=null)prephorse.cancel();
        }
        return ris;
    }

    public static boolean InsertNewvisit(Visit visit, int doctorid, String doctorname) throws SQLException{
        String sqlVisit = "INSERT INTO Visit (Price, GeneralInfo, Date, id_doctor) VALUES (?,?,?,?)";
        String sqlhorsevisitdetails="INSERT INTO HorseVisitDetails (DataVisit, InfoVisit, DataMemo, InfoMemo, id_visit, id_horse, DoctorName) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement prepVisit = null;
        PreparedStatement prephorsevisit=null;
        Connection conn=null;
        boolean ris=false;
        
        try {
            conn=ControlDB.connection();
            conn.setAutoCommit(false);
            prepVisit = conn.prepareStatement(sqlVisit);
            prepVisit.setDouble(1, visit.getPrice());
            prepVisit.setString(2, visit.getGeneralInfo());
            prepVisit.setString(3, visit.getDate().toString());
            prepVisit.setInt(4, doctorid);
            prepVisit.executeUpdate();

            prephorsevisit=conn.prepareStatement(sqlhorsevisitdetails);
            for (String key : visit.getHorseVisit().keySet()) {
                prephorsevisit.setString(1, visit.getDate().toString());
                prephorsevisit.setString(2, visit.getHorseVisit().get(key).getInfo());
                prephorsevisit.setString(3, visit.getHorseVisit().get(key).getDataMemo().toString());
                prephorsevisit.setString(4, visit.getHorseVisit().get(key).getInfoMemo());
                prephorsevisit.setInt(5,UtilLogicFun.getid(prepVisit));
                prephorsevisit.setInt(6,getobjectdb.getobbytabByobb("ID_Horse","Horse","Name",key)); 
                prephorsevisit.setString(7, doctorname);                
            }
            conn.commit();
            ris=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn!=null) conn.close();
            if(prephorsevisit!=null) prephorsevisit.close();
            if (prepVisit!=null) prepVisit.close();
        }
        return ris;
    }

    public static boolean InsertNewPerson(Person person,Integer athleteid) throws SQLException{
        String sqlPerson = "INSERT INTO Person (id_athlete, Firstname, Lastname, Email, PhoneNumber) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prepPerson1 = null;
        Connection conn=null;
        Boolean ris=false;

        try {
            conn=ControlDB.connection();
            prepPerson1 = conn.prepareStatement(sqlPerson, Statement.RETURN_GENERATED_KEYS);

            prepPerson1.setInt(1, athleteid);
            prepPerson1.setString(2, person.getFirstName());
            prepPerson1.setString(3, person.getLastName());
            prepPerson1.setString(4, person.getEmail());
            prepPerson1.setString(5, person.getPhoneNumber());
            prepPerson1.executeUpdate();
            ris=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn!=null) conn.close();
            if(prepPerson1!=null) prepPerson1.close();
        }
        return ris;
        

    }
    


}
