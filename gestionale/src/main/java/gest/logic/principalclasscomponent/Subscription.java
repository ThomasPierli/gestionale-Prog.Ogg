package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.util.Map;


public class Subscription {

    private String PlanType;
    private int PlanPrice;
    private Map<LocalDate,Integer> PaymentDate;

    public Subscription(String planType, int planPrice, Map<LocalDate, Integer> paymentDate) {
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

    public int getPlanPrice() {
        return PlanPrice;
    }

    public void setPlanPrice(int planPrice) {
        PlanPrice = planPrice;
    }

    public Map<LocalDate, Integer> getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Map<LocalDate, Integer> paymentDate) {
        PaymentDate = paymentDate;
    }

    //servono le funzioni per la creazione e la gestione della mappa 

    


    
    
}
