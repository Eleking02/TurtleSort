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
import javax.swing.JSlider;

import ch.aplu.turtle.MouseHitListener;


public class Starter {
	public static List<Line> lines = new ArrayList<Line>();
	public final static int MAXLINES = 32;
	private static TurtleThread prozess;
	
	public static void main(String args[]) {
		AdvancedTurtle turtle = new AdvancedTurtle();
		JPanel panel = new JPanel();
		JPanel optionPanel = new JPanel();
		JButton startButton = new JButton("SORT LINES");
		JButton restartButton = new JButton("RESET");
		JSlider slider = new JSlider();
		JRadioButton opt1 = new JRadioButton();
		JRadioButton opt2 = new JRadioButton();
		JRadioButton opt3 = new JRadioButton();
		JRadioButton opt4 = new JRadioButton();
		
		//JComponents
		restartButton.setEnabled(false);
		restartButton.setBackground(Color.BLACK);
		startButton.setEnabled(false);
		startButton.setBackground(Color.BLACK);
		slider.setBackground(Color.BLACK);
		slider.setFocusable(false);
		slider.setMaximum(100);
		slider.setMinimum(1);
		slider.setToolTipText("Sortspeed");
		opt1.setText("BubbleSort");
		opt1.setBackground(Color.BLACK);
		opt1.setForeground(Color.WHITE);
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
		panel.add(slider);
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
		
		turtle.prepareGround();
		
		
		/* LISTENER */
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
				if (opt1.isSelected()) {
					prozess = new TurtleThread(turtle, lines);
					prozess.start();
					restartButton.setEnabled(true);
				} else if (opt2.isSelected()) {
					//TODO SelectionSort
				} else if (opt3.isSelected()) {
					//TODO InsertionSort
				} else if (opt4.isSelected()) {
					//TODO QuickSort
				}
			}
		});
		restartButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
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
		opt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opt2.setSelected(false);
				opt3.setSelected(false);
				opt4.setSelected(false);
			}
		});
		opt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opt1.setSelected(false);
				opt3.setSelected(false);
				opt4.setSelected(false);
			}
		});
		opt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opt1.setSelected(false);
				opt2.setSelected(false);
				opt4.setSelected(false);
			}
		});
		opt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				opt1.setSelected(false);
				opt2.setSelected(false);
				opt3.setSelected(false);
			}
		});
	}
}