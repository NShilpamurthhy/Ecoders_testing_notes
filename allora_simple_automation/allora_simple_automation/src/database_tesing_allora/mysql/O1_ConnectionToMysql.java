package database_tesing_allora.mysql;

import java.sql.*;

public class O1_ConnectionToMysql {

	public static void main(String[] args) 
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306" , "root" , "root");
			
			if(conn == null)
			{
				System.out.println("Unable to connect to mysql");
			}
			else
			{
				System.out.println("Connected successfully to mysql.");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}