package gest.logic.principalclasscomponent;

import java.time.LocalDate;

public class Order {
    private LocalDate Date;
    private Double Price;
    private String Info;

    public Order(LocalDate date, Double price, String info) {
        Date = date;
        Price = price;
        Info = info;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    //nella utils implementare i controlli della data e del prezzo(?non sono sicuro...ma direi che il tipo in se controlla la corretta inizializzazione);
    
    
}
