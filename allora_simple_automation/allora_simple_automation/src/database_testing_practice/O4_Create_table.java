package database_testing_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class O4_Create_table {

	public static void main(String[] args) {
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders","root","root");
			
			if(conn==null) {
				System.out.println("unable to connect to mysql");
			}
			else {
				System.out.println("connection successfull to mysql");
				PreparedStatement ps =conn.prepareStatement("create table if not exists College(id int(4) auto_increment primary key, name varchar(24), Branch varchar(50))");
				int	rs=ps.executeUpdate();
				if(rs==0) {
					System.out.println("table created successfully");
				}
				else
				{
					
					
					
					
					
					
					
					
					
					System.out.println("unable to create table");
				}
			}
			
			
			
		}
		 catch(Exception ex) {
			 ex.printStackTrace();		 }

	}

}
