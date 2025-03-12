package database_tesing_allora.mysql;

import java.sql.*;

public class O2_ShowAllTablesInDatabases {

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
				PreparedStatement ps = conn.prepareStatement("show tables");
				
				ResultSet rs = ps.executeQuery();   // executeUpdate();
				
				System.out.println("All tables from ecoders database.");
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