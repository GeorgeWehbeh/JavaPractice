package LAB7Package;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class lab7to8Main {

	
	private static Student[] students = {
			 new Student("George", "Wehbeh", 95.0, "IT"),
			 new Student("Ben", "Ten", 76.0, "Media"),
			 new Student("John", "Snow", 31.8, "IT"),
			 new Student("Jon", "Ten", 39.5, "IT"),
			 new Student("Proff", "X", 69.0, "Media"),
			 new Student("Jack", "Daniels", 40.0, "Business"),
			 new Student("Another", "Name", 82.6, "IT")
	};
	
	public static void main(String[] args) {
		
		//Task 1-----------------------------------------------
		System.out.println("Task 1: ");
		System.out.println();
		System.out.println("Complete Student List:");
		List<Student> list = Arrays.asList(students);
		list.forEach(System.out::println);
		
		//Task 2--------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 2: ");
		System.out.println();
		System.out.println("Students who got 50.0-100.0 sorted by grade: ");
		list.stream().filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100).sorted(Comparator.comparing(Student::getGrade)).collect(Collectors.toList()).forEach(System.out::println);
		
		//Task 3---------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 3: ");
		System.out.println();
		System.out.println("First Student who got 50.0-100.0: ");
		Optional<Student> student = list.stream().filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100).findFirst();
		System.out.println(student.get());
		
		//Task 4---------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 4: ");
		System.out.println();
		System.out.println("Students in ascending order by last name then first: ");
		list.stream().sorted(Comparator.comparing(Student::getFirstName)).sorted(Comparator.comparing(Student::getLastName)).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println();
		System.out.println("Students in descending order by last name then first: ");
		list.stream().sorted(Comparator.comparing(Student::getFirstName).reversed()).sorted(Comparator.comparing(Student::getLastName).reversed()).collect(Collectors.toList()).forEach(System.out::println);
		
		//Task 5------------------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 5: ");
		System.out.println();
		System.out.println("Unique Student last names: ");
		list.stream().sorted(Comparator.comparing(Student::getLastName)).map(Student::getLastName).distinct().collect(Collectors.toList()).forEach(System.out::println);
		
		//Task 6--------------------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 6: ");
		System.out.println();
		System.out.println("Student names in order by last name then first name: ");
		System.out.println();
		list.stream().sorted(Comparator.comparing(Student::getFirstName)).sorted(Comparator.comparing(Student::getLastName)).map(Student::getName).collect(Collectors.toList()).forEach(System.out::println);
		
		//Task 7----------------------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 7: ");
		System.out.println();
		System.out.println("Students by department: ");
		System.out.println();
		System.out.println("Business");
		list.stream().filter(s -> s.getDepartment().equalsIgnoreCase("Business")).map(s -> "   " + s.toString()).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("Media");
		list.stream().filter(s -> s.getDepartment().equalsIgnoreCase("Media")).map(s -> "   " + s.toString()).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("IT");
		list.stream().filter(s -> s.getDepartment().equalsIgnoreCase("IT")).map(s -> "   " + s.toString()).collect(Collectors.toList()).forEach(System.out::println);
		
		//Task 8------------------------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 8: ");
		System.out.println();
		System.out.println("Count of Students by department: ");
		System.out.println();
		System.out.println("Business has " + list.stream().filter(s -> s.getDepartment().equalsIgnoreCase("Business")).map(s -> "  " + s.toString()).collect(Collectors.toList()).size()
				+ " student(s)");
		System.out.println("Media has " + list.stream().filter(s -> s.getDepartment().equalsIgnoreCase("Media")).map(s -> "  " + s.toString()).collect(Collectors.toList()).size()
				 + " student(s)");
		System.out.println("IT has " + list.stream().filter(s -> s.getDepartment().equalsIgnoreCase("IT")).map(s -> "  " + s.toString()).collect(Collectors.toList()).size()
				 + " student(s)");
		
		//Task 9---------------------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 9: ");
		System.out.println();
		System.out.println("Sum of Students' grades: " + list.stream().mapToDouble(Student::getGrade).sum());
		
		//Task 10---------------------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("Task 10: ");
		System.out.println();
		System.out.println("Average of Students' grades: " + new DecimalFormat("0.00").format(list.stream().mapToDouble(Student::getGrade).sum()/list.stream().collect(Collectors.toList()).size()));
	}
}

