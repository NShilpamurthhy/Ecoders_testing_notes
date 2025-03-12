package database_tesing_allora.mysql;

import java.sql.*;
import java.util.Scanner;

public class O7_updateSTudentTable {

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
				PreparedStatement ps = conn.prepareStatement("update student set name = ? where id = ?");
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter a name");
				String name = sc.nextLine();
				
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the id for whom you want to update.");
				int id = sc1.nextInt();
				
				ps.setString(1, name);
				ps.setInt(2,  id);
			    int rs = ps.executeUpdate();   // executeUpdate();
			    
				
			
				if(rs > 0)
				{
					System.out.println("updation successfully.");
				}
				else
				{
					System.out.println("Unable to update the table.");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}