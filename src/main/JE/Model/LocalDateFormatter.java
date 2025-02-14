package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateFormatter {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public LocalDateFormatter() {

    }

    public LocalDateFormatter(String dateFormat, String dateTimeFormat) {
        dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
    }

    public static String convertToString(LocalDate date) {
        if(date == null) {
            return "";
        }else{
            return date.format(dateFormatter);
        }
    }

    public static String convertToString(LocalDateTime dateTime) {
        if(dateTime == null) {
            return "";
        }else{
            return dateTime.format(dateTimeFormatter);
        }
    }

    public static LocalDate convertStringToDate(String date) throws DateTimeParseException {
        if (date.isBlank()) {
            return null;
        }else{
            return LocalDate.parse(date, dateFormatter);
        }
    }

    public static LocalDateTime convertStringToDateTime(String dateTime) throws DateTimeParseException {
        if (dateTime.isBlank()) {
            return null;
        }else{
            return LocalDateTime.parse(dateTime, dateTimeFormatter);
        }
    }
}
