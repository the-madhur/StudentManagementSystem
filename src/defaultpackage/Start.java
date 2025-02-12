package defaultpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.out.println("Welcome to Student Managemnt System");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Update Student");
			
			System.out.println("Press 5 to exit app");
			
			int c =Integer.parseInt(br.readLine());
			
			if(c==1)
			{
				// add student
				System.out.println("Enter user name: ");
				String name = br.readLine();
				System.out.println("Enter user phone: ");
				String phone = br.readLine();
				System.out.println("Enter user city: ");
				String city = br.readLine();
				
				// Create Student object to store Student class
				Student st = new Student (name, phone, city);
				
				boolean answer = StudentDao.insertStudentToDB(st);  // connect with StudentDao
				if(answer)
				{
					System.out.println("Student added successfully");
				}
				else
				{
					System.out.println("Something went wrong try again....");
				}
				
				System.out.println(st);
						
			}
			else if(c==2)
			{
				// delete student
				System.out.println("Enter Student id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f)
				{
					System.out.println("Deleted....");
				}
				else
				{
					System.out.println("Something went wrong try again....");
				}
			}
			else if(c==3)
			{
				// display student
				StudentDao.showAllStudent();
			}
			else if(c==4)
			{
                 //update student
				
				boolean f;
				
				System.out.println("Enter Student Id which you want to update");
				int st_id=Integer.parseInt(br.readLine());
				
				System.out.println("Enter Student Name :");
				String st_name=br.readLine();
				
				System.out.println("Enter Student Phone :");
				String st_phone=br.readLine();
				
				System.out.println("Enter Student City :");
				String st_city=br.readLine();
				
				try {
					StudentDao.updateStudent(st_id, st_name, st_phone, st_city);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(f=true) {
					System.out.println("Student updated successfully..\n");
				}
				else {
					System.out.println("Something went wrong .. please try again..\n");
				}

			}
			else if(c==5)
			{
				// exit
				break;
			}
			else 
			{
				
			}
			
		}
		System.out.println("Thank you for using my Application");
		System.out.println("See you soon Bye Bye....");
	}

}
