package ch.team.aruleking.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class SortThread extends Thread {
	Timer timer;
	public static int ELAPSED_TIME = 0;
	
	public void run() {
		timer = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ELAPSED_TIME++;
			}
		});
		timer.start();
	}
	
	public void setButtonsEnabled(JButton[] buttons, boolean bool) {
		for (JButton b : buttons) {
            b.setEnabled(bool);
        }
	}
}