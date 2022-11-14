package controllers;

import views.*;
import models.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

/**
 * This class serves as the controller for the authentication view.
 */
public class AuthController {

    private AuthView view;
    private ContactInfoController infoController;
    private CitizenController user;
    private HashMap<String, Citizen> users;

    /**
     * Initializes Controller
     * @param users list of users
     */
    public AuthController(HashMap<String, Citizen> users) {
        view = new AuthView();
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                new MainMenuController(users);
            }
        });
        this.users = users;

        addBtnListeners();
    }

    /**
     * Display log in form
     */
    public void showLogin() {
        view.setTitle("Log In");
        view.setSize(300, 200);
        view.getLayout().show(view.getContentPane(), "login");
        view.setVisible(true);
    }

    /**
     * Display register form
     */
    public void showRegister() {
        view.setTitle("Register");
        view.setSize(300, 200);
        view.getLayout().show(view.getContentPane(), "register");
        view.setVisible(true);
    }

    /**
     * Add listeners to view buttons
     */
    private void addBtnListeners() {
        view.getLoginBtn().addActionListener(e -> {
            login(view.getLoginUsernameField().getText(), String.valueOf(view.getLoginPasswordField().getPassword()));

            view.getLoginUsernameField().setText("");
            view.getLoginPasswordField().setText("");
        });

        view.getRegisterBtn().addActionListener(e -> {
            String username = view.getRegisterUsernameField().getText();
            String password = String.valueOf(view.getRegisterPasswordField().getPassword());

            register(username, password);

            view.getRegisterUsernameField().setText("");
            view.getRegisterPasswordField().setText("");
        });
    }

    /**
     * Display contact information form
     */
    private void showRegisterInfo() {
        view.dispose();
        infoController.init(false);
    }

    /**
     * Log in user
     * @param username username
     * @param password password
     */
    private void login(String username, String password) {
        if (users.get(username) == null) {
            JOptionPane.showMessageDialog(null, "Invalid information.", "Invalid!", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (users.get(username).getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Successfully logged in!", "Success!", JOptionPane.PLAIN_MESSAGE);
                view.dispose();
                switch (users.get(username).getRole()) {
                    case "citizen":
                        user = new CitizenController(users);
                        break;
                    case "tracer":
                        user = new TracerController(users);
                        break;
                    case "official":
                        user = new OfficialController(users);
                }
                this.user.setCurrentUser(users.get(username));
                this.user.init();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid information.", "Invalid!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Registers a user and prompts to enter contact information
     * @param username username
     * @param password password
     */
    private void register(String username, String password) {
        if (!isUsernameValid(username)) {
            view.popUpError("Username is invalid.");
            return;
        }

        if (!isUsernameUnique(username)) {
            view.popUpError("Username is taken already.");
            return;
        }

        if (!isPasswordValid(password)) {
            view.popUpError("Invalid password. Please input 6 or more characters with at least one non-alphabetical character.");
            return;
        }

        Citizen citizen = new Citizen(username, password);
        users.put(username, citizen);
        view.popUpSuccess("Username and password accepted! Please proceed to enter your personal information.");

        infoController = new ContactInfoController(users, username);
        showRegisterInfo();
    }

    /**
     * Checks if username is unique
     * @param username username
     * @return true if username is unique, false if otherwise
     */
    private boolean isUsernameUnique(String username) {
        return !users.containsKey(username);
    }

    /**
     * Checks if username is valid
     * @param username username
     * @return true if username is valid, false if otherwise
     */
    private boolean isUsernameValid(String username) {
        return !username.contains(" ");
    }

    /**
     * Checks if the password inputted is atleast 6 characters long
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
}

