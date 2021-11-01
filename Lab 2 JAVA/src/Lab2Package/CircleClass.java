package Lab2Package;
import java.lang.Math;

/**
 * @author George
 * Shape class for reading saving, changing and printing circle
 */

public class CircleClass implements Shape {
	private double radius;
	static final double pi = Math.PI;
	
	public CircleClass(double radius) {		
		this.radius = radius;
	}
	
	@Override
	public String toString() {	
		Lab6Interface s = (double x, double y) -> (pi * (x * y));
		
		return String.format("Circle {r=%.1f} perimeter = %06g Area = " + s.calculateArea(radius, radius), getRadius(), calculatePerimeter());
	}
	
	@Override
	public double calculatePerimeter() {
		return getRadius()*pi*2;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public String getShape() {
		return "Circle";
	}
}
