package LAb4To5Package;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyGUI implements ActionListener {
	private JFrame frame;
	private JButton deserializeButton;
	private JButton readButton;
	private JButton finalButton;
	private JTextArea outputOfFile;
	private JPanel panel;
	private JTextField userTextStudentNumber;
	private JTextField userTextFirstName;
	private JTextField userTextLastName;
	private JTextField userTextCourses;
	private JLabel studentNumber;
	private JLabel firstName;
	private JLabel lastName;
	private JLabel courses;
	private JLabel studentsInList;
	private int studentsAdded = 0;
	List<Student> students;
	
	
	public MyGUI(List<Student> listOfStudents) {
		students = listOfStudents;
		
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		//deserialisation output and button
		outputOfFile = new JTextArea("");
		outputOfFile.setBounds(10,10,250,800);
		panel.add(outputOfFile);
		deserializeButton = new JButton("Read from file");
		deserializeButton.setBounds(10, 825, 250, 100);
		deserializeButton.addActionListener(this);
		panel.add(deserializeButton);
		
		//adds all input fields
		studentNumber = new JLabel();
		studentNumber.setBounds(300,20,165,25);
		studentNumber.setText("Student ID: ");
		panel.add(studentNumber);
		userTextStudentNumber = new JTextField();
		userTextStudentNumber.setBounds(300,40,165,25);
		panel.add(userTextStudentNumber);
		
		firstName = new JLabel();
		firstName.setBounds(300,70,165,25);
		firstName.setText("First Name: ");
		panel.add(firstName);
		userTextFirstName = new JTextField();
		userTextFirstName.setBounds(300,90,165,25);
		panel.add(userTextFirstName);
		
		lastName = new JLabel();
		lastName.setBounds(300,120,165,25);
		lastName.setText("Last Name: ");
		panel.add(lastName);
		userTextLastName = new JTextField();
		userTextLastName.setBounds(300,140,165,25);
		panel.add(userTextLastName);
		
		courses = new JLabel();
		courses.setBounds(300,170,170,25);
		courses.setText("Courses(comma separated): ");
		panel.add(courses);
		userTextCourses = new JTextField();
		userTextCourses.setBounds(300,190,165,25);
		panel.add(userTextCourses);
		
		readButton = new JButton("Add Student");
		readButton.setBounds(315, 230, 150, 30);
		readButton.addActionListener(this);
		panel.add(readButton);
		
		finalButton = new JButton("Finalize List");
		finalButton.setBounds(335, 280, 130, 30);
		finalButton.addActionListener(this);
		panel.add(finalButton);
		
		studentsInList = new JLabel();
		studentsInList.setBounds(335, 320,165,25);
		studentsInList.setText("");
		panel.add(studentsInList);
		
		frame.setVisible(true);

	}
	public void createGUI(List<Student> listOfStudents) {
		new MyGUI(listOfStudents);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == deserializeButton) {
		DeserializeFile b = new DeserializeFile();
		outputOfFile.setText(b.readFromFileDeserialized(students));
		studentsInList.setText("");
		}
		else if(e.getSource() == readButton) {
			try {
			int ID = Integer.parseInt(userTextStudentNumber.getText());
			String fName = userTextFirstName.getText();
			String lName = userTextLastName.getText();
			List<String> courseList = Arrays.asList(userTextCourses.getText().split(","));
			
			Student a = new Student(ID, fName, lName, courseList);
			students.add(a);
			
			userTextStudentNumber.setText("");
			userTextFirstName.setText("");
			userTextLastName.setText("");
			userTextCourses.setText("");
			studentsAdded++;
			studentsInList.setText(studentsAdded + "Student(s) added to list.");
			}catch(NumberFormatException ex) {
				studentsInList.setText("Invalid Input(s)");
			}
			
		}
		else if(e.getSource() == finalButton) {
			EnterStudentInformation a = new EnterStudentInformation();
			a.writeToFileSerialised(students);
			studentsInList.setText("List serialized!");
		}
		
	}
}
