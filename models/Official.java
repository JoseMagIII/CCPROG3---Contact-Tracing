package models;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Government official class inherits all methods and attributes from Citizen class
 */
public class Official extends Citizen {

    private static ArrayList<Case> cases;

    /**
     * Intializes user and sets default contact information
     * @param u username
     * @param p password
     */
    public Official(String u, String p) {
        super(u, p);
    }

    /**
     * Initializes user
     * @param u username
     * @param p password
     * @param c contact information
     */
    public Official(String u, String p, ContactInfo c) {
        super(u, p, c);
    }

    /**
     * Get current user's role
     * @return the user's role
     */
    @Override
    public String getRole() {
        return "official";
    }

    /**
     * Get list of positive cases
     * @return list of positive cases
     */
    public static ArrayList<Case> getCases() {
        return cases;
    }

    /**
     * Set list of positive cases
     * @param list list of cases
     */
    public static void setCases(ArrayList<Case> list) {
        cases = list;
    }

    /**
     * Assigns tracer to case
     * @param username username of tracer
     * @param caseNum case number
     */
    public void assignTracerToCase(HashMap<String, Citizen> users, String username, int caseNum) {
        for (Case i : cases) {
        	if (i.getCaseNum() == caseNum) {
                i.setTracer(username);
                ((Tracer) users.get(username)).getAssignedCases().add(i);
            }
        }
    }

    /**
     * Get list of positive cases with given information
     * @param users list of users
     * @param city city to check
     * @param start start date
     * @param end end date
     * @return list of positive cases
     */
    public ArrayList<Case> getPositiveCasesList(HashMap<String, Citizen> users, String city,
                                                LocalDate start, LocalDate end) {
        ArrayList<Case> posCases = new ArrayList<>();

        for (Case i : cases) {
            if (isDateInRange(start, end, i.getDate())) {
                if (isInCity(city, users.get(i.getCitizen()).getInfo().getHomeAddress().getCity())) {
                    posCases.add(i);
                }
            }
        }

        return posCases;
    }

    /**
     * Get list of positive cases with given information
     * @param start start date
     * @param end end date
     * @return list of positive cases
     */
    public ArrayList<Case> getPositiveCasesList(LocalDate start, LocalDate end) {
        ArrayList<Case> posCases = new ArrayList<>();

        for (Case i : cases) {
            if (isDateInRange(start, end, i.getDate())) {
                posCases.add(i);
            }
        }

        return posCases;
    }

    /**
     * Get list of positive cases with given information
     * @param users list of users
     * @param city city to check
     * @return list of positive cases
     */
    public ArrayList<Case> getPositiveCasesList(HashMap<String, Citizen> users, String city) {
        ArrayList<Case> posCases = new ArrayList<>();

        for (Case i : cases) {
            if (isInCity(city, users.get(i.getCitizen()).getInfo().getHomeAddress().getCity())) {
                posCases.add(i);
            }
        }

        return posCases;
    }

    /**
     * Creates a new government official
     * @param users the user list
     * @param username user to make official
     */
    public void createOfficial(HashMap<String, Citizen> users, String username) {
        if (username.equals(getUsername())) {
            return;
        }

        if (users.get(username) != null) {
            if (!users.get(username).getRole().equals("official")) {
                users.replace(username, new Official(users.get(username).getUsername(),
                                                     users.get(username).getPassword(),
                                                     users.get(username).getInfo()));
            }
        } else {
            users.put(username, new Official(username, "initial123"));
        }
    }

    /**
     * Creates a new contact tracer
     * @param users the user list
     * @param username user to make tracer
     */
    public void createTracer(HashMap<String, Citizen> users, String username) {
        if (username.equals(getUsername())) {
            return;
        }

        if (users.get(username) != null) {
            if (!users.get(username).getRole().equals("tracer")) {
                users.replace(username, new Tracer(users.get(username).getUsername(),
                                                   users.get(username).getPassword(),
                                                   users.get(username).getInfo()));
            }
        } else {
            users.put(username, new Tracer(username, "initial123"));
        }
    }

    /**
     * Terminates an official or tracer account.
     * @param users the user list
     * @param username user's username
     */
    public void terminateAccount(HashMap<String, Citizen> users, String username) {
        if (username.equals(getUsername()) || users.get(username) == null) {
            return;
        }

        if (!users.get(username).getRole().equals("citizen")) {
            /**
             * If user is a tracer his assigned cases will be set to unassigned
             */
            if (users.get(username).getRole().equals("tracer")) {
                for (Case i : cases) {
                    if (i.getTracer().equals(username)) {
                        i.setTracer("000");
                    }
                }
            }

            users.put(username, new Citizen(users.get(username).getUsername(),
                                            users.get(username).getPassword(),
                                            users.get(username).getInfo()));
        }
    }

    /**
     * Checks if entered date is in range
     * @param start start date
     * @param end end date
     * @param current current date
     * @return true if date is in range, false if otherwise
     */
    private boolean isDateInRange(LocalDate start, LocalDate end, LocalDate current) {
        return !(current.isAfter(end) || current.isBefore(start));
    }

    /**
     * Checks if user is in city
     * @param given given city
     * @param userLoc user's city
     * @return true if user is in city, false if otherwise
     */
    private boolean isInCity(String given, String userLoc) {
        int i;

        // Gets index of the substring city
        i = given.toLowerCase().lastIndexOf("city");

        // Removes substring from string
        if (i != -1) {
            given = given.substring(0, i - 2);
        }

        // Checks if given city is a substring in user location string
        return userLoc.toLowerCase().contains(given.toLowerCase());
    }
}
