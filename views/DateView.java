package views;

import javax.swing.*;
import java.awt.*;

/**
 * This class serves as the date panel
 */
public class DateView extends JPanel {

    private JComboBox<Integer> year;
    private JComboBox<Integer> month;
    private JComboBox<Integer> day;

    /**
     * Initializes panel
     */
    public DateView() {
        year = new JComboBox<>();
        month = new JComboBox<>();
        day = new JComboBox<>();

        for (int y = 2020; y >= 2000; y--) {
            year.addItem(y);
        }

        for (int m = 1; m <= 12; m++) {
            month.addItem(m);
        }

        for (int d = 1; d <= 31; d++) {
            day.addItem(d);
        }

        setPreferredSize(new Dimension(200, 200));
        setLayout(new GridLayout(0, 1));
        add(new JLabel("Enter year"));
        add(year);
        add(new JLabel("Enter month"));
        add(month);
        add(new JLabel("Enter day"));
        add(day);
    }

    /**
     * Get year option
     * @return year option
     */
    public JComboBox<Integer> getYear() {
        return year;
    }

    /**
     * Get month option
     * @return month option
     */
    public JComboBox<Integer> getMonth() {
        return month;
    }

    /**
     * Get day option
     * @return day option
     */
    public JComboBox<Integer> getDay() {
        return day;
    }
}
