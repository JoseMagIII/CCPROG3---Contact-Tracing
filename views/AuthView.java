package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class serves as the view for the program's authentication
 */
public class AuthView extends JFrame {

    private JPanel loginPanel;
    private JPanel registerPanel;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JTextField registerUsernameField;
    private JPasswordField registerPasswordField;
    private JButton loginBtn;
    private JButton registerBtn;
    private CardLayout layout;

    /**
     * Initializes components
     */
    public AuthView() {
        super();

        layout = new CardLayout();
        loginPanel = new JPanel();
        registerPanel = new JPanel();
        loginUsernameField = new JTextField();
        loginPasswordField = new JPasswordField();
        registerUsernameField = new JTextField();
        registerPasswordField = new JPasswordField();
        loginBtn = new JButton("Log in");
        registerBtn = new JButton("Register");

        initLoginPanel();
        initRegisterPanel();

        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(layout);
        getContentPane().add(loginPanel, "login");
        getContentPane().add(registerPanel, "register");
    }

    /**
     * Get card layout
     * @return card layout
     */
    public CardLayout getLayout() {
        return layout;
    }

    /**
     * Get log in button
     * @return log in button
     */
    public JButton getLoginBtn() {
        return loginBtn;
    }

    /**
     * Get register button
     * @return register button
     */
    public JButton getRegisterBtn() {
        return registerBtn;
    }

    /**
     * Get login username field
     * @return login username field
     */
    public JTextField getLoginUsernameField() {
        return loginUsernameField;
    }

    /**
     * Get login password field
     * @return login password field
     */
    public JPasswordField getLoginPasswordField() {
        return loginPasswordField;
    }

    /**
     * Get register username field
     * @return register username field
     */
    public JTextField getRegisterUsernameField() {
        return registerUsernameField;
    }

    /**
     * Get register password field
     * @return register password field
     */
    public JPasswordField getRegisterPasswordField() {
        return registerPasswordField;
    }

    /**
     * Display error message
     * @param message message to be displayed
     */
    public void popUpError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error!", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Display success message
     * @param message message to be displayed
     */
    public void popUpSuccess(String message) {
        JOptionPane.showMessageDialog(null, message, "Success!", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Initializes log in panel
     */
    private void initLoginPanel() {
        JLabel usernameLabel = new JLabel("Username", JLabel.CENTER);
        JLabel passwordLabel = new JLabel("Password", JLabel.CENTER);

        loginPanel.setLayout(new GridLayout(0, 1));
        loginPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        loginPanel.add(usernameLabel);
        loginPanel.add(loginUsernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(loginPasswordField);
        loginPanel.add(loginBtn);
    }

    /**
     * Initializes register panel
     */
    private void initRegisterPanel() {
        JLabel usernameLabel = new JLabel("Enter username", JLabel.CENTER);
        JLabel passwordLabel = new JLabel("Enter password", JLabel.CENTER);

        registerPanel.setLayout(new GridLayout(0, 1));
        registerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        registerPanel.add(usernameLabel);
        registerPanel.add(registerUsernameField);
        registerPanel.add(passwordLabel);
        registerPanel.add(registerPasswordField);
        registerPanel.add(registerBtn);
    }
}
