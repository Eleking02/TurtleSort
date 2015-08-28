package ch.team.aruleking.turtle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import ch.aplu.turtle.MouseHitListener;


public class Starter {
	public static JPanel panel;
	public static Timer timer;
	public static Graphics g;
	public static List<Line> lines = new ArrayList<Line>();
	public final static int MAXLINES = 32;
	
	public static void main(String args[]) {
		AdvancedTurtle turtle = new AdvancedTurtle();
		JButton startButton = new JButton("SORT LINES");
		JButton restartButton = new JButton("RESET");
		
		panel = new JPanel();
		panel.add(startButton);
		panel.add(restartButton);
		panel.setBackground(Color.BLACK);
		turtle.getFrame().add(panel, BorderLayout.SOUTH);
//		turtle.getFrame().add(startButton, BorderLayout.SOUTH);
//		turtle.getFrame().add(restartButton, BorderLayout.SOUTH);
//		turtle.getFrame().setResizable(false);
		turtle.getFrame().setSize(400, turtle.getFrame().getHeight());
		restartButton.setEnabled(false);
		restartButton.setBackground(Color.BLACK);
		startButton.setEnabled(false);
		startButton.setBackground(Color.BLACK);
		
		turtle.prepareGround();
		
		turtle.addMouseHitListener(new MouseHitListener() {
			@Override
			public void mouseHit(double arg0, double arg1) {
				if (arg1 > turtle.BOTTOMY && 
						arg0 >= turtle.LEFTX &&
						arg0 <= turtle.RIGHTX &&
						lines.size() < MAXLINES &&
						turtle.validatePosX(lines, arg0)) {
					startButton.setEnabled(true);
					turtle.drawLineatPos(arg0, arg1);
					lines.add(new Line(arg1, arg0));
				}
			}
		});
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TurtleThread prozess = new TurtleThread(turtle, lines);
				prozess.start();
				restartButton.setEnabled(true);
			}
		});
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lines.size() > 0) {
					restartButton.setEnabled(false);
					startButton.setEnabled(false);
					lines.clear();
					turtle.clean();
					turtle.prepareGround();
					turtle.drawBottomLine();
				}
			}
		});
	}
}