package aion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Task {

    public Task(String name, Date date, LocalTime begin, LocalTime end, Resource ... resources) {

    }

    public String getName() {
        return "";
    }

    public boolean contains(Resource r) {
        return true;
    }

    public LocalDate getStartDate() {
        return null;
    }

    public LocalTime getStartTime() {
        return null;
    }

    public LocalDate getEndDate() {
        return null;
    }

    public LocalTime getEndTime() {
        return null;
    }
}
