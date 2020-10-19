package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Creation;
import beans.Login;
import database.DatabaseValidation;

/**
 * Session Bean implementation class BusinessService1
 */
@Alternative
@Stateless
@Local(BusinessServiceInterface.class)
public class BusinessService1 implements BusinessServiceInterface 
{
	Login users = new Login();
	
    /**
     * Default constructor. 
     */
    public BusinessService1() 
    {
       
    }

	/**
     * @see BusinessServiceInterface#validateNewUser()
     */
    public String validateNewUser() 
    {
    	System.out.println("Hello new user");
		boolean valid = DatabaseValidation.checkNewUser(users.getUsername(), users.getPassword());
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

	/**
     * @see BusinessServiceInterface#validateUserAndPassword()
     */
    public String validateUserAndPassword() 
    {
    	boolean valid = DatabaseValidation.check(users.getUsername(), users.getPassword());
		if(valid)
		{
			return "success";
		}
		else
		{
			return "failure";
		}
    }

}