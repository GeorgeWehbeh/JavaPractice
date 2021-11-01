package Lab2Package;

/**
 * @author George
 * Shape class for reading saving, changing and printing parallelogram
 */

public class ParallelogramClass implements Shape{
	private double heightParallelogram;
	private double widthParallelogram;
	
	public ParallelogramClass(double width, double height) {
		widthParallelogram = width;
		heightParallelogram = height;

	}
	
	@Override
	public String toString() {	
		return String.format("Parallelogram {w=%.1f, h=%.1f} perimeter = %06g", getLengthParallelogram(), getHeightParallelogram(), calculatePerimeter());
	}
	
	@Override
	public double calculatePerimeter() {
		return (2* heightParallelogram) + (2* widthParallelogram);
	}

	public double getHeightParallelogram() {
		return heightParallelogram;
	}
	
	public double getLengthParallelogram() {
		return widthParallelogram;
	}
	
	public void setHeightParallelogram(double height) {
		heightParallelogram = height;
	}
	
	public void setLengthParallelogram(double length) {
		widthParallelogram = length;
	}	
	
	@Override
	public String getShape() {
		return "Parallelogram";
	}
	
}
