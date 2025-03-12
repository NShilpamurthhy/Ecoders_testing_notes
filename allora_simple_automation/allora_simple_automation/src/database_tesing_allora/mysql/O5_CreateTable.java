package database_tesing_allora.mysql;

import java.sql.*;

public class O5_CreateTable {

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
				PreparedStatement ps = conn.prepareStatement("create table if not exists student (id int(45) auto_increment primary key, name varchar(100) , address varchar(100))");
				
			    int rs = ps.executeUpdate();   // executeUpdate();
				
			
				if(rs==0)
				{
					System.out.println("table created successfully.");
				}
				else
				{
					System.out.println("Unable to create table.");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}