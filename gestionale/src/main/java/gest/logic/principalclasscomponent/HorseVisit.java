package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.util.Map;

public class HorseVisit{
    private LocalDate Date;
    private String Info;
    private Map<LocalDate,String> Memo;
    
    
    
    public HorseVisit(LocalDate date, String info, Map<LocalDate, String> memo) {
        Date = date;
        Info = info;
        Memo = memo;
    }
    public LocalDate getDate() {
        return Date;
    }
    public void setDate(LocalDate date) {
        Date = date;
    }
    public String getInfo() {
        return Info;
    }
    public void setInfo(String info) {
        Info = info;
    }
    public Map<LocalDate, String> getMemo() {
        return Memo;
    }
    public void setMemo(Map<LocalDate, String> memo) {
        Memo = memo;
    }

    
}

