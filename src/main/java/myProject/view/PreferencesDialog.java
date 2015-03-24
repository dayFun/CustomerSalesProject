package myProject.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import myProject.listeners.IPreferencesListener;

public class PreferencesDialog extends JDialog {

    private static final long serialVersionUID = -1420116233713519757L;

    private Preferences preferences;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField urlField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField portField;
    private IPreferencesListener preferencesListener;

    public PreferencesDialog(JFrame parent) {
        super(parent, "Database Settings", false);

        preferences = Preferences.userRoot().node("myProject/dao/preferences");

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlField.getText();
                String user = usernameField.getText();
                String port = portField.getText();
                char[] password = passwordField.getPassword();
                if (preferencesListener != null) {
                    preferencesListener.preferencesSet(url, user, new String(password), port);
                }
                setVisible(false);
            }
        });

        urlField = new JTextField(20);
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        portField = new JTextField(10);

        initLayout();
        setLocationRelativeTo(parent);
    }

    public void setPreferencesListener(IPreferencesListener preferencesListener) {
        this.preferencesListener = preferencesListener;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setDefaultPreferences(String url, String user, String password, String port) {
        urlField.setText(url);
        usernameField.setText(user);
        passwordField.setText(password);
        portField.setText(port);
    }

    private void initLayout() {
        JPanel controlsPanel = layoutControls();
        JPanel buttonsPanel = layoutButtons();

        int space = 10;
        Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
        Border titleBorder = BorderFactory.createTitledBorder("Preferences");
        controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        setLayout(new BorderLayout());
        add(controlsPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setSize(450, 200);
    }

    private JPanel layoutButtons() {
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        Dimension buttonSize = cancelButton.getPreferredSize();
        okButton.setPreferredSize(buttonSize);

        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);

        return buttonsPanel;
    }

    private JPanel layoutControls() {
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        // //////////////////////////////////////////////////////////////
        gc.gridy = 0;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("DB URL: "), gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(urlField, gc);

        // \\//Row\\//\\
        gc.gridy = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("Username: "), gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(usernameField, gc);

        // \\//Row\\//\\
        gc.gridy = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("Password: "), gc);

        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(passwordField, gc);

        // \\//Row\\//\\
        gc.gridy = 3;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("Port: "), gc);

        gc.gridy = 3;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(portField, gc);

        return controlsPanel;
    }
}
