package models;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 * This class serves as the Citizen user.
 */
public class Citizen {

    private final String USERNAME;
    private String password;
    private ContactInfo info;
    private ArrayList<VisitRecord> records;
    private String exposedMsg;

    /**
     * Initializes user
     * @param u username
     * @param p password
     * @param c contact information
     */
    public Citizen(String u, String p, ContactInfo c) {
        USERNAME = u;
        password = p;
        info = c;
        records = new ArrayList<>();
        exposedMsg = "CAUTION!!! YOU MAY BE EXPOSED TO THE VIRUS.";
    } 

    /**
     * Initializes the user and sets a default contact information.
     * @param u username
     * @param p password
     */
    public Citizen(String u, String p) {
        this(u, p, new ContactInfo());
    }

    /**
     * Gets the user's username.
     * @return the user's username
     */
    public String getUsername() {
        return USERNAME;
    }

    /**
     * Gets the user's password.
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Gets the user's contact info.
     * @return the user's contact info
     */
    public ContactInfo getInfo() {
        return info;
    }

    /**
     * Get role of user.
     * @return the user's role
     */
    public String getRole() {
        return "citizen";
    }

    /**
     * Get visit record of the user
     * @return visit records
     */
    public ArrayList<VisitRecord> getRecords() {
        return records;
    }

    /**
     * Get warning message at log in
     * @return warning message
     */
    public String getMessage() {
        return exposedMsg;
    }

    /**
     * Sets the user's password
     * @param p password
     */
    public void setPassword(String p) {
    	password = p;
    }

    /**
     * Sets the user's contact information
     * @param info contact information
     */
    public void setInfo(ContactInfo info) {
        this.info = info;
    }

    /**
     * Sets the user's warning message on startup
     * @param m message
     */
    public void setMessage(String m) {
        exposedMsg = m;
    }

    /**
     * Records the user's information of visit of establishment.
     * @param code establishment code
     * @param date date of check in
     */
    public void checkIn(String code, LocalDate date) {
        records.add(new VisitRecord(code, LocalDateTime.of(date, LocalTime.now())));
    }

    /**
     * Reports a positive case
     * @param reportDate date of report
     */
    public void reportPositive(LocalDate reportDate) {
        Official.getCases().add(new Case(USERNAME, reportDate));
    }
}
