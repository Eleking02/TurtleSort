
package ch.team.aruleking.turtle;

import java.util.List;

import javax.swing.JButton;

public class InsertionThread extends Thread {
    AdvancedTurtle turtle;
    List<Line> lines;
    JButton[] buttons;

    public InsertionThread(AdvancedTurtle at, List<Line> lines,JButton[] buttons) {
        super();
        this.turtle = at;
        this.lines = lines;
        this.buttons = buttons;
    }

    public void run() {
        for (JButton b : buttons){
            b.setEnabled(false);
        }
        
        Sorter sorter = new Sorter();
        sorter.insertionSorter(lines, turtle);
        
        for (JButton b : buttons){
            b.setEnabled(true);
        }
    }
}
