package myProject.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import myProject.listeners.ISalesViewListener;

public class SalesView extends JFrame {

    private static final long serialVersionUID = -729091611169270303L;

    private MainMenuBar mainMenuBar;
    private PreferencesDialog preferencesDialog;
    private SelectCustomerPanel selectCustomerPanel;
    private OrdersTablePanel ordersTablePanel;
    private TotalSalesPanel totalSalesPanel;
    private JButton clearTableButton;
    private JSeparator separator;
    private StatisticsPanel statisticsPanel;
    private Preferences preferences;

    public SalesView() {
        setLayout(new GridBagLayout());

        preferences = Preferences.userRoot().node("dbCredentials");

        mainMenuBar = new MainMenuBar();
        setJMenuBar(mainMenuBar);

        preferencesDialog = new PreferencesDialog(this);

        selectCustomerPanel = new SelectCustomerPanel();

        ordersTablePanel = new OrdersTablePanel();
        ordersTablePanel.setPreferredSize(new Dimension(600, 400));

        totalSalesPanel = new TotalSalesPanel();

        clearTableButton = new JButton("Clear");

        separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1, 1));
        separator.setForeground(Color.GRAY); // top line color
        separator.setBackground(Color.GRAY); // bottom line color

        statisticsPanel = new StatisticsPanel();

        layoutComponents();

        setWindowOptions();
    }

    public void attachListeners(final ISalesViewListener viewListener) {
        mainMenuBar.getLoadCustomersMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewListener.handleLoadOrdersClicked();
            }
        });

        mainMenuBar.getExitMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewListener.handleExitButtonClick();
            }
        });

        mainMenuBar.getPreferencesMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewListener.handlePreferencesClicked();
            }
        });
        clearTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewListener.handleClearButtonClick();
            }
        });

    }

    public MainMenuBar getMainMenuBar() {
        return mainMenuBar;
    }

    public SelectCustomerPanel getSelectCustomerPanel() {
        return selectCustomerPanel;
    }

    public OrdersTablePanel getOrdersTablePanel() {
        return ordersTablePanel;
    }

    public TotalSalesPanel getTotalSalesPanel() {
        return totalSalesPanel;
    }

    public StatisticsPanel getStatisticsPanel() {
        return statisticsPanel;
    }

    public PreferencesDialog getPreferencesDialog() {
        return preferencesDialog;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    private void layoutComponents() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(15, 0, 10, 5);
        gc.anchor = GridBagConstraints.CENTER;

        add(selectCustomerPanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(5, 30, 5, 30);
        gc.anchor = GridBagConstraints.CENTER;

        add(ordersTablePanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 95);
        gc.anchor = GridBagConstraints.LINE_END;

        add(totalSalesPanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        gc.gridx = 0;
        gc.gridy = 3;
        gc.insets = new Insets(3, 0, 3, 0);
        gc.anchor = GridBagConstraints.CENTER;

        add(clearTableButton, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        gc.gridx = 0;
        gc.gridy = 4;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.HORIZONTAL;

        add(separator, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        gc.gridx = 0;
        gc.gridy = 5;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = 0;
        gc.anchor = GridBagConstraints.LINE_START;

        add(statisticsPanel, gc);
    }

    private void setWindowOptions() {
        setTitle("Customer Sales History");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
