package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class serves as the main menu view for the program
 */
public class MainMenuView extends JFrame {

    private JButton loginMenuBtn;
    private JButton registerMenuBtn;
    private JButton exitBtn;

    /**
     * Initializes view
     */
    public MainMenuView() {
        super("Main Menu");

        JLabel label = new JLabel("COVID Tracker", JLabel.CENTER) {{
            setFont(new Font(getFont().getName(), Font.BOLD, 24));
        }};
        loginMenuBtn = new JButton("Log In");
        registerMenuBtn = new JButton("Register");
        exitBtn = new JButton("Exit");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1) {{
            setVgap(20);
        }});
        panel.setBorder(new EmptyBorder(10, 20, 400, 20));
        panel.setSize(300, 200);
        panel.add(label);
        panel.add(loginMenuBtn);
        panel.add(registerMenuBtn);
        panel.add(exitBtn);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(panel);
        setSize(500, 700);
        setVisible(true);
    }

    /**
     * Get login button
     * @return login button
     */
    public JButton getLoginMenuBtn() {
        return loginMenuBtn;
    }

    /**
     * Get register button
     * @return register button
     */
    public JButton getRegisterMenuBtn() {
        return registerMenuBtn;
    }

    /**
     * Get exit button
     * @return exit button
     */
    public JButton getExitBtn() {
        return exitBtn;
    }
}
