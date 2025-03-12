package database_tesing_allora.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class O2_Show_all_DataBases {
	public static void main(String[] args)
	{
		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017"))
		{
			if(conn!=null)
			{
				System.out.println("connection successfull");
				
	            MongoIterable<String> all_databases = conn.listDatabaseNames();
	            
	            if(all_databases!=null)
	            {
	            	System.out.println("All databases are: ");
	            	for(String eachdatabasse:all_databases)
		            {
		            	System.out.println(eachdatabasse);
		            }
	            }
	            else 
	            {
	            	System.out.println("no databases available");
	            }
			
			}
			else
			{
				System.out.println("unable to connect");
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}

	}
}
