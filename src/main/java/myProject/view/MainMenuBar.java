package myProject.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import myProject.listeners.IMenuItemListener;

public class MainMenuBar extends JMenuBar implements ActionListener {

    private static final long serialVersionUID = -5565623731124527013L;
    private JMenuItem loadCustomersMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem preferencesMenuItem;
    private IMenuItemListener menuItemListener;

    public MainMenuBar() {
        add(createFileMenu());
        add(createHelpMenu());
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        loadCustomersMenuItem = new JMenuItem("Load Customers");
        loadCustomersMenuItem.addActionListener(this);
        file.add(loadCustomersMenuItem);

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);
        exitMenuItem.setToolTipText("Exit application");
        file.add(exitMenuItem);

        return file;
    }

    private JMenu createHelpMenu() {
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_F);

        preferencesMenuItem = new JMenu("Preferences...");
        preferencesMenuItem.addActionListener(this);

        help.add(preferencesMenuItem);
        return help;
    }

    public void setMenuItemListener(IMenuItemListener menuItemListener) {
        this.menuItemListener = menuItemListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.err.println("Source: " + e.getSource());
        if (e.getSource() == exitMenuItem) {
            menuItemListener.exitApplication();
        }

        if (e.getSource() == loadCustomersMenuItem) {
            menuItemListener.getCustomersFromDatabase();
        }

        if (e.getSource() == preferencesMenuItem) {
            menuItemListener.showPreferencesDialog();
        }

    }
}
