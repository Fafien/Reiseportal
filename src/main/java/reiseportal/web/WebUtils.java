
package reiseportal.web;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Statische Hilfsmethoden
 */
public class WebUtils {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    // Formatiert ein Datum für die Ausgabe, z.B. 31.12.9999
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    //Formatiert eine Uhrzeit für die Ausgabe, z.B. 12:00:00
    public static String formatTime(Time time) {
        return TIME_FORMAT.format(time);
    }

    //Erzeugt ein Datumsobjekt aus dem übergebenen String, z.B. 03.06.2018
    public static Date parseDate(String input) {
        try {
            java.util.Date date = DATE_FORMAT.parse(input);
            return new Date(date.getTime());
        } catch (ParseException ex) {
            return null;
        }
    }

    //Erzeugt ein Uhrzeitobjekt aus dem übergebenen String, z.B. 12:00:00
    public static Time parseTime(String input) {
        try {
            java.util.Date date = TIME_FORMAT.parse(input);
            return new Time(date.getTime());
        } catch (ParseException ex) {
            return null;
        }
    }
}
