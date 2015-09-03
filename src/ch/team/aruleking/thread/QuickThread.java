
package ch.team.aruleking.thread;

import java.util.List;

import javax.swing.JButton;

import ch.team.aruleking.turtle.AdvancedTurtle;
import ch.team.aruleking.turtle.Line;
import ch.team.aruleking.turtle.Sorter;

public class QuickThread extends SortThread {
    AdvancedTurtle turtle;
    List<Line> lines;
    JButton[] buttons;

    public QuickThread(AdvancedTurtle at, List<Line> lines,JButton[] buttons) {
        super();
        this.turtle = at;
        this.lines = lines;
        this.buttons = buttons;
    }

    public void run() {
    	this.setButtonsEnabled(buttons, false);
    	
        Sorter sorter = new Sorter();
        sorter.quickSort(lines, turtle, 0, lines.size() - 1);
        
        this.setButtonsEnabled(buttons, true);
    }
}
