package Lab2Package;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Lab2Class {
	public final static String fileName = "shapes.txt";
	public static int validCounter = 0;
	public static int invalidCounter = 0;
	
	/**
	 * 
	 * @param name is the name of the text file to be read
	 * @param shapeType is our list of Shape objects
	 * Reads through input text file and creates an object for each valid listing within the 
	 * text file adding it to our list
	 */
	public static void readTextFile(final String name, List<Shape> shapeType) {
		String s;	
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((s = br.readLine()) != null) {
			String[] tokens = s.split(",");
			
			if(tokens[0].equals("Circle")) {
				if(Double.parseDouble(tokens[1]) <= 0 || tokens.length != 2 ) {
					System.out.println("Invalid radius!");
					invalidCounter++;
				}
				else {
					shapeType.add(new CircleClass(Double.parseDouble(tokens[1])));			
					validCounter++;
				}
			}
			else if(tokens[0].equals("Square")) {
				if(Double.parseDouble(tokens[1]) <= 0 || tokens.length != 2) {
					System.out.println("Invalid side!");
					invalidCounter++;
				}
				else {
					shapeType.add(new SquareClass(Double.parseDouble(tokens[1])));
					validCounter++;
				}		
			}
			else if(tokens[0].equals("Rectangle")) {
				if(Double.parseDouble(tokens[1]) <= 0 || Double.parseDouble(tokens[2]) <= 0 || tokens.length != 3) {
					System.out.println("Invalid side(s)!");
					invalidCounter++;
				}
				else {
					shapeType.add(new RectangleClass(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
					validCounter++;
				}			
			}
			else if(tokens[0].equals("Parallelogram")) {
				if(Double.parseDouble(tokens[1]) <= 0 || Double.parseDouble(tokens[2]) <= 0 || tokens.length != 3) {
					System.out.println("Invalid side(s)!");
					invalidCounter++;
				}
				else {
					shapeType.add( new ParallelogramClass(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
					validCounter++;
				}
			}
			else if(tokens[0].equals("Triangle")) {
				if(Double.parseDouble(tokens[1]) <= 0 || Double.parseDouble(tokens[2]) <= 0 || Double.parseDouble(tokens[3]) <= 0 || tokens.length != 4) {
					System.out.println("Invalid side(s)!");
					invalidCounter++;
				}
				else {
					shapeType.add(new TriangleClass(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
					validCounter++;
				}				
			}
			else {
				//do nothing if shape type is invalid
			}
			}
			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
	}
	
	/**
	 * @param shapeType is our list of shape objects
	 * Loops through the entire list of saved shape objects and prints them out followed by a newline 
	 */
	public static void printShapeList(List<Shape> shapeType) {
		for(Shape i: shapeType) {
			System.out.println(i);
			System.out.println();
		}
		
	}
	
	/**
	 * 
	 * @param shapeType list of shape objects
	 * loops through entire list determining the smallest triangle and largest circle 
	 * and then deletes them
	 * Variables
	 * current largest/smallest are place holders to determine if the shape we are looking
	 * at is smaller/ larger than our current smallest/largest shape
	 * 
	 * Index arrays used to store multiple indecies in the case of having multiple largest/smallest
	 * numbers
	 */
	public static void deleteMinMax(List<Shape> shapeType) {
		double currentSmallestTrianglePerim = 99;
		double currentLargestCirclePerim = 0;
		double[] smallestTriangleIndex = {-1, -1, -1, -1};
		double[] largestCircleIndex = {-1, -1, -1, -1};
		int countIndex = 0;
		int numDeleted = 0;
		
		for(Shape i: shapeType) {
			if(i.calculatePerimeter() <= currentSmallestTrianglePerim && i.getShape().equals("Triangle")) {
				if(i.calculatePerimeter() != currentSmallestTrianglePerim) {
					currentSmallestTrianglePerim = i.calculatePerimeter();
					smallestTriangleIndex[0] = countIndex;
					
					//resets our index array in the case of a new smallest triangle
					smallestTriangleIndex[1] = -1;
					smallestTriangleIndex[2] = -1;
					smallestTriangleIndex[3] = -1;
				}
				else {
					//finds next valid index to store smallest triangle into when we have multiple
					for(int j = 0; j < smallestTriangleIndex.length; j++) {
						if(smallestTriangleIndex[j] == -1) {
							smallestTriangleIndex[j] = countIndex;
							j = smallestTriangleIndex.length;
						}
					}
				}
			}
			else if(i.calculatePerimeter() >= currentLargestCirclePerim && i.getShape().equals("Circle")) {
				if(i.calculatePerimeter() != currentLargestCirclePerim) {
					currentLargestCirclePerim = i.calculatePerimeter();
					largestCircleIndex[0] = countIndex;
					
					//resets our index array in the case of a new largest circle
					largestCircleIndex[1] = -1;
					largestCircleIndex[2] = -1;
					largestCircleIndex[3] = -1;
				}
				else {
					//finds next valid index to store largest circle index into when we have multiple
					for(int j = 0; j < largestCircleIndex.length; j++) {
						if(largestCircleIndex[j] == -1) {
							largestCircleIndex[j] = countIndex;
							j = largestCircleIndex.length;
						}
					}
				}
			}	
			countIndex++;
		}
		//loop through our index arrays and remove the shape within any valid index (indexes that are no longer-1)
		for(int i = 0; i < 3; i++) {
			if(smallestTriangleIndex[i] != -1) {
				shapeType.remove((int)smallestTriangleIndex[i] - numDeleted);
				numDeleted++;
			}	
			if(largestCircleIndex[i] != -1) {
				shapeType.remove((int)largestCircleIndex[i]  - numDeleted);
				numDeleted++;
			}
		}
	}
	
	/**
	 * 
	 * @param shapeName string telling us for which shape we are adding all perimeters
	 * @param shapeType list of shape objects
	 * 
	 * loops through our list of shape objects finding any shape of the correct type and 
	 * adding it's perimeter to our count
	 */
	public static double calcTotalPerimeterOf(String shapeName, List<Shape> shapeType) {
		double totalPerimeterOfShapes = 0;
		
		for(Shape i: shapeType) {
			if(i.getShape().equals(shapeName)) {
				totalPerimeterOfShapes += i.calculatePerimeter();
			}
		}
		return totalPerimeterOfShapes;
	}
	public static void main(String[] args) {
		List<Shape> allShapes = new ArrayList<>();

		//Task 1
		System.out.println("------->JAC 444 Assignment 2-3<-------");
		System.out.println("------->Task 1 ... <-------");
		
		readTextFile(fileName, allShapes);
		
		System.out.println();
		System.out.println(validCounter + " shapes were created: ");
		
		printShapeList(allShapes);
		
		//Task 2
		System.out.println("------->Task 2 ... <-------");
		
		deleteMinMax(allShapes);
		printShapeList(allShapes);
		
		//Task 3
		System.out.println("------->Task 3 ... <-------");
		
		System.out.println(calcTotalPerimeterOf("Parallelogram", allShapes));
		System.out.println(calcTotalPerimeterOf("Triangle", allShapes));
	}	
}
