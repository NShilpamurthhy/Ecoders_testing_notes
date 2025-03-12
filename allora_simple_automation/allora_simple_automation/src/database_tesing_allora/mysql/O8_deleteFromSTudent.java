package database_tesing_allora.mysql;

import java.sql.*;
import java.util.Scanner;

public class O8_deleteFromSTudent {

	public static void main(String[] args) 
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders" , "root" , "root");
			
			if(conn == null)
			{
				System.out.println("Unable to connect to mysql");
			}
			else
			{
				System.out.println("Connected successfully to mysql.");
				// sql statement to show all the databases. 
				PreparedStatement ps = conn.prepareStatement("delete from  student where id = ?");
				
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the id, you want to delete.");
				int id = sc1.nextInt();
				
				ps.setInt(1,  id);
			    int rs = ps.executeUpdate();   // executeUpdate();
			    
				
			
				if(rs > 0)
				{
					System.out.println("deletion successfully.");
				}
				else
				{
					System.out.println("Unable to delete the table.");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}