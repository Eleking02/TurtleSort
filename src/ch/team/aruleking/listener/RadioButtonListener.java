package ch.team.aruleking.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class RadioButtonListener implements ActionListener {

	private JRadioButton[] radios;

	public RadioButtonListener(JRadioButton[] buttons) {
		this.radios = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton element = (JRadioButton) e.getSource();
		if (element.isSelected()) {
			for (JRadioButton radio : radios) {
				radio.setSelected(false);
			}
		} else {
			element.setSelected(true);
		}
	}
}