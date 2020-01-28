package aion;

import com.calendarfx.model.Calendar;

import java.util.Collection;

public interface PlanningInterface {

    void addTask(Task task);

    PlanningInterface getPlanningForResource(Resource r);

    Calendar getCalendar();

    Collection<Task> getAllTasks();

}
