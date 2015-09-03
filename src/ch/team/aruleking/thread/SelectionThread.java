
package ch.team.aruleking.thread;

import java.util.List;

import javax.swing.JButton;

import ch.team.aruleking.turtle.AdvancedTurtle;
import ch.team.aruleking.turtle.Line;
import ch.team.aruleking.turtle.Sorter;

public class SelectionThread extends SortThread {
    AdvancedTurtle turtle;
    List<Line> lines;
    JButton[] buttons;

    public SelectionThread(AdvancedTurtle at, List<Line> lines,JButton[] buttons) {
        super();
        this.turtle = at;
        this.lines = lines;
        this.buttons = buttons;
    }

    public void run() {
    	this.setButtonsEnabled(buttons, false);
        
        Sorter sorter = new Sorter();
        sorter.selectionSort(lines, turtle);
        
        this.setButtonsEnabled(buttons, true);
    }
}
