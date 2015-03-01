package myProject.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class PreferencesDialog extends JDialog {

    private static final long serialVersionUID = -1420116233713519757L;

    private JButton okButton;
    private JButton canelButton;
    private JSpinner portSpinner;
    private JTextField userField;
    private JPasswordField passwordfield;

    public PreferencesDialog(JFrame parent) {
        super(parent, "Database Settings", false);

        okButton = new JButton("OK");
        canelButton = new JButton("Cancel");
        canelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                Integer value = (Integer) portSpinner.getValue();
                char[] password = passwordfield.getPassword(); //wrap in new String(password) to get readable, non-hashed version
             
                setVisible(false);
            }
        });

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        userField = new JTextField(10);
        passwordfield = new JPasswordField(10);

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

        add(new JLabel("Username: "), gc);

        gc.gridy = 0;
        gc.gridx = 1;
        add(userField, gc);

        // \\//Row\\//\\
        gc.gridy = 1;
        gc.gridx = 0;
        add(new JLabel("Password: "), gc);

        gc.gridy = 1;
        gc.gridx = 1;
        add(passwordfield, gc);

        // \\//Row\\//\\
        gc.gridy = 2;
        gc.gridx = 0;
        add(new JLabel("Port: "), gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(portSpinner, gc);

        // \\//Row\\//\\
        gc.gridy = 3;
        gc.gridx = 0;

        add(okButton, gc);

        gc.gridy = 3;
        gc.gridx = 1;

        add(canelButton, gc);

    }
}
