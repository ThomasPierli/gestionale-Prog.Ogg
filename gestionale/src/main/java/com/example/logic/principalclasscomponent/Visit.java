package com.example.logic.principalclasscomponent;

import java.time.LocalDate;
import java.util.Map;

public class Visit {
    /**
     * innervisit
     */
    public static class HorseVisitDetails {
        private LocalDate Data;
        private String info;
        private String DoctorName;
        private LocalDate DataMemo;
        private String InfoMemo;
        public HorseVisitDetails(LocalDate data, String info, String doctorName, LocalDate dataMemo, String infoMemo) {
            Data = data;
            this.info = info;
            DoctorName = doctorName;
            DataMemo = dataMemo;
            InfoMemo = infoMemo;
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
        public String getDoctorName() {
            return DoctorName;
        }
        public void setDoctorName(String doctorName) {
            DoctorName = doctorName;
        }
        public LocalDate getDataMemo() {
            return DataMemo;
        }
        public void setDataMemo(LocalDate dataMemo) {
            DataMemo = dataMemo;
        }
        public String getInfoMemo() {
            return InfoMemo;
        }
        public void setInfoMemo(String infoMemo) {
            InfoMemo = infoMemo;
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
