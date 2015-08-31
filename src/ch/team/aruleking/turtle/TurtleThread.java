package ch.team.aruleking.turtle;
import java.util.List;

public class TurtleThread extends Thread {
	AdvancedTurtle turtle;
	List<Line> lines;

	public TurtleThread(AdvancedTurtle at, List<Line> lines) {
		super();
		this.turtle = at;
		this.lines = lines;
	}

	public void run() {
		Sorter sorter = new Sorter();
		sorter.bubbleSort(lines, turtle);
	}


}
