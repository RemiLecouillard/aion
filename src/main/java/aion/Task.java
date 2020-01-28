package aion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Task implements Comparable<Task> {

    private Collection<Resource> _resources;

    private LocalDate _date;

    private LocalTime _begin;

    private LocalTime _end;

    private String _name;

    public Task(String name, LocalDate date, LocalTime begin, LocalTime end, Resource ... resources) {
        _date = date;
        _begin = begin;
        _end = end;
        _name = name;
        _resources = new ArrayList<>();
        _resources.addAll(Arrays.asList(resources));
    }

    public String getName() {
        return _name;
    }

    public boolean contains(Resource r) {
        return _resources.contains(r);
    }

    public LocalDate getStartDate() {
        return _date;
    }

    public LocalTime getStartTime() {
        return _begin;
    }

    public LocalTime getEndTime() {
        return _end;
    }

    @Override
    public int compareTo(Task o) {

        int dif = _date.compareTo(o._date);

        if (dif < 0) {
            return -1;
        }

        if (dif > 0) {
            return 1;
        }

        return _begin.compareTo(o._begin);
    }
}
