package database_testing_practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToMysql {
public static void main(String[] args) {
	Connection conn=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		
		if(conn==null)
		{
			System.out.println("unable to connect to mysql");
		}
		else
		{
			System.out.println("connected successfully to mysql");
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
}
