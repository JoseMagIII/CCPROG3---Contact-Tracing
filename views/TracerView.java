package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class serves as the View for the Tracer
 */
public class TracerView extends CitizenView {

    private JButton showCasesMenuBtn;
    private JButton traceCaseMenuBtn;
    private JButton informBtn;
    private JButton traceBtn;
    private JTextField caseNumField;
    private JPanel tracePanel;
    private JPanel informPanel;
    private JPanel casesPanel;

    /**
     * Initializes view components
     */
    public TracerView() {
        super();
        setTitle("Tracer");

        showCasesMenuBtn = new JButton("Show Cases");
        traceCaseMenuBtn = new JButton("Trace Case");
        informBtn = new JButton("Inform Citizens");
        traceBtn = new JButton("Trace Case");

        caseNumField = new JTextField(12);

        tracePanel = new JPanel();
        informPanel = new JPanel();
        casesPanel = new JPanel();
    }

    /**
     * Get menu buttons
     * @return menu buttons
     */
    @Override
    public ArrayList<JButton> getMenuBtns() {
        ArrayList<JButton> buttons = super.getMenuBtns();

        buttons.add(getShowCasesMenuBtn());
        buttons.add(getTraceCaseMenuBtn());

        return buttons;
    }

    /**
     * Get show cases menu button
     * @return show cases menu button
     */
    public JButton getShowCasesMenuBtn() {
        return showCasesMenuBtn;
    }

    /**
     * Get trace case menu button
     * @return trace case menu button
     */
    public JButton getTraceCaseMenuBtn() {
        return traceCaseMenuBtn;
    }

    /**
     * Get inform citizens button
     * @return inform citizens button
     */
    public JButton getInformBtn() {
        return informBtn;
    }

    /**
     * Get trace button
     * @return return trace button
     */
    public JButton getTraceBtn() {
        return traceBtn;
    }

    /**
     * Get text field of the case number
     * @return case number text field
     */
    public JTextField getCaseNumField() {
        return caseNumField;
    }

    /**
     * Get panel for cases
     * @return panel for cases
     */
    public JPanel getCasesPanel() {
        return casesPanel;
    }

    /**
     * Get trace case panel
     * @return trace case panel
     */
    public JPanel getTracePanel() {
        return tracePanel;
    }

    /**
     * Initializes view class
     */
    @Override
    public void init(String username) {
        super.init(username);

        initTracePanel();

        getDashPanel().add(casesPanel, "cases");
        getDashPanel().add(tracePanel, "traceCase");
        getDashPanel().add(informPanel, "inform");
    }

    /**
     * Initializes menu sidebar
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

        logOutBtn.setBorderPainted(false);
        logOutBtn.setOpaque(true);
        logOutBtn.setBackground(new Color(32, 32, 32));
        logOutBtn.setForeground(Color.white);

        showCasesMenuBtn.setBorderPainted(false);
        showCasesMenuBtn.setOpaque(true);
        showCasesMenuBtn.setBackground(new Color(32, 32, 32));
        showCasesMenuBtn.setForeground(Color.white);

        traceCaseMenuBtn.setBorderPainted(false);
        traceCaseMenuBtn.setOpaque(true);
        traceCaseMenuBtn.setBackground(new Color(32, 32, 32));
        traceCaseMenuBtn.setForeground(Color.white);

//        informMenuBtn.setBorderPainted(false);
//        informMenuBtn.setOpaque(true);
//        informMenuBtn.setBackground(new Color(32, 32, 32));
//        informMenuBtn.setForeground(Color.white);

        buttons.add(checkInMenuBtn);
        buttons.add(reportMenuBtn);
        buttons.add(updateInfoMenuBtn);
        buttons.add(showCasesMenuBtn);
        buttons.add(traceCaseMenuBtn);
//        buttons.add(informMenuBtn);
        buttons.add(logOutBtn);

        menuPanel.add(buttons);
    }

    /**
     * Initializes trace case panel
     */
    private void initTracePanel() {
        JLabel caseNumLbl = new JLabel("Enter case number to trace");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(caseNumLbl);
        inputPanel.add(caseNumField);
        inputPanel.add(traceBtn);

        tracePanel.setLayout(new BorderLayout());
        tracePanel.add(inputPanel, BorderLayout.NORTH);
    }

}
