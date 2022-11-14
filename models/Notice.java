package models;

import java.time.LocalDate;

/**
 * This class is serves as information for the notice to be sent
 */
public class Notice {

    private String username;
    private String establishment;
    private String message;
    private LocalDate dateExposed;

    /**
     * Initializes class
     * @param username username of user exposed
     * @param establishment establishment where user was exposed
     * @param dateExposed date of when user was exposed
     */
    public Notice(String username, String establishment, LocalDate dateExposed) {
        this.username = username;
        this.establishment = establishment;
        this.dateExposed = dateExposed;

        message = generateMessage();
    }

    /**
     * Get username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get establishment
     * @return establishment
     */
    public String getEstablishment() {
        return establishment;
    }

    /**
     * Get date exposed
     * @return date exposed
     */
    public LocalDate getDateExposed() {
        return dateExposed;
    }

    /**
     * Get warning message
     * @return warning message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Generate warning message
     * @return warning message
     */
    private String generateMessage() {
        return "You may have come in contact with a positive patient on " +
                dateExposed + " in " + establishment +
                ". Please get tested and report in this app if you have tested positive.";
    }
}
