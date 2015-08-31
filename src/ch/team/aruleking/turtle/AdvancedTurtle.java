package ch.team.aruleking.turtle;
import java.awt.Color;
import java.util.List;

import ch.aplu.turtle.Turtle;

public class AdvancedTurtle extends Turtle {
	public final int BOTTOMY = -150;
	public final int LEFTX = -155;
	public final int RIGHTX = 155;
	public final int SPACE = 8;

	public AdvancedTurtle() {
		super();
		this.speed(0);
		this.hideTurtle();
	}

	public void jumpTo(double x, double y) {
		this.penUp();
		this.moveTo(x, y);
		this.penDown();
	}

	public void moveInDirection(int degrees) {
		this.setH(degrees);
		this.forward(3);
		Turtle.sleep(5);
	}

	public void drawBottomLine() {
		this.jumpTo(LEFTX, BOTTOMY);
		this.setHeading(90);
		this.forward(300);
	}

	public void drawLineatPos(double x, double y) {
		this.jumpTo(x, BOTTOMY);
		this.setHeading(0);
		this.moveTo(x, y);
	}
	
	public synchronized List<Line> drawAllLines(List<Line> newLines) {
		double x = this.LEFTX;
		for (Line l : newLines) {
			l.setXcor(x);
			this.drawLineatPos(x, l.getLength());
			x += 10;
		}
		return newLines;
	}

	public boolean validatePosX(List<Line> lines, double x) {
		boolean isValid = true;
		if (lines.size() == 0) {
			return true;
		}
		for (Line line : lines) {
			if (line.getXcor() - this.SPACE <= x && line.getXcor() + this.SPACE >= x) {
				isValid = false;
			}
		}
		return isValid;
	}
	
	public void repaint(List<Line> lines) {
		this.prepareGround();
		lines = this.drawAllLines(lines);
	}
	
	public void prepareGround() {
		this.setTitle("Turtle BubbleSort");
		this.getPlayground().setBkColor(Color.BLACK);
		this.setPenColor(Color.WHITE);
		this.drawBottomLine();
	}
}