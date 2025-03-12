package database_tesing_allora.mysql;

import java.sql.*;

public class O4_ShowEmpTable {

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
				PreparedStatement ps = conn.prepareStatement("select * from student");
				
				ResultSet rs = ps.executeQuery();   // executeUpdate();
				
				System.out.println("id || name || Address");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+ rs.getString(2) + " " + rs.getString(3));
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}