package aion;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Interval;

import java.util.Collection;
import java.util.TreeSet;

public class Planning implements PlanningInterface{

    private Collection<Task> tasks;

    private String name;

    Planning(String name) {
        tasks = new TreeSet<>();
        this.name = name;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Planning getPlanningForResource(Resource r) {
        Planning p = new Planning(r.getName());
        for (Task c : tasks) {
            if (c.contains(r)) {
                p.addTask(c);
            }
        }

        return p;
    }

    @Override
    public Calendar getCalendar() {
        Calendar calendar = new Calendar(this.name);
        for (Task c : tasks) {
            Entry<?> e = new Entry(c.getName());
            e.setInterval(new Interval(c.getStartDate(), c.getStartTime(), c.getStartDate(), c.getEndTime()));
            calendar.addEntry(e);
        }

        return calendar;
    }

    @Override
    public Collection<Task> getAllTasks() {
        return tasks;
    }

}
