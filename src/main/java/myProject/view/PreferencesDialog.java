package myProject.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class PreferencesDialog extends JDialog {

    private static final long serialVersionUID = -1420116233713519757L;

    public PreferencesDialog(JFrame parent) {
        super(parent, "Database Settings", false);

        setSize(400, 300);
    }
}
