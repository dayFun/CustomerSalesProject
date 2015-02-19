package myProject;

import java.awt.EventQueue;

import myProject.view.CustomerGUI;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// IServiceJobs serviceJobs = new ServiceJobs();
				CustomerGUI frame = new CustomerGUI();
				frame.setVisible(true);

				// Presenter presenter = new Presenter(frame, serviceJobs);
			}
		});

	}
}
