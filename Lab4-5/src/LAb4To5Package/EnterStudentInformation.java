package LAb4To5Package;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class EnterStudentInformation {

	/**
	 * 
	 * @param listOfStudents is our student list that will be taking inputs
	 *  and built in this function
	 * takes inputs for student's information and then loops through taking input
	 * for courses over and over until user says no creating a list of courses within
	 * the student object and then adds the student to our list
	 */
	//takes inputs for 1 single student
	public void takeUserInputs(List<Student> listOfStudents) {
		int ID = 0;
		String fName = " ";
		String lName = " ";
		int continueInputs = -1;
		String s = " ";
		boolean integerInvalid = true;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				System.out.print("Enter Student ID: ");
				ID = sc.nextInt();
				sc.nextLine();
				integerInvalid = false;
			}catch(InputMismatchException ex){
				System.out.println("Not a valid student ID: please enter a number ");
				sc.nextLine();
			}
		}while (integerInvalid);
		
		System.out.print("Enter Student First Name: ");
		fName = sc.nextLine();
		
		System.out.print("Enter Student Last Name: ");
		lName = sc.nextLine();
		
		List<String> courseList = new ArrayList<String>();
		do {
			//take course
			System.out.print("Please Enter Course Name: ");
			courseList.add(sc.nextLine());
			
			//ask for another course
			int isYNValid = -1;
			do {
				System.out.print("Would you like to add another course to the list? (Y/y, N/n): ");
				s =  sc.nextLine();
				if(s.equals("y") || s.equals("Y")) {
					continueInputs = -1;
					isYNValid = 0;
				}
				else if(s.equals("n") || s.equals("N")) {
					continueInputs = 0;
					isYNValid = 0;
				}
				else {
					System.out.println(s + " is an invalid input, please use Y/y, N/n");
					isYNValid = -1;

				}
			}while(isYNValid == -1);	
		}while(continueInputs == -1);	
		
		Student a = new Student(ID, fName, lName, courseList);
		listOfStudents.add(a);
	}
	
	/**
	 * 
	 * @param listOfStudents our list of students that will be sent to our 'takeUserInputs'
	 * function in order to build our list
	 * takes input for a first student and then will ask if user would like to enter another
	 * student continuing to loop until the user says no.
	 */
	//loops the take input function to build a list of students
	public void buildStudentList(List<Student> listOfStudents) {
		int moreStudents = -1;
		String s = " ";
		
		System.out.println("Please input the first student: ");
		Scanner sc = new Scanner(System.in);
		do {
			int isYNValid = -1;
			
			takeUserInputs(listOfStudents);
			
			do {
				System.out.print("Would you like to input another student? (Y/y, N/n): ");
				s = sc.nextLine();
				if(s.equals("y") || s.equals("Y")) {
					moreStudents = -1;
					isYNValid = 0;
				}
				else if(s.equals("n") || s.equals("N")) {
					moreStudents = 0;
					isYNValid = 0;
				}
				else {
					System.out.println(s + " is an invalid input, please use Y/y, N/n");
					isYNValid = -1;

				}
			}while(isYNValid == -1);	
		}while(moreStudents == -1);	
		sc.close();
	}
	
	/**
	 * 
	 * @param listOfStudents our student list that has been build
	 * serializes our student list and then writes the serialized data
	 * to our file filename.ser also checks for IO exception to make sure file
	 * is properly made/ exists before writing
	 */
	public void writeToFileSerialised(List<Student> listOfStudents){
		try {
		FileOutputStream fileOut = new FileOutputStream("filename.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(listOfStudents);
		out.close();
		fileOut.close();
		System.out.printf("Serialized data is saved in /filename.ser");
		
		}catch(IOException i) {
			//do something with exception
			 System.out.println("ooga booga no file");
		}
	}
	
}
