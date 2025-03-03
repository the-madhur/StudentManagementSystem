package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao 
{
	public static boolean insertStudentToDB(Student st)
	{
		boolean f = false;
		try
		{
			// jdbc ka code
			
			Connection con = CP.createC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			// Prepared Statement
			
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			// execute
			pstmt.executeUpdate();
			f = true;  // sabkuch shi hua to true vrna false update 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}

	public static boolean deleteStudent(int userId) 
	{
		boolean f = false;
		try
		{
			// jdbc ka code
			
			Connection con = CP.createC();
			String q = "delete from students where sid=?";
			// Prepared Statement
			
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameter
			pstmt.setInt(1, userId);
			
			// execute
			pstmt.executeUpdate();
			f = true;  // sabkuch shi hua to true vrna false update 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
		
	}

	public static void showAllStudent() {
		boolean f = false;
		try
		{
			// jdbc ka code
			
			Connection con = CP.createC();
			String q = "select * from students";
			
			// create statement
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				System.out.println("City: "+city);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

        public static boolean updateStudent(int st_id, String st_name, String st_phone, String st_city) throws SQLException {
		
		boolean f;
		
		Connection con=CP.createC();
		
		String qr="update students set sname=?, sphone=?, scity=? where sid=?";
		
		PreparedStatement pstm=con.prepareStatement(qr);
		
		pstm.setString(1,st_name);
		pstm.setString(2,st_phone);
		pstm.setString(3,st_city);
		pstm.setInt(4, st_id);
		
		pstm.executeUpdate();
		
		f=true;
		return f;
		
	}

}
