package Lab2Package;

/**
 * @author George
 * Shape class for reading saving, changing and printing square
 */

public class SquareClass implements Shape{
	private double sidesSquare;
	
	public SquareClass(double sides) {
		sidesSquare = sides;		
	}
	
	@Override
	public String toString() {			
		Lab6Interface s = (double x, double y) -> (x * y);
		
		return String.format("Square {s=%.1f} perimeter = %06g Area = " + s.calculateArea(sidesSquare, sidesSquare), getSidesSquare(), calculatePerimeter());
	}
	
	@Override
	public double calculatePerimeter() {		
		return 4*getSidesSquare();
	}
		
	public double getSidesSquare() {
		return sidesSquare;
	}
	
	public void setRadius(double sides) {
		sidesSquare = sides;
	}
	
	@Override
	public String getShape() {
		return "Square";
	}
}

