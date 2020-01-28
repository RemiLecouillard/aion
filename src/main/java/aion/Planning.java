package aion;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Interval;

import java.util.Collection;

public class Planning {

    private Collection<Task> tasks;

    private String name;

    Planning(String name) {
        this.name = name;

    }

    void addClass(Task entry) {
        tasks.add(entry);
    }

    Planning getPlanningForResource(Resource r) {
        Planning p = new Planning(r.getName());
        for (Task c : tasks) {
            if (c.contains(r)) {
                p.addClass(c);
            }
        }

        return p;
    }

    Calendar getCalendar() {
        Calendar calendar = new Calendar(this.name);
        for (Task c : tasks) {
            Entry<?> e = new Entry(c.getName());
            e.setInterval(new Interval(c.getStartDate(), c.getStartTime(), c.getEndDate(), c.getEndTime()));
            calendar.addEntry(e);
        }

        return calendar;
    }

    Collection<Task> getTasks() {
        return tasks;
    }

}
