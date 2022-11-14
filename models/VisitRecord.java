package models;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class stores the information of the user report
 */
public class VisitRecord {
    
    private String code;
    private LocalDateTime datetime;

    /**
     * Initializes the attributes with the given parameter
     * @param code the establishment code
     * @param datetime the date and time of visit
     */
    public VisitRecord(String code, LocalDateTime datetime) {
        this.code = code;
        this.datetime = datetime;
    }

    /**
     * Get establishment code
     * @return the establishment code
     */
    public String getCode() {
        return code;
    }

    /**
     * Get date and time of visit
     * @return date and time of visit
     */
    public LocalDateTime getDateTime() {
        return datetime;
    }

    /**
     * Get record information in string
     * @return record in string format
     */
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM,dd,yyyy HHmm");

        String datetimeFormatted = datetime.format(dateTimeFormatter);

        return code + " " + datetimeFormatted;
    }

    /**
     * Parse a string in to a record object
     * @param record record in string format
     * @return record object
     */
    public static VisitRecord parse(String record) {
        String[] strings = record.split(" ");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM,dd,yyyy HHmm");

        String code = strings[0];

        String dateTimeStr = strings[1] + " " + strings[2];
        LocalDateTime datetime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter);

        return new VisitRecord(code, datetime);
    }
}