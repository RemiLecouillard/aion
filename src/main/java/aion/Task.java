package aion;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@PlanningEntity
public class Task {

    public Task(String name, Date date, LocalTime begin, LocalTime end, Resource ... resources) {

    }

    public String getName() {
        return "";
    }

    public boolean contains(Resource r) {
        return true;
    }

    @PlanningVariable
    public Schedule getSchedule() {
        return null;
    }
}
