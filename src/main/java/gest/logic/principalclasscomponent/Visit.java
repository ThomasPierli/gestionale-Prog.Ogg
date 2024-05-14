package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.util.Map;

public class Visit {
    /**
     * innervisit
     */
    public class HorseVisitDetails {
        private LocalDate Data;
        private String info;
        private Map<LocalDate,String> memo;//data in cui ricordare, informazioni su cosa ricordare;
        public HorseVisitDetails(LocalDate data, String info, Map<LocalDate, String> memo) {
            Data = data;
            this.info = info;
            this.memo = memo;
        }
        public LocalDate getData() {
            return Data;
        }
        public void setData(LocalDate data) {
            Data = data;
        }
        public String getInfo() {
            return info;
        }
        public void setInfo(String info) {
            this.info = info;
        }
        public Map<LocalDate, String> getMemo() {
            return memo;
        }
        public void setMemo(Map<LocalDate, String> memo) {
            this.memo = memo;
        }
    }

        private double price;
        private String GeneralInfo;
        private LocalDate date;
        private Map<String,HorseVisitDetails> HorseVisit;//nome cavallo, 
        
        public Visit(double price, String generalInfo, Map<String, HorseVisitDetails> horseVisit,LocalDate date) {
            this.price = price;
            GeneralInfo = generalInfo;
            HorseVisit = horseVisit;
            this.date=date;
        }

        
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getGeneralInfo() {
            return GeneralInfo;
        }

        public void setGeneralInfo(String generalInfo) {
            GeneralInfo = generalInfo;
        }

        public Map<String, HorseVisitDetails> getHorseVisit() {
            return HorseVisit;
        }

        public void setHorseVisit(Map<String, HorseVisitDetails> horseVisit) {
            HorseVisit = horseVisit;
        }


        public LocalDate getDate() {
            return date;
        }


        public void setDate(LocalDate date) {
            this.date = date;
        }

}
