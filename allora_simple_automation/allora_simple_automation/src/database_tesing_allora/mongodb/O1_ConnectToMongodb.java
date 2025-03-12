package database_tesing_allora.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class O1_ConnectToMongodb {
	public static void main(String[] args)
	{
		try (MongoClient conn = MongoClients.create("mongodb://localhost:27017"))
		{
			if(conn!=null)
			{
				System.out.println("connection successfull");
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
