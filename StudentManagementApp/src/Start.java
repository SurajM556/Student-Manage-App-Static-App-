import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.student.manage.Student;
import com.student.manage.studentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Stuednt Management App . . ."); 
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
		System.out.println("PRESS 1 FOR ADD STUDENT: ");
		System.out.println("PRESS 2 FOR DELETEE STUDENT: ");
		System.out.println("PRESS 3 FOR DISPLAY STUDENT: ");
		System.out.println("PRESS 4 FOR EXIT APP : ");
		
		int c = Integer.parseInt(rd.readLine());
		
		if(c==1) {
			//add student
			System.out.println("Enter User Name: ");
			String name = rd.readLine();
			
			System.out.println("Enter User Phone: ");
			String phone = rd.readLine();
			
			System.out.println("Enter User City: ");
			String city = rd.readLine();
			
			//create student  object to store student
			Student st = new Student(name , phone , city);
			Boolean answer = studentDao.insertStudentToDB(st);
			
			if(answer) {
				System.out.println("Student is Added successfully . . .");
			}else {
				System.out.println("something went wrong try again...");
			}
			System.out.println(st);
			
			
		}
		else if(c==2) {
			//delete student
			System.out.println("Enter Student ID to delete student: ");
			int userID = Integer.parseInt(rd.readLine());
			Boolean f = studentDao.deleteStudent(userID); 
			if(f) {
				System.out.println("Student delete Successfully . . .");
			}else {
				System.out.println("Something went wrong try again . . .");
			}
		}
		else if(c==3) {
			//display student
			boolean g =studentDao.showAllStudents();
			if(g) {
				System.out.println("This is student data.........");
			}
			else {
				System.out.println("Somthing went wrong.....");
			}
		}
		else if(c==4) {
			//exit app
			break;
		}
		else {
			// wrong choice
		}

		}
		
		System.out.println("Thank you for using my appliation...");
		System.out.println("See you soon ... ");
	}

}
