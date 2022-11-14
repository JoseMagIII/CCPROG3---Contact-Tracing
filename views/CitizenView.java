package views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This class serves as teh view for the Citizen User
 */
public class CitizenView extends JFrame {

    protected JButton checkInMenuBtn;
    protected JButton reportMenuBtn;
    protected JButton updateInfoMenuBtn;
    protected JButton logOutBtn;
    protected JPanel dashPanel;
    protected JPanel menuPanel;
    protected CardLayout layout;
    private JButton checkInSubmitBtn;
    private JButton reportBtn;
    private JButton updatePasswordBtn;
    private JButton updateNameBtn;
    private JButton updatePhoneNoBtn;
    private JButton updateEmailBtn;
    private JButton updateHomeAddressBtn;
    private JButton updateOfficeAddressBtn;
    private JPanel checkInPanel;
    private JPanel reportPanel;
    private JPanel updateInfoPanel;
    private JPanel currentInfoPanel;
    private JTextField checkInField;
    private JTextField firstNameField;
    private JTextField middleNameField;
    private JTextField lastNameField;
    private JTextField phoneNoField;
    private JTextField emailField;
    private JTextField homeStreetField;
    private JTextField homeCityField;
    private JTextField homePostalField;
    private JTextField homeProvinceField;
    private JTextField officeStreetField;
    private JTextField officeCityField;
    private JTextField officePostalField;
    private JTextField officeProvinceField;
    private JPasswordField passwordField;
    private DateView reportDate;
    private DateView checkInDate;

    /**
     * Initializes view components
     */
    public CitizenView() {
        dashPanel = new JPanel();
        layout = new CardLayout();
        checkInMenuBtn = new JButton("Check In");
        reportMenuBtn = new JButton("Report Positive Test Result");
        updateInfoMenuBtn = new JButton("Update Profile Information");
        checkInSubmitBtn = new JButton("Check In");
        logOutBtn = new JButton("Log out");
        reportBtn = new JButton("Report Positive");
        updatePasswordBtn = new JButton("Update Password");
        updateNameBtn = new JButton("Update Name");
        updatePhoneNoBtn = new JButton("Update Phone Number");
        updateEmailBtn = new JButton("Update Email Address");
        updateHomeAddressBtn = new JButton("Update Home Address");
        updateOfficeAddressBtn = new JButton("Update Office Address");
        menuPanel = new JPanel();
        checkInPanel = new JPanel();
        reportPanel = new JPanel();
        updateInfoPanel = new JPanel();
        currentInfoPanel = new JPanel();
        checkInField = new JTextField(12);
        firstNameField = new JTextField(12);
        middleNameField = new JTextField(12);
        lastNameField = new JTextField(12);
        phoneNoField = new JTextField(12);
        emailField = new JTextField(12);
        homeStreetField = new JTextField(12);
        homeCityField = new JTextField(12);
        homePostalField = new JTextField(12);
        homeProvinceField = new JTextField(12);
        officeStreetField = new JTextField(12);
        officeCityField = new JTextField(12);
        officePostalField = new JTextField(12);
        officeProvinceField = new JTextField(12);
        passwordField = new JPasswordField(12);
        reportDate = new DateView();
        checkInDate = new DateView();

        setTitle("Citizen");
        setSize(980, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Get dash panel
     * @return dash panel
     */
    public JPanel getDashPanel() {
        return dashPanel;
    }

    /**
     * Get current user information panel
     * @return current user information panel
     */
    public JPanel getCurrentInfoPanel() {
        return currentInfoPanel;
    }

    /**
     * Get card layout
     * @return card layout
     */
    public CardLayout getLayout() {
        return layout;
    }

    /**
     * Get menu buttons
     * @return menu buttons
     */
    public ArrayList<JButton> getMenuBtns() {
        ArrayList<JButton> buttons = new ArrayList<>();

        buttons.add(checkInMenuBtn);
        buttons.add(reportMenuBtn);
        buttons.add(updateInfoMenuBtn);

        return buttons;
    }

    /**
     * Get check in menu button
     * @return check in menu button
     */
    public JButton getCheckInMenuBtn() {
        return checkInMenuBtn;
    }

    /**
     * Get report menu button
     * @return report menu button
     */
    public JButton getReportMenuBtn() {
        return reportMenuBtn;
    }

    /**
     * Get update user information menu button
     * @return update user information menu button
     */
    public JButton getUpdateInfoMenuBtn() {
        return updateInfoMenuBtn;
    }

    /**
     * Get check in submit button
     * @return check in submit button
     */
    public JButton getCheckInSubmitBtn() {
        return checkInSubmitBtn;
    }

    /**
     * Get log out button
     * @return log out button
     */
    public JButton getLogOutBtn() {
        return logOutBtn;
    }

    /**
     * Get report positive button
     * @return report positive button
     */
    public JButton getReportBtn() {
        return reportBtn;
    }

    /**
     * Get update password button
     * @return update password button
     */
    public JButton getUpdatePasswordBtn() {
        return updatePasswordBtn;
    }

    /**
     * Get update name button
     * @return update name button
     */
    public JButton getUpdateNameBtn() {
        return updateNameBtn;
    }

    /**
     * Get update phone number button
     * @return update phone number button
     */
    public JButton getUpdatePhoneNoBtn() {
        return updatePhoneNoBtn;
    }

    /**
     * Get update email button
     * @return update email button
     */
    public JButton getUpdateEmailBtn() {
        return updateEmailBtn;
    }

    /**
     * Get update home address button
     * @return update home address button
     */
    public JButton getUpdateHomeAddressBtn() {
        return updateHomeAddressBtn;
    }

    /**
     * Get update office address button
     * @return update office address button
     */
    public JButton getUpdateOfficeAddressBtn() {
        return updateOfficeAddressBtn;
    }

    /**
     * Get check in field
     * @return check in field
     */
    public JTextField getCheckInField() {
        return checkInField;
    }

    /**
     * Get first name field
     * @return first name field
     */
    public JTextField getFirstNameField() {
        return firstNameField;
    }

    /**
     * Get middle name field
     * @return middle name field
     */
    public JTextField getMiddleNameField() {
        return middleNameField;
    }

    /**
     * Get last name field
     * @return last name field
     */
    public JTextField getLastNameField() {
        return lastNameField;
    }

    /**
     * Get phone number field
     * @return phone number field
     */
    public JTextField getPhoneNoField() {
        return phoneNoField;
    }

    /**
     * Get email field
     * @return email field
     */
    public JTextField getEmailField() {
        return emailField;
    }

    /**
     * Get home street field
     * @return home street field
     */
    public JTextField getHomeStreetField() {
        return homeStreetField;
    }

    /**
     * Get home city field
     * @return home city field
     */
    public JTextField getHomeCityField() {
        return homeCityField;
    }

    /**
     * Get home postal code field
     * @return home postal code field
     */
    public JTextField getHomePostalField() {
        return homePostalField;
    }

    /**
     * Get home province field
     * @return home province field
     */
    public JTextField getHomeProvinceField() {
        return homeProvinceField;
    }

    /**
     * Get office street field
     * @return office street field
     */
    public JTextField getOfficeStreetField() {
        return officeStreetField;
    }

    /**
     * Get office city field
     * @return office city field
     */
    public JTextField getOfficeCityField() {
        return officeCityField;
    }

    /**
     * Get office postal code field
     * @return office postal code field
     */
    public JTextField getOfficePostalField() {
        return officePostalField;
    }

    /**
     * Get office province field
     * @return office province field
     */
    public JTextField getOfficeProvinceField() {
        return officeProvinceField;
    }

    /**
     * Get password field
     * @return password field
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Get report positive date panel
     * @return report positive date panel
     */
    public DateView getReportDate() {
        return reportDate;
    }

    /**
     * Get check in date panel
     * @return check in date panel
     */
    public DateView getCheckInDate() {
        return checkInDate;
    }

    /**
     * Initializes view
     * @param username logged in user's username
     */
    public void init(String username) {
        dashPanel.setLayout(layout);
        dashPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Default content in dash panel
        JPanel defaultPanel = new JPanel();
        JLabel defaultLabel = new JLabel("Welcome " + username + "!", JLabel.CENTER);
        defaultLabel.setFont(new Font(defaultLabel.getFont().getName(), Font.BOLD, 32));

        defaultPanel.setLayout(new BorderLayout());
        defaultPanel.add(defaultLabel, BorderLayout.NORTH);

        initMenuPanel();
        initCheckInPanel();
        initReportPanel();
        initUpdateInfoPanel();

        currentInfoPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Current Information"), new EmptyBorder(10, 10, 10, 10)));
        currentInfoPanel.setLayout(new GridLayout(0, 1));

        JScrollPane scrollableInfoPanel = new JScrollPane(updateInfoPanel);
        scrollableInfoPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollableInfoPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollableInfoPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        JScrollPane scrollableMenuPanel = new JScrollPane(menuPanel);
        scrollableMenuPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollableMenuPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollableMenuPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Card layout components
        dashPanel.add(defaultPanel, "default");
        dashPanel.add(checkInPanel, "checkin");
        dashPanel.add(reportPanel, "report");
        dashPanel.add(scrollableInfoPanel, "updateInfo");

        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(scrollableMenuPanel, BorderLayout.WEST);
        getContentPane().add(dashPanel, BorderLayout.CENTER);

        // Display default panel
        layout.show(dashPanel, "default");

        setVisible(true);
    }

    /**
     * Display success message
     * @param message message to be displayed
     */
    public void popUpSuccess(String message) {
        JOptionPane.showMessageDialog(null, message, "Success!", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Display error message
     * @param message message to be displayed
     */
    public void popUpError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error!", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Display caution message
     * @param message message to be displayed
     */
    public void showCaution(String message) {
        JOptionPane.showMessageDialog(null, message, "Caution!", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Initialize menu panel
     */
    protected void initMenuPanel() {
        menuPanel.setBackground(new Color(32, 32, 32));
        menuPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(0, 1) {{
            setVgap(20);
        }});
        buttons.setOpaque(false);

        checkInMenuBtn.setBorderPainted(false);
        checkInMenuBtn.setOpaque(true);
        checkInMenuBtn.setBackground(new Color(32, 32, 32));
        checkInMenuBtn.setForeground(Color.white);

        reportMenuBtn.setBorderPainted(false);
        reportMenuBtn.setOpaque(true);
        reportMenuBtn.setBackground(new Color(32, 32, 32));
        reportMenuBtn.setForeground(Color.white);

        updateInfoMenuBtn.setBorderPainted(false);
        updateInfoMenuBtn.setOpaque(true);
        updateInfoMenuBtn.setBackground(new Color(32, 32, 32));
        updateInfoMenuBtn.setForeground(Color.white);

        logOutBtn.setBorderPainted(false);
        logOutBtn.setOpaque(true);
        logOutBtn.setBackground(new Color(32, 32, 32));
        logOutBtn.setForeground(Color.white);

        buttons.add(checkInMenuBtn);
        buttons.add(reportMenuBtn);
        buttons.add(updateInfoMenuBtn);
        buttons.add(logOutBtn);

        menuPanel.add(buttons);
    }

    /**
     * Initializes check in panel
     */
    private void initCheckInPanel() {
        JLabel checkInLabel = new JLabel("Enter establishment code", JLabel.CENTER);

        JPanel codePanel = new JPanel();

        codePanel.setLayout(new FlowLayout());
        codePanel.add(checkInLabel);
        codePanel.add(checkInField);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;

        inputPanel.add(codePanel, c);

        c.gridy = 1;

        inputPanel.add(checkInDate, c);

        c.gridy = 2;

        inputPanel.add(checkInSubmitBtn, c);

        checkInPanel.add(inputPanel);
    }

    /**
     * Initializes report positive panel
     */
    private void initReportPanel() {
        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;

        inputPanel.add(reportDate, c);

        c.gridy = 1;

        inputPanel.add(reportBtn, c);

        reportPanel.add(inputPanel);
    }

    /**
     * Initializes update contact information panel
     */
    private void initUpdateInfoPanel() {
        JLabel passwordLabel = new JLabel("Enter password");

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        passwordPanel.add(updatePasswordBtn);

        JLabel firstNameLabel = new JLabel("Enter first name");
        JLabel middleNameLabel = new JLabel("Enter middle name");
        JLabel lastNameLabel = new JLabel("Enter last name");
        JLabel phoneNoLabel = new JLabel("Enter phone number");
        JLabel emailLabel = new JLabel("Enter email address");

        JPanel firstNamePanel = new JPanel();
        firstNamePanel.setLayout(new FlowLayout());
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameField);

        JPanel middleNamePanel = new JPanel();
        middleNamePanel.setLayout(new FlowLayout());
        middleNamePanel.add(middleNameLabel);
        middleNamePanel.add(middleNameField);

        JPanel lastNamePanel = new JPanel();
        lastNamePanel.setLayout(new FlowLayout());
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameField);

        JPanel namePanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        namePanel.setBorder(BorderFactory.createTitledBorder("Name"));
        namePanel.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 0;
        
        namePanel.add(firstNamePanel, c);
        
        c.gridy = 1;
        
        namePanel.add(middleNamePanel, c);

        c.gridy = 2;

        namePanel.add(lastNamePanel, c);

        c.gridx = 1;
        c.gridy = 3;

        namePanel.add(updateNameBtn, c);

        JPanel phoneNoPanel = new JPanel();
        phoneNoPanel.setBorder(BorderFactory.createTitledBorder("Phone Number"));
        phoneNoPanel.setLayout(new FlowLayout());
        phoneNoPanel.add(phoneNoLabel);
        phoneNoPanel.add(phoneNoField);
        phoneNoPanel.add(updatePhoneNoBtn);

        JPanel emailPanel = new JPanel();
        emailPanel.setBorder(BorderFactory.createTitledBorder("Email Address"));
        emailPanel.setLayout(new FlowLayout());
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        emailPanel.add(updateEmailBtn);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 1));
        inputPanel.add(passwordPanel);
        inputPanel.add(namePanel);
        inputPanel.add(phoneNoPanel);
        inputPanel.add(emailPanel);
        inputPanel.add(getHomeAddressPanel());
        inputPanel.add(getOfficeAddressPanel());

        updateInfoPanel.setLayout(new BorderLayout());
        updateInfoPanel.add(currentInfoPanel, BorderLayout.NORTH);
        updateInfoPanel.add(inputPanel, BorderLayout.CENTER);
    }

    /**
     * Get home address panel
     * @return home address panel
     */
    private JPanel getHomeAddressPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Home Address"), new EmptyBorder(10, 10, 10, 10)));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel streetLabel = new JLabel("Enter street");
        JLabel cityLabel = new JLabel("Enter city");
        JLabel postalLabel = new JLabel("Enter postal code");
        JLabel provinceLabel = new JLabel("Enter province");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2));
        inputPanel.add(streetLabel);
        inputPanel.add(cityLabel);
        inputPanel.add(homeStreetField);
        inputPanel.add(homeCityField);
        inputPanel.add(postalLabel);
        inputPanel.add(provinceLabel);
        inputPanel.add(homePostalField);
        inputPanel.add(homeProvinceField);

        c.gridx = 0;
        c.gridy = 0;

        panel.add(inputPanel, c);

        c.gridx = 1;
        c.gridy = 1;

        panel.add(updateHomeAddressBtn, c);

        return panel;
    }

    /**
     * Get office address panel
     * @return office address panel
     */
    private JPanel getOfficeAddressPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Office Address"), new EmptyBorder(10, 10, 10, 10)));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel streetLabel = new JLabel("Enter street");
        JLabel cityLabel = new JLabel("Enter city");
        JLabel postalLabel = new JLabel("Enter postal code");
        JLabel provinceLabel = new JLabel("Enter province");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2));
        inputPanel.add(streetLabel);
        inputPanel.add(cityLabel);
        inputPanel.add(officeStreetField);
        inputPanel.add(officeCityField);
        inputPanel.add(postalLabel);
        inputPanel.add(provinceLabel);
        inputPanel.add(officePostalField);
        inputPanel.add(officeProvinceField);

        c.gridx = 0;
        c.gridy = 0;

        panel.add(inputPanel, c);

        c.gridx = 1;
        c.gridy = 1;

        panel.add(updateOfficeAddressBtn, c);

        return panel;
    }
}
