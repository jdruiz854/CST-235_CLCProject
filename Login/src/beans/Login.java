package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.DatabaseValidation;

//main login managed bean will take username and password and validate to see if they match the registration information in the database.
@ManagedBean
@SessionScoped
public class Login 
{
	private String username;
	private String password;
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}

	//Validates the username and password entered into the form and returns success or failure depending on the outcome of the check.
	public String validateUserAndPassword(String username, String password)
	{
		
		boolean valid = DatabaseValidation.check(username, password);
		if(valid)
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
	
	public String validateNewUser(String username, String password)
	{
		boolean valid = DatabaseValidation.checkNewUser(username, password);
		if (valid)
		{
			return "success";
		}
		else
		{
			return "register";
		}
	}
}
