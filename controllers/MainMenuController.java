package controllers;

import models.Citizen;
import views.*;
import java.util.HashMap;

/**
 * This class serves as the controller for the main menu view
 */
public class MainMenuController {

    private MainMenuView view;
    private AuthController auth;

    /**
     * Initializes controller
     * @param users list of users
     */
    public MainMenuController(HashMap<String, Citizen> users) {
        view = new MainMenuView();
        addBtnListeners();
        auth = new AuthController(users);
    }

    /**
     * Add listeners to view buttons
     */
    private void addBtnListeners() {
        view.getLoginMenuBtn().addActionListener(e -> {
            auth.showLogin();
            view.dispose();
        });

        view.getRegisterMenuBtn().addActionListener(e -> {
            auth.showRegister();
            view.dispose();
        });

        view.getExitBtn().addActionListener(e -> {
            System.exit(0);
        });
    }
}
