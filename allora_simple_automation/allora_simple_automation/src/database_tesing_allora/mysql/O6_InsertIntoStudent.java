package database_tesing_allora.mysql;

import java.sql.*;
import java.util.Scanner;

public class O6_InsertIntoStudent {

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
				PreparedStatement ps = conn.prepareStatement("insert into student ( name ,address) values (? ,?)");
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter a name");
				String name = sc.next();
				
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter a address");
				String address = sc1.next();
				
				ps.setString(1, name);
				ps.setString(2,  address);
			    int rs = ps.executeUpdate();   // executeUpdate();
			    
				
			
				if(rs > 0)
				{
					System.out.println("inserted successfully.");
				}
				else
				{
					System.out.println("Unable to insert into the table.");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}