package myProject.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CustomerGUI extends JFrame {

    private static final long serialVersionUID = -729091611169270303L;

    private SelectCustomerPanel selectCustomerPanel;
    private OrdersTablePanel ordersTablePanel;
    private TotalSalesPanel totalSalesPanel;
    private JButton clearTableButton;
    private JSeparator separator;
    private StatisticsPanel statisticsPanel;

    public CustomerGUI() {
        setLayout(new GridBagLayout());

        selectCustomerPanel = new SelectCustomerPanel();
        ordersTablePanel = new OrdersTablePanel();
        totalSalesPanel = new TotalSalesPanel();

        clearTableButton = new JButton("Clear");

        separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1, 1));
        separator.setForeground(Color.GRAY); // top line color
        separator.setBackground(Color.GRAY); // bottom line color
        // separator.setPreferredSize(getPreferredSize());

        statisticsPanel = new StatisticsPanel();

        layoutComponents();

        setJMenuBar(createMenuBar());
        setWindowOptions();

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
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_END;

        add(totalSalesPanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        gc.gridx = 0;
        gc.gridy = 3;
        gc.insets = new Insets(0, 0, 0, 0);
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
        gc.fill = GridBagConstraints.HORIZONTAL;

        add(statisticsPanel, gc);

        // //////////////////////Row\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    }

    private void setWindowOptions() {
        setTitle("Customer Sales History");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createHelpMenu());
        return menuBar;
    }

    private JMenu createHelpMenu() {
        return new JMenu("Help");
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem loadCustomersMenuItem = new JMenuItem("Load Customers");

        file.add(loadCustomersMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        file.add(exitMenuItem);
        return file;
    }
}
