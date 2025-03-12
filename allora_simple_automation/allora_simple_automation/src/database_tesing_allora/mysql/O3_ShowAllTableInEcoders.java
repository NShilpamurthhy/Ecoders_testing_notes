package database_tesing_allora.mysql;

import java.sql.*;

public class O3_ShowAllTableInEcoders {

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
				// sql statement to show all the databases. 
				PreparedStatement ps = conn.prepareStatement("show databases");
				
				ResultSet rs = ps.executeQuery();   // executeUpdate();
				
				while(rs.next())
				{
					System.out.println(rs.getString(1));
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}