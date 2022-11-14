package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contact Tracer class inherits all methods and attributes from Citizen class
 */
public class Tracer extends Citizen {

    private ArrayList<Case> assignedCases;
    private ArrayList<Notice> informList;

    /**
     * Initializes user with default contact information
     * @param u username
     * @param p password
     */
    public Tracer(String u, String p) {
        super(u, p);
        assignedCases = new ArrayList<>();
        informList = new ArrayList<>();
    }

    /**
     * Initializes user
     * @param u username
     * @param p password
     * @param c contact information
     */
    public Tracer(String u, String p, ContactInfo c) {
        super(u, p, c);
        assignedCases = new ArrayList<>();
        informList = new ArrayList<>();
    }

    /**
     * Get current user's role
     * @return the user's role
     */
    @Override
    public String getRole() {
        return "tracer";
    }

    /**
     * Get cases assigned to the tracer
     * @return list of cases
     */
    public ArrayList<Case> getAssignedCases() {
        return assignedCases;
    }

    /**
     * Get list of citizens the tracer has to inform
     * @return list of users to inform
     */
    public ArrayList<Notice> getInformList() {
        return informList;
    }

    /**
     * Traces cases and generates list of users to be informed
     * @param users list of users
     * @param caseNum case to be traced
     */
    public void traceCase(HashMap<String, Citizen> users, int caseNum) {
        String infectedUsername = Official.getCases().get(caseNum - 1).getCitizen();
        LocalDate infectedDate = Official.getCases().get(caseNum - 1).getDate();

        users.forEach((username, user) -> {
            if (!username.equals(infectedUsername) && !user.getRecords().isEmpty()) {
                VisitRecord exposedRecord = getExposedRecord(users.get(infectedUsername).getRecords(), user.getRecords(), infectedDate, 8);

                if (exposedRecord != null) {
                    informList.add(new Notice(username, exposedRecord.getCode(), exposedRecord.getDateTime().toLocalDate()));
                    if (Official.getCases().get(caseNum - 1).getStatus() == 'P') {
                        Official.getCases().get(caseNum - 1).setStatus('T');
                    }
                }
            }
        });
    }

    /**
     * Informs the users that has came in contact with a positive user
     * @param users list of users
     * @return true if successfully informed citizens, false if otherwise
     */
    public boolean informExposed(HashMap<String, Citizen> users) {
        if (!informList.isEmpty()) {
            for (Notice i : informList) {
                users.get(i.getUsername()).setMessage(i.getMessage());
            }

            // Resets list after informing citizens
            informList = new ArrayList<>();

            return true;
        }

        return false;
    }

    /**
     * Get the record of the citizen where he was possibly exposed
     * @param infectedR records of the infected citizen
     * @param citizenR records of the citizen
     * @param caseDate date of the case
     * @param range number of days to check
     * @return exposed record, null if there is no exposed record
     */
    private VisitRecord getExposedRecord(ArrayList<VisitRecord> infectedR, ArrayList<VisitRecord> citizenR, LocalDate caseDate, int range) {
        LocalDateTime iNextDate;

        for (int i = infectedR.size() - 1; i >= 0; i--) {
            /*
               Stores next record date
               If there is no next record it sets the next date to the current date with the time set to 2359
             */
            iNextDate = i != infectedR.size() - 1 ? infectedR.get(i + 1).getDateTime() : infectedR.get(i).getDateTime().with(LocalTime.of(23, 59));
            /*
               Executes block if the date of record from the infected
               is equal to or after the case date minus the range of days
             */
            if (infectedR.get(i).getDateTime().toLocalDate().compareTo(caseDate.minusDays(range)) >= 0) {
                for (int j = citizenR.size() - 1; j >= 0; j--) {
                    /*
                       Executes block if the date of record from the citizen
                       is equal to or after the case date minus the range of days
                     */
                    if (citizenR.get(j).getDateTime().toLocalDate().compareTo(caseDate.minusDays(range)) >= 0) {
                        if (citizenR.get(j).getCode().equals(infectedR.get(i).getCode())) {
                            /*
                               Same establishment
                               Checks if is on same date and same time
                             */
                            if (citizenR.get(j).getDateTime().equals(infectedR.get(i).getDateTime())) {
                                return citizenR.get(j);
                            } else if (citizenR.get(j).getDateTime().toLocalDate().equals(infectedR.get(i).getDateTime().toLocalDate())) {
                                /*
                                   Check if citizen's record is after the infected's record
                                 */
                                if (citizenR.get(j).getDateTime().isAfter(infectedR.get(i).getDateTime())) {
                                    /*
                                       Check if citizen's record is before the infected's next record
                                     */
                                    if (citizenR.get(j).getDateTime().isBefore(iNextDate)) {
                                        return citizenR.get(j);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
}
