package ch.team.aruleking.turtle;
public class Line {
	public double length;
	public double xcor;
	
	public Line(double length, double xcor) {
		this.length = length;
		this.xcor = xcor;
	}
	


	/* GETTER und SETTER */
	public double getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}



	public double getXcor() {
		return xcor;
	}



	public void setXcor(double xcor) {
		this.xcor = xcor;
	}



	public void setLength(double length) {
		this.length = length;
	}
}