package LAb4To5Package;

import java.util.ArrayList;
import java.util.List;

public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int stdID = -1;
	private String firstName = " ";
	private String lastName = " ";
	List<String> courseList;
	
	/**
	 * 
	 * @param ID contains the student's ID
	 * @param fName contains the student first name
	 * @param lName contains the student last name
	 * @param cList contains our list of courses relevant to the student
	 */
	public Student(int ID, String fName, String lName, List<String> cList){	
		stdID = ID;
		firstName = fName;
		lastName = lName;	
		courseList = new ArrayList<String>(cList);

	}
	
	/**
	 * empty default constructor that will initialize our variables to defaults
	 */
	public Student() {
		
	}
	
	public int getStdID() {
		return stdID; 	
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public List<String> getCourseList(){
		return courseList;
	}
	
	public void setStdID(int ID) {
		stdID = ID;
	}
	
	public void setFirstName(String fName) {
		firstName = fName;
	}
	
	public void setLastName(String lName) {
		lastName = lName;
	}
	
	public void setCourseList(List<String> cList) {
		courseList = new ArrayList<String>(cList);
	}
}
