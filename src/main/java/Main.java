import java.time.LocalDate;
import java.time.LocalTime;

import com.calendarfx.ical.ICalRepository;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.util.LoggingDomain;
import com.calendarfx.view.CalendarView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.fortuna.ical4j.util.MapTimeZoneCache;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoggingDomain.CONFIG.info("Java version: " + System.getProperty("java.version"));
        System.setProperty("ical4j.unfolding.relaxed", "true");
        System.setProperty("ical4j.parsing.relaxed", "true");
        System.setProperty("net.fortuna.ical4j.timezone.cache.impl", MapTimeZoneCache.class.getName());

        CalendarView calendarView = new CalendarView();

        Calendar info = new Calendar("Info");
        Calendar elec = new Calendar("Elec");
        Calendar chimie = new Calendar("Chimie");

        info.setStyle(Calendar.Style.STYLE1);
        elec.setStyle(Calendar.Style.STYLE2);
        chimie.setStyle(Calendar.Style.STYLE3);


        CalendarSource myCalendarSource = new CalendarSource("Students");
        myCalendarSource.getCalendars().addAll(info, elec, chimie);
        Calendar moi = ICalRepository.createWebCalendar("http://ade.ensicaen.fr:8080/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=2224&projectId=4&calType=ical&nbWeeks=8",
                "ENSI", Calendar.Style.STYLE4, myCalendarSource);

        ICalRepository.createWebCalendar("http://ade.ensicaen.fr:8080/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=2727&projectId=4&calType=ical&nbWeeks=8",
                "Nicolas", Calendar.Style.STYLE5, myCalendarSource);
        calendarView.getCalendarSources().setAll(myCalendarSource);


        calendarView.setRequestedTime(LocalTime.now());

        Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
            @Override
            public void run() {
                while (true) {
                    Platform.runLater(() -> {
                        calendarView.setToday(LocalDate.now());
                        calendarView.setTime(LocalTime.now());
                    });

                    try {
                        // update every 10 seconds
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
        };

        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();

        Scene scene = new Scene(calendarView);

        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1300);
        primaryStage.setHeight(1000);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
