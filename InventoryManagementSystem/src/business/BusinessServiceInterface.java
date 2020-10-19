package business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Login;

@Stateless
@Local
@Alternative
public interface BusinessServiceInterface 
{
	public String validateUserAndPassword();
	public String validateNewUser();
}