package LAb4To5Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializeFile {
	/**
	 * 
	 * @param listOfStudents our list of students which is currently empty and will be built by 
	 * deserializing the file
	 * 
	 */
	public String readFromFileDeserialized(List<Student> listOfStudents) {		
		String myListOfStudents = "";
		try {
		FileInputStream fileIn = new FileInputStream("filename.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		listOfStudents = (List<Student>) in.readObject();
		in.close();
		fileIn.close();
		 System.out.println("Serialized data is read");
			
			for(int i = 0; i < listOfStudents.size(); i++) {
				myListOfStudents = myListOfStudents.concat("Student " + (i+1) + " ID: " + listOfStudents.get(i).getStdID() + "\r\n");
				myListOfStudents = myListOfStudents.concat("Student " + (i+1) + " First Name: " + listOfStudents.get(i).getFirstName() + "\r\n");
				myListOfStudents = myListOfStudents.concat("Student " + (i+1) + " Last Name: " + listOfStudents.get(i).getLastName() + "\r\n");
//				
//				System.out.println("Student " + (i+1) + " ID: " + listOfStudents.get(i).getStdID());
//				System.out.println("Student " + (i+1) + " First Name: " + listOfStudents.get(i).getFirstName());
//				System.out.println("Student " + (i+1) + " Last Name: " + listOfStudents.get(i).getLastName());
			
				for(int j = 0; j < listOfStudents.get(i).courseList.size(); j++) {
					myListOfStudents = myListOfStudents.concat("Student " + (i+1) + " Course " + (j+1) +": " + listOfStudents.get(i).courseList.get(j) + "\r\n");
					//System.out.println("Student " + (i+1) + " Course " + (j+1) +": " + listOfStudents.get(i).courseList.get(j));
				}
				myListOfStudents = myListOfStudents.concat("\r\n");
			}
		 
		}catch(IOException i) {
			 System.out.println("ooga booga no file");
			 return "-1";
		}catch(ClassNotFoundException c) {
			System.out.println("ooga booga no object");
			return "-1";
		}
		//System.out.println(myListOfStudents);
	return(myListOfStudents);
	}
}

