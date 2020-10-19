package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

//placeholder hashmap used to validate username and passwrod. defaulted with one entry, however will be changed to validate against database with registration information input.
public class DatabaseValidation
{
	
	private static HashMap<String, String> hash = new HashMap<String, String>();
	
	//adds user to the hashmap
	public void addUser(String username, String password)
	{
		hash.put("JoshRuiz", "Josh1234");
	}
	
	//checks to see if the login entries match what is in the hashmap and returns true or false based on the entries
	public static boolean check(String username, String password)
	{
		if(!hash.containsKey(username))
		{
			return false;
		}
		else
		{
			String storedPassword = hash.get(username);
			return password.equals(storedPassword);
		}
		
	}
	
	public static boolean checkNewUser(String u, String p)
	{
		if(hash.containsKey(u))
		{
			return false;
		}
		else
		{
			hash.put(u, p);
			return true;
		}
	}
}