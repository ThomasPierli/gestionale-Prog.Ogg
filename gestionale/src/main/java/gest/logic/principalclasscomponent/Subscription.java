package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.util.Map;


public class Subscription {

    private String PlanType;
    private Double PlanPrice;
    private Map<LocalDate,Double> PaymentDate;
    //ho cambiato nella mappa da boolean a double perche altrimenti se ci fossero dei cambiamenti
    //di abbonamento nel tempo non si saprebbe quanto ha pagato ecc
    //magari al posto del bolean di conferma consideriamo gia l'inserimento come conferma.
    //(double perche magari non sono cifre intere ma con la virgola)

    public Subscription(String planType, Double planPrice, Map<LocalDate, Double> paymentDate) {
        PlanType = planType;
        PlanPrice = planPrice;
        PaymentDate = paymentDate;
    }

    public String getPlanType() {
        return PlanType;
    }

    public void setPlanType(String planType) {
        PlanType = planType;
    }

    public Double getPlanPrice() {
        return PlanPrice;
    }

    public void setPlanPrice(Double planPrice) {
        PlanPrice =  planPrice;
    }

    public Map<LocalDate, Double> getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Map<LocalDate, Double> paymentDate) {
        PaymentDate = paymentDate;
    }

    //servono le funzioni per la creazione e la gestione della mappa 

    


    
    
}
