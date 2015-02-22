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

        statLabel = new JLabel("Records Read = ");
        statLabel.setVisible(false);

        numberLabel = new JLabel();
        numberLabel.setVisible(false);

        add(statLabel);
        add(numberLabel);
    }
}
