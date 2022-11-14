package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class serves as the records of positive cases
 */
public class Case {
    
    private int caseNum;
    private String citizenUsername;
    private LocalDate reportDate;
    private String tracerUsername;
    private char status;

    private static int count;

    /**
     * Initializes case
     * @param u citizen's username
     * @param d date reported
     */
    public Case(String u, LocalDate d) {
        citizenUsername = u;
        reportDate = d;
        status = 'P';
        tracerUsername = "000";
        caseNum = ++count;
    }

    /**
     * Initializes case
     * @param c case number
     * @param u citizen's username
     * @param d date reported
     * @param tU tracer assigned
     * @param s status
     */
    private Case(int c, String u, LocalDate d, String tU, char s) {
        citizenUsername = u;
        reportDate = d;
        status = s;
        tracerUsername = tU;
        caseNum = c;
        count++;
    }

    /**
     * Get case number
     * @return case number
     */
    public int getCaseNum() {
        return caseNum;
    }

    /**
     * Get citizen's username
     * @return citizen's username
     */
    public String getCitizen() {
        return citizenUsername;
    }

    /**
     * Get report date of case
     * @return report date of case
     */
    public LocalDate getDate() {
        return reportDate;
    }

    /**
     * Get tracer tracking case
     * @return tracer's username
     */
    public String getTracer() {
        return tracerUsername;
    }

    /**
     * Get current status of case
     * @return current status of case
     */
    public char getStatus() {
        return status;
    }

    /**
     * Assigns tracer to case
     * @param username username of tracer
     */
    public void setTracer(String username) {
        tracerUsername = username;
    }

    /**
     * Set status for case
     * @param status status
     */
    public void setStatus(char status) {
        this.status = status;
    }

    /**
     * Class in string format
     * @return string format of class
     */
    public String toString() {
        return caseNum + " " + citizenUsername + " " + getFormattedDate() + " " + tracerUsername + " " + status;
    }

    /**
     * Get data from string of case information and store in attributes
     * @param caseInfo string of case information
     * @return case object
     */
    public static Case parse(String caseInfo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM,dd,yyyy");
        String[] strings = caseInfo.split(" ");

        int caseNum = Integer.parseInt(strings[0]);
        String citizenUsername = strings[1];
        LocalDate reportDate = LocalDate.parse(strings[2], formatter);
        String tracerUsername = strings[3];
        char status = strings[4].toCharArray()[0];

        return new Case(caseNum, citizenUsername, reportDate, tracerUsername, status);
    }

    /**
     * Get date in MM,dd,yyyy formatting
     * @return formatted date in string
     */
    private String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM,dd,yyyy");
        return formatter.format(reportDate);
    }
}