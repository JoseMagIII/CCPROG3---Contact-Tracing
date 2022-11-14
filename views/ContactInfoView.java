package views;

import javax.swing.*;
import java.awt.*;

/**
 * This class serves as the view for the user's contact information
 */
public class ContactInfoView extends JFrame {

    private JTextField firstNameField;
    private JTextField middleNameField;
    private JTextField lastNameField;
    private JTextField phoneNoField;
    private JTextField emailField;
    private JTextField homeStreetField;
    private JTextField homeCityField;
    private JTextField homePostalCField;
    private JTextField homeProvinceField;
    private JTextField officeStreetField;
    private JTextField officeCityField;
    private JTextField officePostalCField;
    private JTextField officeProvinceField;
    private JButton submitInfoBtn;

    /**
     * Initializes view components
     */
    public ContactInfoView() {
        firstNameField = new JTextField(15);
        middleNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        phoneNoField = new JTextField(15);
        emailField = new JTextField(15);
        homeStreetField = new JTextField(15);
        homeCityField = new JTextField(15);
        homePostalCField = new JTextField(15);
        homeProvinceField = new JTextField(15);
        officeStreetField = new JTextField(15);
        officeCityField = new JTextField(15);
        officePostalCField = new JTextField(15);
        officeProvinceField = new JTextField(15);
        submitInfoBtn = new JButton("Submit Personal Information");
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
    public JTextField getHomePostalCField() {
        return homePostalCField;
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
    public JTextField getOfficePostalCField() {
        return officePostalCField;
    }

    /**
     * Get office province field
     * @return office province field
     */
    public JTextField getOfficeProvinceField() {
        return officeProvinceField;
    }

    /**
     * Get submit information button
     * @return submit information button
     */
    public JButton getSubmitInfoBtn() {
        return submitInfoBtn;
    }

    /**
     * Initializes view
     */
    public void init() {
        JLabel firstNameLabel = new JLabel("First name");
        JLabel middleNameLabel = new JLabel("Middle name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel phoneNoLabel = new JLabel("Phone number");
        JLabel emailLabel = new JLabel("Email Address");

        JPanel personalInfoPanel = new JPanel();
        personalInfoPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));
        personalInfoPanel.setLayout(new GridLayout(0, 1));

        JPanel firstNamePanel = new JPanel();
        firstNamePanel.setLayout(new FlowLayout());
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameField);
        personalInfoPanel.add(firstNamePanel);

        JPanel middleNamePanel = new JPanel();
        middleNamePanel.setLayout(new FlowLayout());
        middleNamePanel.add(middleNameLabel);
        middleNamePanel.add(middleNameField);
        personalInfoPanel.add(middleNamePanel);

        JPanel lastNamePanel = new JPanel();
        lastNamePanel.setLayout(new FlowLayout());
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameField);
        personalInfoPanel.add(lastNamePanel);

        JPanel phoneNoPanel = new JPanel();
        phoneNoPanel.setLayout(new FlowLayout());
        phoneNoPanel.add(phoneNoLabel);
        phoneNoPanel.add(phoneNoField);
        personalInfoPanel.add(phoneNoPanel);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout());
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        personalInfoPanel.add(emailPanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 1));
        inputPanel.add(personalInfoPanel);
        inputPanel.add(getHomeAddressPanel());
        inputPanel.add(getOfficeAddressPanel());

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridx = 0;

        getContentPane().add(inputPanel, c);

        c.gridy = 1;

        getContentPane().add(submitInfoBtn, c);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
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
     * Get home address panel
     * @return home address panel
     */
    private JPanel getHomeAddressPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Home Address"));

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
        inputPanel.add(homePostalCField);
        inputPanel.add(homeProvinceField);

        panel.add(inputPanel);

        return panel;
    }

    /**
     * Office address panel
     * @return office address panel
     */
    private JPanel getOfficeAddressPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Office Address"));

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
        inputPanel.add(officePostalCField);
        inputPanel.add(officeProvinceField);

        panel.add(inputPanel);

        return panel;
    }
}
