package Lab2Package;
/**
 * @author George
 * Shape class for reading saving, changing and printing triangle
 */
public class TriangleClass implements Shape{
	private double sideA;
	private double sideB;
	private double sideC;
	
	public TriangleClass(double a, double b , double c) {
		sideA = a;
		sideB = b;
		sideC = c;
	}

	@Override
	public String toString() {	
		return String.format("Triangle {s1=%.1f, s2=%.1f, s3=%.1f} perimeter = %06g", getSideA(), getSideB(), getSideC(), calculatePerimeter());
	}
	
	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return (sideA + sideB + sideC);
	}
	
	public double getSideA() {
		return sideA;
	}
	
	public double getSideB() {
		return sideB;
	}

	public double getSideC() {
		return sideC;
	}
	
	public void setSideA(double input) {
		sideA = input;
	}
	
	public void setSideB(double input) {
		sideB = input;
	}
	
	public void setSideC(double input) {
		sideC = input;
	}
	
	@Override
	public String getShape() {
		return "Triangle";
	}
}
