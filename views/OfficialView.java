package views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class serves as the view for the Government Official User
 */
public class OfficialView extends CitizenView {
    
    private JButton unassignedCasesMenuBtn;
    private JButton contactTracingUpdatesMenuBtn;
    private JButton analyticsMenuBtn;
    private JButton createOfficialMenuBtn;
    private JButton createTracerMenuBtn;
    private JButton terminateAccountMenuBtn;
    private JButton assignTracerBtn;
    private JButton showPositiveCasesBtn;
    private JButton createOfficialBtn;
    private JButton createTracerBtn;
    private JButton terminateBtn;
    private JButton analytics1Btn;
    private JButton analytics2Btn;
    private JButton analytics3Btn;
    private JButton analyticsBackBtn;
    private JTextField assignTracerCaseNoField;
    private JTextField assignTracerUsernameField;
    private JTextField officialUsernameField;
    private JTextField tracerUsernameField;
    private JTextField terminateField;
    private JTextField analyticsCityField1;
    private JTextField analyticsCityField3;
    private JPanel unassignedCasesPanel;
    private JPanel contactTracingUpdatesPanel;
    private JPanel assignTracerPanel;
    private JPanel positiveCasesPanel;
    private JPanel analyticsPanel;
    private JPanel analyticsCasesPanel;
    private JPanel createOfficialPanel;
    private JPanel createTracerPanel;
    private JPanel terminatePanel;
    private JLabel analyticsResult;
    private DateView posCasesStartDate;
    private DateView posCasesEndDate;
    private DateView analyticsStartDate1;
    private DateView analyticsEndDate1;
    private DateView analyticsStartDate2;
    private DateView analyticsEndDate2;

    /**
     * Initializes view components
     */
    public OfficialView() {
        super();
        setTitle("Official");

        unassignedCasesMenuBtn = new JButton("Show Unassigned Cases");
        contactTracingUpdatesMenuBtn = new JButton("Show Contact Tracing Updates");
        analyticsMenuBtn = new JButton("Analytics");
        createOfficialMenuBtn = new JButton("Create Government Official");
        createTracerMenuBtn = new JButton("Create Contact Tracer");
        terminateAccountMenuBtn = new JButton("Terminate Account");
        assignTracerBtn = new JButton("Submit");
        showPositiveCasesBtn = new JButton("Show Positive Cases");
        createOfficialBtn = new JButton("Submit");
        createTracerBtn = new JButton("Submit");
        terminateBtn = new JButton("Submit");
        analytics1Btn = new JButton("Submit");
        analytics2Btn = new JButton("Submit");
        analytics3Btn = new JButton("Submit");
        analyticsBackBtn = new JButton("Go Back");

        assignTracerCaseNoField = new JTextField(12);
        assignTracerUsernameField = new JTextField(12);
        officialUsernameField = new JTextField(12);
        tracerUsernameField = new JTextField(12);
        terminateField = new JTextField(12);
        analyticsCityField1 = new JTextField(12);
        analyticsCityField3 = new JTextField(12);

        unassignedCasesPanel = new JPanel();
        contactTracingUpdatesPanel = new JPanel();
        assignTracerPanel = new JPanel();
        positiveCasesPanel = new JPanel();
        analyticsPanel = new JPanel();
        analyticsCasesPanel = new JPanel();
        createOfficialPanel = new JPanel();
        createTracerPanel = new JPanel();
        terminatePanel = new JPanel();

        analyticsResult = new JLabel();

        posCasesStartDate = new DateView();
        posCasesEndDate = new DateView();
        analyticsStartDate1 = new DateView();
        analyticsEndDate1 = new DateView();
        analyticsStartDate2 = new DateView();
        analyticsEndDate2 = new DateView();
    }

    /**
     * Get menu buttons
     * @return menu buttons
     */
    @Override
    public ArrayList<JButton> getMenuBtns() {
        ArrayList<JButton> buttons = super.getMenuBtns();

        buttons.add(getUnassignedCasesMenuBtn());
        buttons.add(getContactTracingUpdatesMenuBtn());
        buttons.add(getAnalyticsMenuBtn());
        buttons.add(getCreateOfficialMenuBtn());
        buttons.add(getCreateTracerMenuBtn());
        buttons.add(getTerminateAccountMenuBtn());

        return buttons;
    }

    /**
     * Get unassigned cases menu button
     * @return unassigned cases menu button
     */
    public JButton getUnassignedCasesMenuBtn() {
        return unassignedCasesMenuBtn;
    }

    /**
     * Get contact tracing updates menu button
     * @return contact tracing updates menu button
     */
    public JButton getContactTracingUpdatesMenuBtn() {
        return contactTracingUpdatesMenuBtn;
    }

    /**
     * Get analytics menu button
     * @return analytics menu button
     */
    public JButton getAnalyticsMenuBtn() {
        return analyticsMenuBtn;
    }

    /**
     * Get create official menu button
     * @return create official menu button
     */
    public JButton getCreateOfficialMenuBtn() {
        return createOfficialMenuBtn;
    }

    /**
     * Get create tracer menu button
     * @return create tracer menu button
     */
    public JButton getCreateTracerMenuBtn() {
        return createTracerMenuBtn;
    }

    /**
     * Get terminate account menu button
     * @return terminate account menu button
     */
    public JButton getTerminateAccountMenuBtn() {
        return terminateAccountMenuBtn;
    }

    /**
     * Get assign tracer button
     * @return assign tracer button
     */
    public JButton getAssignTracerBtn() {
        return assignTracerBtn;
    }

    /**
     * Get show positive cases button
     * @return show positive cases button
     */
    public JButton getShowPositiveCasesBtn() {
        return showPositiveCasesBtn;
    }

    /**
     * Get create official button
     * @return create official button
     */
    public JButton getCreateOfficialBtn() {
        return createOfficialBtn;
    }

    /**
     * Get create tracer button
     * @return create tracer button
     */
    public JButton getCreateTracerBtn() {
        return createTracerBtn;
    }

    /**
     * Get terminate account button
     * @return terminate account button
     */
    public JButton getTerminateBtn() {
        return terminateBtn;
    }

    /**
     * Get first analytics button
     * @return first analytics button
     */
    public JButton getAnalytics1Btn() {
        return analytics1Btn;
    }

    /**
     * Get second analytics button
     * @return second analytics button
     */
    public JButton getAnalytics2Btn() {
        return analytics2Btn;
    }

    /**
     * Get third analytics button
     * @return third analytics button
     */
    public JButton getAnalytics3Btn() {
        return analytics3Btn;
    }

    /**
     * Get analytics back button
     * @return analytics back button
     */
    public JButton getAnalyticsBackBtn() {
        return analyticsBackBtn;
    }

    /**
     * Get assign case number field
     * @return assign case number field
     */
    public JTextField getAssignCaseNoField() {
        return assignTracerCaseNoField;
    }

    /**
     * Get assign tracer username field
     * @return assign tracer username field
     */
    public JTextField getAssignCaseUsernameField() {
        return assignTracerUsernameField;
    }

    /**
     * Get create official username field
     * @return create official username field
     */
    public JTextField getOfficialUsernameField() {
        return officialUsernameField;
    }

    /**
     * Get create tracer username field
     * @return create tracer username field
     */
    public JTextField getTracerUsernameField() {
        return tracerUsernameField;
    }

    /**
     * Get terminate username field
     * @return terminate username field
     */
    public JTextField getTerminateField() {
        return terminateField;
    }

    /**
     * Get first analytics city field
     * @return first analytics city field
     */
    public JTextField getAnalyticsCityField1() {
        return analyticsCityField1;
    }

    /**
     * Get third analytics city field
     * @return third analytics city field
     */
    public JTextField getAnalyticsCityField3() {
        return analyticsCityField3;
    }

    /**
     * Get positive cases panel
     * @return positive cases panel
     */
    public JPanel getPositiveCasesPanel() {
        return positiveCasesPanel;
    }

    /**
     * Get label for analytics result
     * @return label for analytics result
     */
    public JLabel getAnalyticsResult() {
        return analyticsResult;
    }

    /**
     * Get positive cases start date panel
     * @return positive cases start date panel
     */
    public DateView getPosCasesStartDate() {
        return posCasesStartDate;
    }

    /**
     * Get positive cases end date panel
     * @return positive cases end date panel
     */
    public DateView getPosCasesEndDate() {
        return posCasesEndDate;
    }

    /**
     * Get first analytics start date panel
     * @return first analytics start date panel
     */
    public DateView getAnalyticsStartDate1() {
        return analyticsStartDate1;
    }

    /**
     * Get first analytics end date panel
     * @return first analytics end date panel
     */
    public DateView getAnalyticsEndDate1() {
        return analyticsEndDate1;
    }

    /**
     * Get second analytics start date panel
     * @return second analytics start date panel
     */
    public DateView getAnalyticsStartDate2() {
        return analyticsStartDate2;
    }

    /**
     * Get second analytics end date panel
     * @return second analytics end date panel
     */
    public DateView getAnalyticsEndDate2() {
        return analyticsEndDate2;
    }

    /**
     * Get analytics cases panel
     * @return analytics cases panel
     */
    public JPanel getAnalyticsCasesPanel() {
        analyticsCasesPanel.setLayout(new BorderLayout());
        analyticsCasesPanel.add(analyticsResult, BorderLayout.NORTH);
        analyticsCasesPanel.add(analyticsBackBtn, BorderLayout.SOUTH);
        return analyticsCasesPanel;
    }

    /**
     * Initializes view
     * @param username logged in user's username
     */
    @Override
    public void init(String username) {
        super.init(username);

        initContactTracingUpdatesPanel();
        initAnalyticsPanel();
        initCreateOfficialPanel();
        initCreateTracerPanel();
        initTerminatePanel();

        JScrollPane scrollableTracing = new JScrollPane(contactTracingUpdatesPanel);
        scrollableTracing.setBorder(new EmptyBorder(0, 0, 0, 0));

        JScrollPane scrollableAnalytics = new JScrollPane(analyticsPanel);
        scrollableAnalytics.setBorder(new EmptyBorder(0, 0, 0, 0));

        dashPanel.add(unassignedCasesPanel, "unassignedCases");
        dashPanel.add(scrollableTracing, "contactTracingUpdates");
        dashPanel.add(scrollableAnalytics, "analytics");
        dashPanel.add(analyticsCasesPanel, "analyticsCases");
        dashPanel.add(createOfficialPanel, "createOfficial");
        dashPanel.add(createTracerPanel, "createTracer");
        dashPanel.add(terminatePanel, "terminate");
    }

    /**
     * Initializes menu panel
     */
    @Override
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

        unassignedCasesMenuBtn.setBorderPainted(false);
        unassignedCasesMenuBtn.setOpaque(true);
        unassignedCasesMenuBtn.setBackground(new Color(32, 32, 32));
        unassignedCasesMenuBtn.setForeground(Color.white);

        contactTracingUpdatesMenuBtn.setBorderPainted(false);
        contactTracingUpdatesMenuBtn.setOpaque(true);
        contactTracingUpdatesMenuBtn.setBackground(new Color(32, 32, 32));
        contactTracingUpdatesMenuBtn.setForeground(Color.white);

        analyticsMenuBtn.setBorderPainted(false);
        analyticsMenuBtn.setOpaque(true);
        analyticsMenuBtn.setBackground(new Color(32, 32, 32));
        analyticsMenuBtn.setForeground(Color.white);

        createOfficialMenuBtn.setBorderPainted(false);
        createOfficialMenuBtn.setOpaque(true);
        createOfficialMenuBtn.setBackground(new Color(32, 32, 32));
        createOfficialMenuBtn.setForeground(Color.white);

        createTracerMenuBtn.setBorderPainted(false);
        createTracerMenuBtn.setOpaque(true);
        createTracerMenuBtn.setBackground(new Color(32, 32, 32));
        createTracerMenuBtn.setForeground(Color.white);

        terminateAccountMenuBtn.setBorderPainted(false);
        terminateAccountMenuBtn.setOpaque(true);
        terminateAccountMenuBtn.setBackground(new Color(32, 32, 32));
        terminateAccountMenuBtn.setForeground(Color.white);

        logOutBtn.setBorderPainted(false);
        logOutBtn.setOpaque(true);
        logOutBtn.setBackground(new Color(32, 32, 32));
        logOutBtn.setForeground(Color.white);

        buttons.add(checkInMenuBtn);
        buttons.add(reportMenuBtn);
        buttons.add(updateInfoMenuBtn);
        buttons.add(unassignedCasesMenuBtn);
        buttons.add(contactTracingUpdatesMenuBtn);
        buttons.add(analyticsMenuBtn);
        buttons.add(createOfficialMenuBtn);
        buttons.add(createTracerMenuBtn);
        buttons.add(terminateAccountMenuBtn);
        buttons.add(logOutBtn);

        menuPanel.add(buttons);
    }

    /**
     * Initializes create official panel
     */
    private void initCreateOfficialPanel() {
        createOfficialPanel.setLayout(new BorderLayout());

        JLabel panelLabel = new JLabel("CREATE OFFICIAL", JLabel.CENTER);
        panelLabel.setFont(new Font(panelLabel.getFont().getName(), Font.BOLD, 32));

        JLabel usernameLabel = new JLabel("Enter username");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(usernameLabel);
        inputPanel.add(officialUsernameField);
        inputPanel.add(createOfficialBtn);

        createOfficialPanel.add(panelLabel, BorderLayout.NORTH);
        createOfficialPanel.add(inputPanel, BorderLayout.CENTER);
    }

    /**
     * Initializes create tracer panel
     */
    private void initCreateTracerPanel() {
        createTracerPanel.setLayout(new BorderLayout());

        JLabel panelLabel = new JLabel("CREATE TRACER", JLabel.CENTER);
        panelLabel.setFont(new Font(panelLabel.getFont().getName(), Font.BOLD, 32));

        JLabel usernameLabel = new JLabel("Enter username");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(usernameLabel);
        inputPanel.add(tracerUsernameField);
        inputPanel.add(createTracerBtn);

        createTracerPanel.add(panelLabel, BorderLayout.NORTH);
        createTracerPanel.add(inputPanel, BorderLayout.CENTER);
    }

    /**
     * Initializes terminate account panel
     */
    private void initTerminatePanel() {
        terminatePanel.setLayout(new BorderLayout());

        JLabel terminateLabel = new JLabel("TERMINATE ACCOUNT", JLabel.CENTER);
        terminateLabel.setFont(new Font(terminateLabel.getFont().getName(), Font.BOLD, 32));

        JLabel usernameLabel = new JLabel("Enter username");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(usernameLabel);
        inputPanel.add(terminateField);
        inputPanel.add(terminateBtn);

        terminatePanel.add(terminateLabel, BorderLayout.NORTH);
        terminatePanel.add(inputPanel, BorderLayout.CENTER);
    }

    /**
     * Initializes contact tracing updates panel
     */
    private void initContactTracingUpdatesPanel() {
        initAssignTracerPanel();
        initPositiveCasesPanel();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(assignTracerPanel, BorderLayout.NORTH);
        inputPanel.add(positiveCasesPanel, BorderLayout.SOUTH);

        contactTracingUpdatesPanel.add(inputPanel);
    }

    /**
     * Initializes assign tracer panel
     */
    private void initAssignTracerPanel() {
        assignTracerPanel.setBorder(BorderFactory.createTitledBorder("Assign Tracer"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        JLabel caseNoLabel = new JLabel("Enter Case Number");
        JLabel tracerLabel = new JLabel("Enter Tracer's Username");

        c.gridx = 0;
        c.gridy = 0;

        inputPanel.add(caseNoLabel, c);

        c.gridx = 1;
        c.gridy = 0;

        inputPanel.add(assignTracerCaseNoField, c);

        c.gridx = 0;
        c.gridy = 1;

        inputPanel.add(tracerLabel, c);

        c.gridx = 1;
        c.gridy = 1;

        inputPanel.add(assignTracerUsernameField, c);

        c.gridx = 0;
        c.gridy = 2;

        inputPanel.add(assignTracerBtn, c);

        assignTracerPanel.add(inputPanel);
    }

    /**
     * Initializes positive cases panel
     */
    private void initPositiveCasesPanel() {
        positiveCasesPanel.setLayout(new BorderLayout());
        positiveCasesPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Positive Cases"), new EmptyBorder(10, 10, 10, 10)));

        JLabel startDateLabel = new JLabel("Enter start date");
        JLabel endDateLabel = new JLabel("Enter end date");

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;

        JPanel startDatePanel = new JPanel();
        startDatePanel.setLayout(new GridBagLayout());
        startDatePanel.add(startDateLabel, c);

        c.gridy = 1;

        startDatePanel.add(posCasesStartDate, c);

        c.gridx = 0;
        c.gridy = 0;

        JPanel endDatePanel = new JPanel();
        endDatePanel.setLayout(new GridBagLayout());
        endDatePanel.add(endDateLabel, c);

        c.gridy = 1;

        endDatePanel.add(posCasesEndDate, c);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1, 2));
        datePanel.add(startDatePanel);
        datePanel.add(endDatePanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 1;

        inputPanel.add(datePanel);

        c.gridx = 1;
        c.gridy = 2;

        inputPanel.add(showPositiveCasesBtn, c);

        positiveCasesPanel.add(inputPanel, BorderLayout.NORTH);
    }

    /**
     * Initializes analytics panel
     */
    private void initAnalyticsPanel() {
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel panel1 = new JPanel();
        panel1.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Show positive cases in a city in a given duration"), new EmptyBorder(10, 10, 10, 10)));
        panel1.setLayout(new GridBagLayout());

        JPanel panel1Start = new JPanel();
        panel1Start.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 0;

        panel1Start.add(new JLabel("Enter start date"), c);

        c.gridy = 1;

        panel1Start.add(analyticsStartDate1, c);

        JPanel panel1End = new JPanel();
        panel1End.setLayout(new GridBagLayout());

        c.gridy = 0;

        panel1End.add(new JLabel("Enter end date"), c);

        c.gridy = 1;

        panel1End.add(analyticsEndDate1, c);

        JPanel panel1Date = new JPanel();
        panel1Date.setLayout(new GridLayout(1, 2));
        panel1Date.add(panel1Start);
        panel1Date.add(panel1End);

        JPanel panel1City = new JPanel();
        panel1City.setLayout(new FlowLayout());
        panel1City.add(new JLabel("Enter city"));
        panel1City.add(analyticsCityField1);

        JPanel panel1Input = new JPanel();
        panel1Input.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 1;

        panel1.add(panel1Date, c);

        c.gridx = 0;
        c.gridy = 0;

        panel1.add(panel1City, c);

        c.gridx = 2;
        c.gridy = 2;

        panel1.add(analytics1Btn, c);

        JPanel panel2 = new JPanel();
        panel2.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Show positive cases in a given duration"), new EmptyBorder(10, 10, 10, 10)));
        panel2.setLayout(new GridBagLayout());

        JPanel panel2Start = new JPanel();
        panel2Start.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 0;

        panel2Start.add(new JLabel("Enter start date"), c);

        c.gridy = 1;

        panel2Start.add(analyticsStartDate2, c);

        JPanel panel2End = new JPanel();
        panel2End.setLayout(new GridBagLayout());

        c.gridy = 0;

        panel2End.add(new JLabel("Enter end date"), c);

        c.gridy = 1;

        panel2End.add(analyticsEndDate2, c);

        JPanel panel2Date = new JPanel();
        panel2Date.setLayout(new GridLayout(1, 2));
        panel2Date.add(panel2Start);
        panel2Date.add(panel2End);

        c.gridy = 0;

        panel2.add(panel2Date, c);

        c.gridx = 2;
        c.gridy = 1;

        panel2.add(analytics2Btn, c);

        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder("Show positive cases in a city"));
        panel3.setLayout(new BorderLayout());

        JPanel panel3Input = new JPanel();
        panel3Input.setLayout(new FlowLayout());
        panel3Input.add(new JLabel("Enter city"));
        panel3Input.add(analyticsCityField3);
        panel3Input.add(analytics3Btn);

        panel3.add(panel3Input, BorderLayout.NORTH);

        analyticsPanel.setLayout(new GridLayout(0, 1));
        analyticsPanel.add(panel1);
        analyticsPanel.add(panel2);
        analyticsPanel.add(panel3);
    }
}
