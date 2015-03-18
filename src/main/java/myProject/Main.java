package myProject;

import java.awt.EventQueue;

import myProject.controller.Controller;
import myProject.view.MainGUI;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI mainGUI = new MainGUI();
                Controller controller = new Controller(mainGUI);
                controller.getCustomerGUI().setVisible(true);
            }
        });

    }
}
