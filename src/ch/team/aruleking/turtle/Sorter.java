package ch.team.aruleking.turtle;
import java.util.List;

public class Sorter {

	public synchronized static void bubbleSort(List<Line> lines, AdvancedTurtle turtle) {
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
		turtle.repaint(lines);
	}
}