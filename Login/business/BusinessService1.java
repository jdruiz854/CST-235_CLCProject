package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class BusinessService1
 */
@Alternative
@Stateless
@Local(BusinessServiceInterface.class)
@LocalBean
public class BusinessService1 implements BusinessServiceInterface {

    /**
     * Default constructor. 
     */
    public BusinessService1() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see BusinessServiceInterface#validateNewUser()
     */
    public String validateNewUser() {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see BusinessServiceInterface#validateUserAndPassword()
     */
    public String validateUserAndPassword() {
        // TODO Auto-generated method stub
			return null;
    }

}
