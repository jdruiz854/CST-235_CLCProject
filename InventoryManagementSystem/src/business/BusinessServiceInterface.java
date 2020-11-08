package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Creation;
import beans.Login;

@Stateless
@Local
@Alternative
public interface BusinessServiceInterface 
{
	public String validateUserAndPassword();
	public String validateNewUser();
	
}
