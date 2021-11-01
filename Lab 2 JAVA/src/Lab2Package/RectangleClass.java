package Lab2Package;

/**
 * @author George
 * Shape class for reading saving, changing and printing rectangle
 */

public class RectangleClass implements Shape{
	private double widthRectangle;
	private double heightRectangle;
	
	public RectangleClass(double width, double height) {
		widthRectangle = width;
		heightRectangle = height;		
	}
	
	@Override
	public String toString() {		
		Lab6Interface s = (double x, double y) ->  (x * y);
		return String.format("Rectangle {w=%.1f, h=%.1f} perimeter = %06g Area = " + s.calculateArea(widthRectangle, heightRectangle), getWidthRectangle(), getHeightRectangle(), calculatePerimeter());
	}
	
	@Override
	public double calculatePerimeter() {
		return (2* widthRectangle) + (2* heightRectangle);
	}
	
	public double getWidthRectangle() {
		return widthRectangle;
	}
	
	public double getHeightRectangle() {
		return heightRectangle;
	}
	
	public void setWidthRectangle(double width) {
		widthRectangle = width;
	}
	
	public void setHeightRectangle(double height) {
		heightRectangle = height;
	}
	
	@Override
	public String getShape() {
		return "Rectangle";
	}
}
