package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class studentDao {
	
	public static boolean insertStudentToDB(Student st) throws ClassNotFoundException, SQLException {
		
		boolean f = false;
		//jdbc code..
		Connection con = CP.createC();
		String q = "insert into students(sname,sphone,scity) values(?,?,?)";
		
		//prepared statment 
		PreparedStatement pstmt =con.prepareStatement(q);
	
		//set the values of parameters
		pstmt.setString(1, st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.setString(3, st.getStudentCity());
		
		//execute
		pstmt.executeUpdate();

		f=true;
		
		return f;
	}

	public static boolean deleteStudent(int userID) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean f = false;
		//jdbc code..
		Connection con = CP.createC();
		String q = "delete from students where sid=?";
		
		//prepared statment 
		PreparedStatement pstmt =con.prepareStatement(q);
	
		//set the values of parameters
		pstmt.setInt(1, userID);
		
		//execute
		pstmt.executeUpdate();

		f=true;
		
		return f;

		
	}

	public static boolean showAllStudents() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		boolean f = false;
		//jdbc code..
		Connection con = CP.createC();
		String q = "select * from students";
		
		Statement stmt =  con.createStatement();
		
		ResultSet set = stmt.executeQuery(q);
		
		while(set.next()) {
			
			int id = set.getInt(1);
			String name = set.getString(2);
			String phone = set.getString(3);
			String city = set.getString("scity");
			
			System.out.println("ID : " + id);
			System.out.println("name : " + name);
			System.out.println("phone : " + phone);
			System.out.println("city : " + city);
			System.out.println("++++++++++++++++++++++++++++++++++");
			
			
		}
		
		f=true;
		
		return f;
		
	}

}
