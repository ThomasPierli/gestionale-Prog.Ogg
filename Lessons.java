package gest.logic.principalclasscomponent;

import java.time.LocalDate;
import java.util.Map;

public class Lessons {
    private int PendingLessons;
    private int ToDoLessons;
    private Map<LocalDate, String> LessonHistory;
    
    public Lessons(int pendingLessons, int missedLessons, Map<LocalDate, String> lessonHistory) {
        PendingLessons = pendingLessons;
        ToDoLessons = missedLessons;
        LessonHistory = lessonHistory;
    }

    public int getPendingLessons() {
        return PendingLessons;
    }

    public void setPendingLessons(int pendingLessons) {
        PendingLessons = pendingLessons;
    }

    public int getMissedLessons() {
        return ToDoLessons;
    }

    public void setMissedLessons(int missedLessons) {
        ToDoLessons = missedLessons;
    }

    public Map<LocalDate, String> getLessonHistory() {
        return LessonHistory;
    }

    public void setLessonHistory(Map<LocalDate, String> lessonHistory) {
        LessonHistory = lessonHistory;
    }

    //nella utils scrivere le funzioni per la gestione degli arraylist(DI TIPI GENERALI <T>)
    
    
}