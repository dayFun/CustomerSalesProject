package myProject.view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import myProject.listeners.ILoadCustomersListener;
import myProject.listeners.IMenuItemListener;

public class MainMenuBar extends JMenuBar {

    private static final long serialVersionUID = -5565623731124527013L;
    private JMenuItem loadCustomersMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem preferencesMenuItem;
    private IMenuItemListener menuItemListener;
    private ILoadCustomersListener loadCustomersListener;

    public MainMenuBar() {
        add(createFileMenu());
        add(createHelpMenu());
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        loadCustomersMenuItem = new JMenuItem("Load Customers");
        // loadCustomersMenuItem.addActionListener(this);
        file.add(loadCustomersMenuItem);

        exitMenuItem = new JMenuItem("Exit");
        // exitMenuItem.addActionListener(this);
        exitMenuItem.setToolTipText("Exit application");
        file.add(exitMenuItem);

        return file;
    }

    private JMenu createHelpMenu() {
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_F);

        preferencesMenuItem = new JMenuItem("Preferences");
        // preferencesMenuItem.addActionListener(this);

        KeyStroke ctrlP = KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK);
        preferencesMenuItem.setAccelerator(ctrlP);

        help.add(preferencesMenuItem);
        return help;
    }

    public void setMenuItemListener(IMenuItemListener menuItemListener) {
        this.menuItemListener = menuItemListener;
    }

    public void setLoadCustomersListener(ILoadCustomersListener loadCustomersListener) {
        this.loadCustomersListener = loadCustomersListener;
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    // if (e.getSource() == exitMenuItem) {
    // menuItemListener.exitApplication();
    // }
    //
    // if (e.getSource() == loadCustomersMenuItem) {
    // loadCustomersListener.loadCustomers();
    // }
    //
    // if (e.getSource() == preferencesMenuItem) {
    // menuItemListener.showPreferencesDialog();
    // }
    //
    // }
}
