package views;

import javax.swing.*;

/**
 * This class displays tables in the program
 */
public class Table extends JPanel {

    /**
     * Initializes table
     * @param data data to be displayed
     * @param columnNames column names for table
     */
    public Table(String[][] data, String[] columnNames) {
        JTable table = new JTable(data, columnNames);
        table.setEnabled(false);
        JScrollPane scrollable = new JScrollPane(table);

        scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollable);
    }
}
