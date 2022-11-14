package controllers;

import models.*;
import views.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * This class serves as the controller for the Citizen View
 */
public class CitizenController {

    protected Citizen model;
    protected CitizenView view;
    protected HashMap<String, Citizen> users;

    /**
     * Initializes controller
     * @param users list of users
     */
    public CitizenController(HashMap<String, Citizen> users) {
        this.users = users;
    }

    /**
     * Sets the current user logged in
     * @param user the current user
     */
    public void setCurrentUser(Citizen user) {
        model = user;
    }

    /**
     * Initializes the view
     */
    public void init() {
        view = new CitizenView();
        addBtnListeners();
        view.init(model.getUsername());
        
        if (!hasReported()) {
            view.showCaution(model.getMessage());
        }
    }

    /**
     * Add all the listeners for the buttons
     */
    protected void addBtnListeners() {
        view.getCheckInMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(view.getCheckInMenuBtn());

            view.getLayout().show(view.getDashPanel(), "checkin");
        });
        
        view.getReportMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(view.getReportMenuBtn());

            view.getLayout().show(view.getDashPanel(), "report");
        });

        view.getUpdateInfoMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(view.getUpdateInfoMenuBtn());
            refreshCurrentInfo();
            view.getLayout().show(view.getDashPanel(), "updateInfo");
        });

        view.getLogOutBtn().addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log out", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                FileHandler.writeMasterList(users);
                FileHandler.writeAccountInfo(users);
                FileHandler.writeCases(Official.getCases());
                FileHandler.writeVisitRecord(users);

                if(!hasReported()) {
                    view.showCaution(model.getMessage());
                }

                view.dispose();
                setCurrentUser(null);
                new MainMenuController(users);
            }
        });

        view.getCheckInSubmitBtn().addActionListener(e -> {
            if (!view.getCheckInField().getText().equals("")) {
                String code = view.getCheckInField().getText();

                if (code.contains(" ")) {
                    view.popUpError("Invalid establishment code. Please do not enter any spaces.");
                    return;
                }

                LocalDate date;

                int year = Integer.parseInt(view.getCheckInDate().getYear().getSelectedItem().toString());
                int month = Integer.parseInt(view.getCheckInDate().getMonth().getSelectedItem().toString());
                int day = Integer.parseInt(view.getCheckInDate().getDay().getSelectedItem().toString());

                try {
                    date = LocalDate.of(year, month, day);
                } catch (DateTimeException err) {
                    view.popUpError(err.getMessage());
                    return;
                }

                model.checkIn(code, date);
                view.popUpSuccess(model.getUsername() + " checked in at " + code + " on " +
                                  date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
                view.getCheckInField().setText("");
            } else {
                view.popUpError("Establishment code cannot be empty.");
            }
        });

        view.getReportBtn().addActionListener(e -> {
            LocalDate reportDate;

            int year = Integer.parseInt(view.getReportDate().getYear().getSelectedItem().toString());
            int month = Integer.parseInt(view.getReportDate().getMonth().getSelectedItem().toString());
            int day = Integer.parseInt(view.getReportDate().getDay().getSelectedItem().toString());

            try {
                reportDate = LocalDate.of(year, month, day);
            } catch (DateTimeException err) {
                view.popUpError(err.getMessage());
                return;
            }

            switch (reportPositive(reportDate)) {
                case 0:
                    view.popUpSuccess(model.getUsername() + " reported positive on " +
                                      reportDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
                    break;
                case 1:
                    view.popUpError("14 days hasn't passed since you last reported");
                    break;
                case 2:
                    view.popUpError(model.getUsername() + " has incomplete contact information");
            }
        });

        view.getUpdatePasswordBtn().addActionListener(e -> {
            if (updatePassword(String.valueOf(view.getPasswordField().getPassword()))) {
                view.popUpSuccess("Successfully updated your password! Your new password is: " + model.getPassword());
                refreshCurrentInfo();
            } else {
                view.popUpError(String.valueOf(view.getPasswordField().getPassword()) + " is not a valid password");
            }
            view.getPasswordField().setText("");
        });

        view.getUpdateNameBtn().addActionListener(e -> {
            String firstName = view.getFirstNameField().getText().equals("") ?
                               model.getInfo().getFirstName() : view.getFirstNameField().getText();

            String middleName = view.getMiddleNameField().getText().equals("") ?
                                model.getInfo().getMiddleName() : view.getMiddleNameField().getText();

            String lastName = view.getLastNameField().getText().equals("") ?
                              model.getInfo().getLastName() : view.getLastNameField().getText();

            String name = firstName + "," + middleName + "," + lastName;

            updateName(name);
            view.popUpSuccess("Successfully updated your name! Your new name is: " + model.getInfo().getName());
            refreshCurrentInfo();
            view.getFirstNameField().setText("");
            view.getMiddleNameField().setText("");
            view.getLastNameField().setText("");
        });

        view.getUpdatePhoneNoBtn().addActionListener(e -> {
            try {
                updatePhoneNo(Long.parseLong(view.getPhoneNoField().getText()));
            } catch(NumberFormatException err) {
                view.popUpError(view.getPhoneNoField().getText() + " is an invalid phone number.");
                return;
            }

            view.popUpSuccess("Successfully updated your phone number! Your new number is " + model.getInfo().getPhoneNo());
            refreshCurrentInfo();
            view.getPhoneNoField().setText("");
        });

        view.getUpdateEmailBtn().addActionListener(e -> {
            updateEmail(view.getEmailField().getText());
            view.popUpSuccess("Successfully updated your email address! Your new email is " + model.getInfo().getEmail());
            refreshCurrentInfo();
            view.getEmailField().setText("");
        });

        view.getUpdateHomeAddressBtn().addActionListener(e -> {
            String street = view.getHomeStreetField().getText().equals("") ?
                            model.getInfo().getHomeAddress().getStreet() : view.getHomeStreetField().getText();
                            
            String city = view.getHomeCityField().getText().equals("") ?
                          model.getInfo().getHomeAddress().getCity() : view.getHomeCityField().getText();

            int postalCode;
            try {
                postalCode = view.getHomePostalField().getText().equals("") ? 
                             model.getInfo().getHomeAddress().getPostalCode() : Integer.parseInt(view.getHomePostalField().getText());
            } catch(NumberFormatException err) {
                view.popUpError(view.getHomePostalField().getText() + " is an invalid postal code.");
                return;
            }
            
            String province = view.getHomeProvinceField().getText().equals("") ? 
                              model.getInfo().getHomeAddress().getProvince() : view.getHomeProvinceField().getText();

            Address address = new Address(street, city, postalCode, province);

            updateHomeAddress(address);
            view.popUpSuccess("New address: " + model.getInfo().getHomeAddress().toString());
            refreshCurrentInfo();

        });

        view.getUpdateOfficeAddressBtn().addActionListener(e -> {
            String street = view.getOfficeStreetField().getText().equals("") ?
                            model.getInfo().getOfficeAddress().getStreet() : view.getOfficeStreetField().getText();
                            
            String city = view.getOfficeCityField().getText().equals("") ?
                          model.getInfo().getOfficeAddress().getCity() : view.getOfficeCityField().getText();

            int postalCode;
            try {
                postalCode = view.getOfficePostalField().getText().equals("") ? 
                             model.getInfo().getOfficeAddress().getPostalCode() : Integer.parseInt(view.getOfficePostalField().getText());
            } catch(NumberFormatException err) {
                view.popUpError(view.getOfficePostalField().getText() + " is an invalid postal code.");
                return;
            }
            
            String province = view.getOfficeProvinceField().getText().equals("") ? 
                              model.getInfo().getOfficeAddress().getProvince() : view.getOfficeProvinceField().getText();

            Address address = new Address(street, city, postalCode, province);

            updateOfficeAddress(address);
            view.popUpSuccess("New address: " + model.getInfo().getOfficeAddress().toString());
            refreshCurrentInfo();
        });
    }

    /**
     * Set the active button
     * @param btn button to set to active
     */
    protected void setActiveMenuBtn(JButton btn) {
        ArrayList<JButton> buttons = view.getMenuBtns();

        for (JButton i : buttons) {
            if (i.equals(btn)) {
                i.setBackground(Color.darkGray);
            } else {
                i.setBackground(new Color(32, 32, 32));
            }
        }
    }

    /**
     * Checks if the citizen has reported positive in the last 14 days.
     * @return true if citizen has reported positive, false if otherwise.
     */
    protected boolean hasReported() {
        for (Case i : Official.getCases()) {
            if (i.getCitizen().equals(model.getUsername()) && !checkDays()) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method adds a new case.
     * @param reportDate date of report
     * @return 0 if successfully reported positive
     * @return 1 if it hasn't been more than 14 days from his last case
     * @return 2 if user's information is not initialized
     */
    private int reportPositive(LocalDate reportDate) {
        if (model.getInfo().isInitialized()) {
            if (hasPreviousCase()) {
                if (checkDays()) {
                    model.reportPositive(reportDate);
                    return 0;
                } else {
                    return 1;
                }
            } else {
                model.reportPositive(reportDate);
                return 0;
            }
        } else {
            return 2;
        }
    }

    /**
     * Updates user password
     * @param password new password
     * @return true if successfully updated, false if otherwise
     */
    private boolean updatePassword(String password) {
        if (isPasswordValid(password)) {
            model.setPassword(password);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates user name
     * @param name new name
     */
    private void updateName(String name) {
        model.getInfo().setName(name);
    }

    /**
     * Updates user home address
     * @param address new address
     */
    private void updateHomeAddress(Address address) {
        model.getInfo().setHomeAddress(address);
    }

    /**
     * Updates user office address
     * @param address new address
     */
    private void updateOfficeAddress(Address address) {
        model.getInfo().setOfficeAddress(address);
    }

    /**
     * Updates user phone number
     * @param phoneNo new phone number
     */
    private void updatePhoneNo(long phoneNo) {
        model.getInfo().setPhoneNo(phoneNo);
    }

    /**
     * Updates user email address
     * @param email new email address
     * @return true if successfully updated, false if otherwise
     */
    private boolean updateEmail(String email) {
        if (isEmailValid(email)) {
            model.getInfo().setEmail(email);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the password inputted is at least 6 characters long
     * and has at least one non-alphabetical character.
     * @param password the inputted password
     * @return true if it meets the criteria and false if otherwise.
     */
    private boolean isPasswordValid(String password) {
        if (password.length() >= 6) {
            if (!password.contains(" ")) {
                for (int i = 0; i < password.length(); i++) {
                    if ((password.charAt(i) >= '0' && password.charAt(i) <= '9') ||
                        (password.charAt(i) >= 33 && password.charAt(i) <= 47) ||
                        (password.charAt(i) >= 58 && password.charAt(i) <= 64)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Checks if email is valid
     * @param email the inputted email
     * @return true if email is valid, false if it is invalid
     */
    private boolean isEmailValid(String email) {
        return email.indexOf('@') != -1;
    }

    /**
     * Checks if 14 days has passed from the previous case reported by the user
     * @return true if 14 days has passed, false if otherwise
     */
    private boolean checkDays() {
        LocalDate current = LocalDate.now();

        for (int i = Official.getCases().size() - 1; i >= 0; i--) {
            if (Official.getCases().get(i).getCitizen().equals(model.getUsername())) {
                LocalDate caseplus14 = Official.getCases().get(i).getDate().plusDays(14);
                return current.compareTo(caseplus14) >= 0;
            }
        }

        return false;
    }

    /**
     * Checks if user has a previous case
     * @return true if user has a previous case, false if otherwise
     */
    private boolean hasPreviousCase() {
        for (Case i : Official.getCases()) {
            if (i.getCitizen().equals(model.getUsername())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Refresh current info panel with new data
     */
    private void refreshCurrentInfo() {
        if (view.getCurrentInfoPanel().getComponentCount() > 0) {
            view.getCurrentInfoPanel().removeAll();
        }

        view.getCurrentInfoPanel().add(new JLabel("Username: " + model.getUsername()));
        view.getCurrentInfoPanel().add(new JLabel("Password: " + model.getPassword()));
        view.getCurrentInfoPanel().add(new JLabel("Full Name: " + model.getInfo().getName()));
        view.getCurrentInfoPanel().add(new JLabel("Phone Number: " + model.getInfo().getPhoneNo()));
        view.getCurrentInfoPanel().add(new JLabel("Email Address: " + model.getInfo().getEmail()));
        view.getCurrentInfoPanel().add(new JLabel("Home Address: " + model.getInfo().getHomeAddress().toString()));
        view.getCurrentInfoPanel().add(new JLabel("Office Address: " + model.getInfo().getOfficeAddress().toString()));

        view.validate();
    }
}
