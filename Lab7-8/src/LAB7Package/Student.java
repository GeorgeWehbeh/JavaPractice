package LAB7Package;


import java.text.DecimalFormat;

public class Student {
	private String fName;
	private String lName;
	private String department;
	private double grade;

	public Student(String first, String last, double grade, String department) {
		fName = first;
		lName = last;
		this.department = department;
		this.grade = grade;
	}
	
	public String getFirstName() {
		return fName;
	}
	
	public String getLastName() {
		return lName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public String getName() {
		return fName + " " + lName;
	}
	
	
	@Override
	public String toString() {
		String s = String.format("%-15s" + "%-15s" + "%-10s" + "%-10s", getFirstName(), getLastName(),new DecimalFormat("0.00").format(getGrade()), getDepartment());
		return s;
	}
}

