package myProject.view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class StatisticsPanel extends JPanel {

    private static final long serialVersionUID = -2289445551623379638L;
    private JSeparator separator;
    private JLabel statLabel;
    private JLabel numberLabel;

    public StatisticsPanel() {
        setLayout(new FlowLayout());

        statLabel = new JLabel();
        numberLabel = new JLabel();

        disableLabels();

        add(statLabel);
        add(numberLabel);
    }

    public void enableLabels() {
        statLabel.setVisible(true);
        numberLabel.setVisible(true);
    }

    public void disableLabels() {
        statLabel.setVisible(false);
        numberLabel.setVisible(false);
    }

    public void setRecordsRead(int numRecords) {
        enableLabels();
        statLabel.setText("Records Read = ");
        numberLabel.setText(String.valueOf(numRecords));
    }

    public void setSalesOnFile(int numSales) {
        statLabel.setText("Sales on File = ");
        numberLabel.setText(String.valueOf(numSales));
    }
}
