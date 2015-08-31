
package ch.team.aruleking.turtle;

import java.util.List;

import javax.swing.JButton;

public class QuickThread extends Thread {
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
        for (JButton b : buttons){
            b.setEnabled(false);
        }
        
//        Sorter sorter = new Sorter();
        
        for (JButton b : buttons){
            b.setEnabled(true);
        }
    }
}
