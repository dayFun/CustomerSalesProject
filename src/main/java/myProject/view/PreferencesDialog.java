package myProject.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PreferencesDialog extends JDialog {

    private static final long serialVersionUID = -1420116233713519757L;

    private JButton okButton;
    private JButton canelButton;
    private JSpinner portSpinner;

    public PreferencesDialog(JFrame parent) {
        super(parent, "Database Settings", false);

        okButton = new JButton("OK");
        canelButton = new JButton("Cancel");
        canelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = (Integer) portSpinner.getValue();
                System.out.println(value);
                setVisible(false);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer value = (Integer) portSpinner.getValue();
                System.out.println(value);
                setVisible(false);
            }
        });

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        setLayout(new GridBagLayout());

        setDialogLayout();

        setSize(400, 300);
        setLocationRelativeTo(parent);
    }

    private void setDialogLayout() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.gridy = 0;
        gc.gridx = 0;

        add(new JLabel("Port: "), gc);

        gc.gridx = 1;
        add(portSpinner, gc);

        gc.gridy = 1;
        gc.gridx = 0;

        add(okButton, gc);

        gc.gridx = 1;

        add(canelButton, gc);

    }
}
