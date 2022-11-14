package controllers;

import models.*;
import views.ContactInfoView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

/**
 * This class serves as the controller for the contact information view
 */
public class ContactInfoController {

    private ContactInfo model;
    private ContactInfoView view;
    private String username;
    private HashMap<String, Citizen> users;
    private boolean isLoggedIn;

    /**
     * Initializes class
     * @param users list of users
     * @param username username of user to register
     */
    public ContactInfoController(HashMap<String, Citizen> users, String username) {
        view = new ContactInfoView();
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                view.popUpError("Default information assigned.");
                registerInfo();
            }
        });

        model = new ContactInfo();
        this.users = users;
        this.username = username;
    }

    /**
     * Initializes controller
     * @param isLoggedIn is the current user logged in
     */
    public void init(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
        addBtnListener();
        view.init();
    }

    /**
     * Adds listeners to view buttons
     */
    private void addBtnListener() {
        view.getSubmitInfoBtn().addActionListener(e -> {
            if (view.getFirstNameField().getText().equals("") &&
                    view.getMiddleNameField().getText().equals("") &&
                    view.getLastNameField().getText().equals("")) {
                view.popUpError("Invalid name!");
                return;
            }
            String name = view.getFirstNameField().getText() + "," +
                    view.getMiddleNameField().getText() + "," +
                    view.getLastNameField().getText();

            long phoneNo = Long.parseLong(view.getPhoneNoField().getText());

            String email = view.getEmailField().getText();
            if (!isEmailValid(email)) {
                view.popUpError("Invalid email address!");
                view.getEmailField().setText("");
                return;
            }

            String homeStreet = view.getHomeStreetField().getText();
            if (homeStreet.equals("")) {
                view.popUpError("Invalid home street");
                return;
            }

            String homeCity = view.getHomeCityField().getText();
            if (homeCity.equals("")) {
                view.popUpError("Invalid home city");
                return;
            }

            int homePostal = 0;

            try {
                homePostal = Integer.parseInt(view.getHomePostalCField().getText());
            } catch (NumberFormatException err) {
                view.popUpError("Invalid home postal code!");
                view.getHomePostalCField().setText("");
                return;
            }

            String homeProvince = view.getHomeProvinceField().getText();
            if (homeProvince.equals("")) {
                view.popUpError("Invalid home province");
                return;
            }

            Address home = new Address(homeStreet, homeCity, homePostal, homeProvince);

            String officeStreet = view.getOfficeStreetField().getText();
            if (officeStreet.equals("")) {
                view.popUpError("Invalid office street");
                return;
            }

            String officeCity = view.getOfficeCityField().getText();
            if (officeCity.equals("")) {
                view.popUpError("Invalid office city");
                return;
            }

            int officePostal = 0;

            try {
                officePostal = Integer.parseInt(view.getOfficePostalCField().getText());
            } catch (NumberFormatException err) {
                view.popUpError("Invalid office postal code!");
                view.getOfficePostalCField().setText("");
                return;
            }

            String officeProvince = view.getOfficeProvinceField().getText();
            if (officeProvince.equals("")) {
                view.popUpError("Invalid office province");
                return;
            }

            Address office = new Address(officeStreet, officeCity, officePostal, officeProvince);

            model = new ContactInfo(name, home, office, email, phoneNo);

            registerInfo();

            view.popUpSuccess("Successfully registered personal information!");
        });
    }

    /**
     * Register new contact information
     */
    private void registerInfo() {
        users.get(username).setInfo(model);
        view.dispose();
        FileHandler.writeMasterList(users);
        FileHandler.writeAccountInfo(users);
        if (!isLoggedIn) {
            FileHandler.writeMasterList(users);
            FileHandler.writeAccountInfo(users);
            new MainMenuController(users);
        }
    }

    /**
     * Checks if email is valid
     * @param email the inputted email
     * @return true if email is valid, false if it is invalid
     */
    private boolean isEmailValid(String email) {
        return email.indexOf('@') != -1;
    }
}
