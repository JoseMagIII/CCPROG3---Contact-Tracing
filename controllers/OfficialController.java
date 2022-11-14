package controllers;

import models.*;
import views.*;
import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * This class serves as the controller for the Official View
 */
public class OfficialController extends CitizenController {

    /**
     * Initializes controller
     * @param users list of users
     */
    public OfficialController(HashMap<String, Citizen> users) {
        super(users);
    }

    /**
     * Initializes GUI
     */
    @Override
    public void init() {
        view = new OfficialView();
        addBtnListeners();
        view.init(model.getUsername());

        if (!hasReported()) {
            view.showCaution(model.getMessage());
        }
    }

    /**
     * Add listeners to view buttons
     */
    @Override
    protected void addBtnListeners() {
        super.addBtnListeners();

        ((OfficialView) view).getUnassignedCasesMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(((OfficialView) view).getUnassignedCasesMenuBtn());
            showUnassignedCases();
            view.getLayout().show(view.getDashPanel(), "unassignedCases");
        });

        ((OfficialView) view).getContactTracingUpdatesMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(((OfficialView) view).getContactTracingUpdatesMenuBtn());

            view.getLayout().show(view.getDashPanel(), "contactTracingUpdates");
        });

        ((OfficialView) view).getAnalyticsMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(((OfficialView) view).getAnalyticsMenuBtn());

            view.getLayout().show(view.getDashPanel(), "analytics");
        });

        ((OfficialView) view).getCreateOfficialMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(((OfficialView) view).getCreateOfficialMenuBtn());

            view.getLayout().show(view.getDashPanel(), "createOfficial");
        });

        ((OfficialView) view).getCreateTracerMenuBtn().addActionListener(e -> {
            setActiveMenuBtn((((OfficialView) view).getCreateTracerMenuBtn()));
            view.getLayout().show(view.getDashPanel(), "createTracer");
        });

        ((OfficialView) view).getTerminateAccountMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(((OfficialView) view).getTerminateAccountMenuBtn());
            view.getLayout().show(view.getDashPanel(), "terminate");
        });

        ((OfficialView) view).getAssignTracerBtn().addActionListener(e -> {
            if (!((OfficialView) view).getAssignCaseNoField().getText().equals("") &&
                !((OfficialView) view).getAssignCaseUsernameField().getText().equals("")) {

                String username = ((OfficialView) view).getAssignCaseUsernameField().getText();
                int caseNum = Integer.parseInt(((OfficialView) view).getAssignCaseNoField().getText());

                if (isValidTracer(username) && isValidCase(caseNum)) {
                    ((Official) model).assignTracerToCase(users, username, caseNum);
                    view.popUpSuccess(username + " assigned to Case " + caseNum);
                } else if (!isValidTracer(username) && !isValidCase(caseNum)) {
                    view.popUpError("Invalid Tracer and Case Number!");
                } else if (!isValidCase(caseNum)) {
                    view.popUpError("Invalid Case Number!");
                } else {
                    view.popUpError("Invalid Tracer!");
                }

                ((OfficialView) view).getAssignCaseNoField().setText("");
                ((OfficialView) view).getAssignCaseUsernameField().setText("");
            }
        });

        ((OfficialView) view).getCreateOfficialBtn().addActionListener(e -> {
            String username = ((OfficialView) view).getOfficialUsernameField().getText();

            if (!username.equals(model.getUsername())) {
                if (isUserExisting(username)) {
                    if (checkRole(username, "official")) {
                        view.popUpError(username + " is already a government official.");
                    } else {
                        ((Official) model).createOfficial(users, username);
                        view.popUpSuccess(username + " was promoted to a government official!");
                    }
                } else {
                    ((Official) model).createOfficial(users, username);
                    view.popUpSuccess("Created new user " + username +
                            ". The default password is initial123. This can be changed in the menu");
                    new ContactInfoController(users, username).init(true);
                }
            } else {
                view.popUpError("You cannot enter yourself");
            }

            ((OfficialView) view).getOfficialUsernameField().setText("");
        });

        ((OfficialView) view).getCreateTracerBtn().addActionListener(e -> {
            String username = ((OfficialView) view).getTracerUsernameField().getText();

            if (!username.equals(model.getUsername())) {
                if (isUserExisting(username)) {
                    if (checkRole(username, "tracer")) {
                        view.popUpError(username + " is already a contact tracer.");
                    } else {
                        ((Official) model).createTracer(users, username);
                        view.popUpSuccess(username + " was promoted to a contact tracer!");
                    }
                } else {
                    ((Official) model).createTracer(users, username);
                    view.popUpSuccess("Created new user " + username +
                            ". The default password is initial123. This can be changed in the menu");
                    new ContactInfoController(users, username).init(true);
                }
            } else {
                view.popUpError("You cannot enter yourself.");
            }

            ((OfficialView) view).getTracerUsernameField().setText("");
        });

        ((OfficialView) view).getTerminateBtn().addActionListener(e -> {
            String username = ((OfficialView) view).getTerminateField().getText();

            if (!username.equals(model.getUsername())) {
                if (isUserExisting(username)) {
                    if (checkRole(username, "citizen")) {
                        view.popUpError(username + " is already a citizen");
                    } else {
                        ((Official) model).terminateAccount(users, username);
                        view.popUpSuccess(username + " was terminated to a citizen.");
                    }
                } else {
                    view.popUpError(username + " is not an existing user");
                }
            } else {
                view.popUpError("You cannot enter yourself.");
            }

            ((OfficialView) view).getTerminateField().setText("");
        });

        ((OfficialView) view).getShowPositiveCasesBtn().addActionListener(e -> {
            LocalDate start, end;

            int year, month, day;

            year = Integer.parseInt(((OfficialView) view).getPosCasesStartDate().getYear().getSelectedItem().toString());
            month = Integer.parseInt(((OfficialView) view).getPosCasesStartDate().getMonth().getSelectedItem().toString());
            day = Integer.parseInt(((OfficialView) view).getPosCasesStartDate().getDay().getSelectedItem().toString());

            try {
                start = LocalDate.of(year, month, day);
            } catch (DateTimeException err) {
                view.popUpError("Start: " + err.getMessage());
                return;
            }

            year = Integer.parseInt(((OfficialView) view).getPosCasesEndDate().getYear().getSelectedItem().toString());
            month = Integer.parseInt(((OfficialView) view).getPosCasesEndDate().getMonth().getSelectedItem().toString());
            day = Integer.parseInt(((OfficialView) view).getPosCasesEndDate().getDay().getSelectedItem().toString());

            try {
                end = LocalDate.of(year, month, day);
            } catch (DateTimeException err) {
                view.popUpError("End: " + err.getMessage());
                return;
            }

            if (!showPositiveCases(start, end)) {
                view.popUpError("No cases found.");
            }

            view.validate();
        });

        ((OfficialView) view).getAnalytics1Btn().addActionListener(e -> {
            String city = ((OfficialView) view).getAnalyticsCityField1().getText();

            LocalDate start, end;
            int year, month, day;

            year = Integer.parseInt(((OfficialView) view).getAnalyticsStartDate1().getYear().getSelectedItem().toString());
            month = Integer.parseInt(((OfficialView) view).getAnalyticsStartDate1().getMonth().getSelectedItem().toString());
            day = Integer.parseInt(((OfficialView) view).getAnalyticsStartDate1().getDay().getSelectedItem().toString());

            try {
                start = LocalDate.of(year, month, day);
            } catch (DateTimeException err) {
                view.popUpError("Start: " + err.getMessage());
                return;
            }

            year = Integer.parseInt(((OfficialView) view).getAnalyticsEndDate1().getYear().getSelectedItem().toString());
            month = Integer.parseInt(((OfficialView) view).getAnalyticsEndDate1().getMonth().getSelectedItem().toString());
            day = Integer.parseInt(((OfficialView) view).getAnalyticsEndDate1().getDay().getSelectedItem().toString());

            try {
                end = LocalDate.of(year, month, day);
            } catch (DateTimeException err) {
                view.popUpError("End: " + err.getMessage());
                return;
            }

            ArrayList<Case> list = ((Official) model).getPositiveCasesList(users, city, start, end);

            ((OfficialView) view).getAnalyticsResult().setText("Positive Cases in " + city +
                                                                " from " + start + " - " + end +
                                                                ": " + list.size());

            ((OfficialView) view).getAnalyticsCityField1().setText("");

            if (!analyticsPositiveCases(list)) {
                view.popUpError("No cases found.");
            } else {
                view.validate();
                view.getLayout().show(view.getDashPanel(), "analyticsCases");
            }
        });

        ((OfficialView) view).getAnalytics2Btn().addActionListener(e -> {
            LocalDate start, end;
            int year, month, day;

            year = Integer.parseInt(((OfficialView) view).getAnalyticsStartDate2().getYear().getSelectedItem().toString());
            month = Integer.parseInt(((OfficialView) view).getAnalyticsStartDate2().getMonth().getSelectedItem().toString());
            day = Integer.parseInt(((OfficialView) view).getAnalyticsStartDate2().getDay().getSelectedItem().toString());

            try {
                start = LocalDate.of(year, month, day);
            } catch (DateTimeException err) {
                view.popUpError("Start: " + err.getMessage());
                return;
            }

            year = Integer.parseInt(((OfficialView) view).getAnalyticsEndDate2().getYear().getSelectedItem().toString());
            month = Integer.parseInt(((OfficialView) view).getAnalyticsEndDate2().getMonth().getSelectedItem().toString());
            day = Integer.parseInt(((OfficialView) view).getAnalyticsEndDate2().getDay().getSelectedItem().toString());

            try {
                end = LocalDate.of(year, month, day);
            } catch (DateTimeException err) {
                view.popUpError("End: " + err.getMessage());
                return;
            }

            ArrayList<Case> list = ((Official) model).getPositiveCasesList(start, end);

            ((OfficialView) view).getAnalyticsResult().setText("Positive Cases from " +
                                                                start + " - " + end +
                                                                ": " + list.size());

            if (!analyticsPositiveCases(list)) {
                view.popUpError("No cases found.");
            } else {
                view.validate();
                view.getLayout().show(view.getDashPanel(), "analyticsCases");
            }
        });

        ((OfficialView) view).getAnalytics3Btn().addActionListener(e -> {
            if (!((OfficialView) view).getAnalyticsCityField3().getText().equals("")) {
                String city = ((OfficialView) view).getAnalyticsCityField3().getText();

                ArrayList<Case> list = ((Official) model).getPositiveCasesList(users, city);
                ((OfficialView) view).getAnalyticsResult().setText("Positive Cases in " + city + ": " + list.size());

                ((OfficialView) view).getAnalyticsCityField3().setText("");

                view.validate();
                view.getLayout().show(view.getDashPanel(), "analyticsCases");

                if (!analyticsPositiveCases(list)) {
                    view.popUpError("No cases found.");
                } else {
                    view.validate();
                    view.getLayout().show(view.getDashPanel(), "analyticsCases");
                }
            }
        });

        ((OfficialView) view).getAnalyticsBackBtn().addActionListener(e -> {
            view.getLayout().show(view.getDashPanel(), "analytics");
        });

    }

    /**
     * Display positive cases in the date range
     * @param start start date
     * @param end end date
     * @return true if successfully added, false if otherwise
     */
    private boolean showPositiveCases(LocalDate start, LocalDate end) {
        if (((OfficialView) view).getPositiveCasesPanel().getComponentCount() > 1) {
            ((OfficialView) view).getPositiveCasesPanel().remove(1);
            ((OfficialView) view).getPositiveCasesPanel().validate();
        }

        String[][] data = new String[Official.getCases().size()][5];

        for (Case i : Official.getCases()) {
            if (isDateInRange(start, end, i.getDate())) {
                for (int j = 0; j < data.length; j++) {
                    if (data[j][0] == null) {
                        data[j][0] = i.getCaseNum() + "";
                        data[j][1] = i.getCitizen();
                        data[j][2] = i.getDate() + "";
                        data[j][3] = i.getStatus() + "";
                        data[j][4] = i.getTracer();
                        break;
                    }
                }
            }
        }

        String[] columnNames = {"Case Number", "Citizen", "Date", "Status", "Assigned Tracer"};

        if (data[0][0] != null) {
            ((OfficialView) view).getPositiveCasesPanel().add(new Table(data, columnNames));
            return true;
        }

        return false;
    }

    /**
     * Display unassigned cases table
     */
    private void showUnassignedCases() {
        String[][] data = new String[Official.getCases().size()][4];

        for (Case i : Official.getCases()) {
            if (i.getTracer().equals("000")) {
                for (int j = 0; j < data.length; j++) {
                    if (data[j][0] == null) {
                        data[j][0] = i.getCaseNum() + "";
                        data[j][1] = i.getCitizen();
                        data[j][2] = i.getDate() + "";
                        data[j][3] = i.getStatus() + "";
                        break;
                    }
                }
            }
        }

        String[] columnNames = {"Case Number", "Citizen", "Date", "Status"};

        view.getDashPanel().add(new Table(data, columnNames), "unassignedCases");
    }

    /**
     * Add positive cases table for the analytics portion
     * @param list list of cases
     * @return true successfully added, false if otherwise
     */
    private boolean analyticsPositiveCases(ArrayList<Case> list) {
        if (list.isEmpty()) {
            return false;
        }

        String[][] data = new String[list.size()][5];

        for (Case i : list) {
            for (int j = 0; j < data.length; j++) {
                if (data[j][0] == null) {
                    data[j][0] = i.getCaseNum() + "";
                    data[j][1] = i.getCitizen();
                    data[j][2] = i.getDate() + "";
                    data[j][3] = i.getStatus() + "";
                    data[j][4] = i.getTracer();
                    break;
                }
            }
        }

        String[] columnNames = {"Case Number", "Citizen", "Date", "Status", "Assigned Tracer"};

        ((OfficialView) view).getAnalyticsCasesPanel().add(new Table(data, columnNames), BorderLayout.CENTER);

        return true;
    }

    /**
     * Checks the role of the user
     * @param username user's username
     * @param role role to check
     * @return true if it is the user's role, false if otherwise
     */
    private boolean checkRole(String username, String role) {
        return users.get(username).getRole().equals(role);
    }

    /**
     * Checks if user exists
     * @param username inputted username
     * @return true if user is existing, false if otherwise
     */
    private boolean isUserExisting(String username) {
        return users.containsKey(username);
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
     * Checks if user is a tracer
     * @param username username of tracer
     * @return true if user is a tracer, false if otherwise
     */
    private boolean isValidTracer(String username) {
        return users.get(username).getRole().equals("tracer");
    }

    /**
     * Checks if case number is existing
     * @param caseNum case number
     * @return true if it is existing, false if otherwiese
     */
    private boolean isValidCase(int caseNum) {
        for (Case i : Official.getCases()) {
            if (i.getCaseNum() == caseNum) {
                return true;
            }
        }

        return false;
    }
}