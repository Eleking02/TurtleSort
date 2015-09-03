package ch.team.aruleking.turtle;
import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public void bubbleSort(List<Line> lines, AdvancedTurtle turtle) {
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
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public void selectionSort(List<Line> lines, AdvancedTurtle turtle) {
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
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        turtle.repaint(lines);
    }
    
	public void insertionSorter(List<Line> lines, AdvancedTurtle turtle) {
		Line temp;
		
		for (int i = 1; i < lines.size(); i++) {
			temp = lines.get(i);
			int j = i;
			while (j > 0 && lines.get(j - 1).getLength() > temp.getLength()) {
				lines.set(j, lines.get(j - 1));
				j--;
				turtle.repaint(lines);
				try {
	                Thread.sleep(50);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
			}
			lines.set(j, temp);
		}
		turtle.repaint(lines);
	}
    
	public void quickSort(List<Line> lines, AdvancedTurtle turtle, double low, double high) {
		double middle = low + (high - low) / 2;
		Line pivot = lines.get((int) middle);
		
		int i = (int) low, j = (int) high;
		while (i <= j) {
			while (lines.get(i).getLength() < pivot.getLength()) {
				i++;
			}
			while (lines.get(j).getLength() > pivot.getLength()) {
				j--;
			}
			
			if (i <= j) {
				Line line = lines.get(i);
				lines.set(i, lines.get(j));
				lines.set(j, line);
				i++;
				j--;
			}
			turtle.repaint(lines);
			try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		if (low < j) {
			this.quickSort(lines, turtle, low, j);
		}
		if (high > i) {
			this.quickSort(lines, turtle, i, high);
		}
	}
	
    private Line removeLongest(List<Line> lines) {
        Line longest = lines.get(0);
        int removeThisIndex = 0;
        for (int index = 1; index < lines.size(); index++) {
            Line nextLine = lines.get(index);
            if (nextLine.getLength() > longest.getLength()) {
                longest = nextLine;
                removeThisIndex = index;
            }
        }
        lines.remove(removeThisIndex);
        return longest;
    }
}