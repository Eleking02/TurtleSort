package ch.team.aruleking.turtle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch.aplu.turtle.MouseHitListener;
import ch.team.aruleking.listener.RadioButtonListener;
import ch.team.aruleking.thread.BubbleThread;
import ch.team.aruleking.thread.InsertionThread;
import ch.team.aruleking.thread.QuickThread;
import ch.team.aruleking.thread.SelectionThread;


public class Starter {
	public static List<Line> lines = new ArrayList<Line>();
	public final static int MAXLINES = 32;
	private static Thread prozess = new Thread();
	
	public static void main(String args[]) {
		AdvancedTurtle turtle = new AdvancedTurtle();
		JPanel panel = new JPanel();
		JPanel optionPanel = new JPanel();
		JButton startButton = new JButton("SORT LINES");
		JButton restartButton = new JButton("RESET");
		JRadioButton opt1 = new JRadioButton();
		JRadioButton opt2 = new JRadioButton();
		JRadioButton opt3 = new JRadioButton();
		JRadioButton opt4 = new JRadioButton();
		
		//JComponents
		restartButton.setEnabled(false);
		restartButton.setBackground(Color.BLACK);
		startButton.setEnabled(false);
		startButton.setBackground(Color.BLACK);
		opt1.setText("BubbleSort");
		opt1.setBackground(Color.BLACK);
		opt1.setForeground(Color.WHITE);
		opt1.setSelected(true);
		opt2.setText("SelectionSort");
		opt2.setForeground(Color.WHITE);
		opt2.setBackground(Color.BLACK);
		opt3.setText("InsertionSort");
		opt3.setBackground(Color.BLACK);
		opt3.setForeground(Color.WHITE);
		opt4.setText("QuickSort");
		opt4.setBackground(Color.BLACK);
		opt4.setForeground(Color.WHITE);
		
		panel.add(startButton);
		panel.add(restartButton);
//		panel.add(slider);
		optionPanel.add(opt1);
		optionPanel.add(opt2);
		optionPanel.add(opt3);
		optionPanel.add(opt4);
		panel.setBackground(Color.BLACK);
		optionPanel.setBackground(Color.BLACK);
		
		//Frame
		turtle.getFrame().add(panel, BorderLayout.SOUTH);
		turtle.getFrame().add(optionPanel, BorderLayout.NORTH);
		turtle.getFrame().setResizable(false);
		turtle.getFrame().setSize(400, turtle.getFrame().getHeight());
		
		//Set Windows look & feel
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
		
		SwingUtilities.updateComponentTreeUI(turtle.getFrame());
		
		turtle.prepareGround();
		
		
		/* LISTENER */
		turtle.addMouseHitListener(new MouseHitListener() {
			@Override
			public void mouseHit(double arg0, double arg1) {
				if (arg1 > turtle.BOTTOMY && 
						arg0 >= turtle.LEFTX &&
						arg0 <= turtle.RIGHTX &&
						lines.size() < MAXLINES &&
						turtle.validatePosX(lines, arg0)  &&
						!prozess.isAlive() ) {
					startButton.setEnabled(true);
					restartButton.setEnabled(true);
					turtle.drawLineatPos(arg0, arg1);
					lines.add(new Line(arg1, arg0));
				}
			}
		});
		
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    JButton[] buttons = {startButton, restartButton};
				if (opt1.isSelected()) {
					prozess = new BubbleThread(turtle, lines, buttons);
					prozess.start();
				} else if (opt2.isSelected()) {
				    prozess = new SelectionThread(turtle, lines, buttons);
                    prozess.start();
				} else if (opt3.isSelected()) {
				    prozess = new InsertionThread(turtle, lines, buttons);
				    prozess.start();
				} else if (opt4.isSelected()) {
				    prozess = new QuickThread(turtle, lines, buttons);
				    prozess.start();
				}
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
		
		//Option buttons
		opt1.addActionListener(new RadioButtonListener(new JRadioButton[] {opt2, opt3, opt4}));
		opt2.addActionListener(new RadioButtonListener(new JRadioButton[] {opt1, opt3, opt4}));
		opt3.addActionListener(new RadioButtonListener(new JRadioButton[] {opt2, opt1, opt4}));
		opt4.addActionListener(new RadioButtonListener(new JRadioButton[] {opt1, opt2, opt3}));
	}
}