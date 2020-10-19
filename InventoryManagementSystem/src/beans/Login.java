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
	public String validateUserAndPassword()
	{
		
		boolean valid = DatabaseValidation.check(this.username, this.password);
		if(valid)
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
	
	public String validateNewUser()
	{
		System.out.println("Hello new user");
		boolean valid = DatabaseValidation.checkNewUser(this.username, this.password);
		System.out.println("After db valid");
		if (valid)
		{
			System.out.println("true");
			return "success";
		}
		else
		{
			System.out.println("false");
			return "register";
		}
	}
}