package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lessons {
    private int PendingLessons;
    private int MissedLessons;
    private ArrayList<LocalDate> LessonHistory;
    
    public Lessons(int pendingLessons, int missedLessons, ArrayList<LocalDate> lessonHistory) {
        PendingLessons = pendingLessons;
        MissedLessons = missedLessons;
        LessonHistory = lessonHistory;
    }

    public int getPendingLessons() {
        return PendingLessons;
    }

    public void setPendingLessons(int pendingLessons) {
        PendingLessons = pendingLessons;
    }

    public int getMissedLessons() {
        return MissedLessons;
    }

    public void setMissedLessons(int missedLessons) {
        MissedLessons = missedLessons;
    }

    public ArrayList<LocalDate> getLessonHistory() {
        return LessonHistory;
    }

    public void setLessonHistory(ArrayList<LocalDate> lessonHistory) {
        LessonHistory = lessonHistory;
    }

    //nella utils scrivere le funzioni per la gestione degli arraylist(DI TIPI GENERALI <T>)
    
    
}
