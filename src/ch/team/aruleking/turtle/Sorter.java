package ch.team.aruleking.turtle;
import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public synchronized void bubbleSort(List<Line> lines, AdvancedTurtle turtle) {
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = 0; i < lines.size() - 1; i++) {
                if (lines.get(i).getLength() > lines.get(i + 1).getLength()) {
                    Line temp = lines.get(i + 1);
                    lines.set(i + 1, lines.get(i));
                    lines.set(i, temp);
                    isChanged = true;
                }
                turtle.repaint(lines);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public synchronized void selectionSort(List<Line> lines, AdvancedTurtle turtle) {
        List<Line> sorted = new ArrayList<Line>();
        List<Line> unsorted = new ArrayList<Line>(lines);
        while (unsorted.size() > 0){
            Line longest = this.removeLongest(unsorted);
            sorted.add(0, longest);        
            lines.clear();
            lines.addAll(sorted);
            lines.addAll(unsorted);
            turtle.repaint(lines);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        turtle.repaint(lines);
    }
    
    private synchronized Line removeLongest(List<Line> lines){
        Line longest = lines.get(0);
        int removeThisIndex = 0;
        for (int index = 1; index < lines.size(); index++){
            Line nextLine = lines.get(index);
            if (nextLine.getLength() > longest.getLength()){
                longest = nextLine;
                removeThisIndex = index;
            }
        }
        lines.remove(removeThisIndex);
        return longest;
    }
}