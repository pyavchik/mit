package utils;

import java.time.LocalDate;
import java.util.Locale;

public class DateUtils {
    private static LocalDate localDate = LocalDate.now();

    private final static String CURRENT_WEEK = localDate.getDayOfWeek().toString().toUpperCase(Locale.ROOT);
    private final static String CURRENT_MONTH = localDate.getMonth().toString().toUpperCase(Locale.ROOT);
    private final static String CURRENT_DAY = String.valueOf(localDate.getDayOfMonth()).toUpperCase(Locale.ROOT);
    private final static String CURRENT_YEAR = String.valueOf(localDate.getYear()).toUpperCase(Locale.ROOT);

    private final static String TODAY = CURRENT_WEEK + ", " + CURRENT_MONTH + " " + CURRENT_DAY + ", " + CURRENT_YEAR;

    public static String getCurrentDate() {
        return TODAY;
    }

    public static LocalDate getLocalDate() {
        return localDate;
    }
}
