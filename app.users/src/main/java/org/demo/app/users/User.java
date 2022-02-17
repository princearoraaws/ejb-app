package org.demo.app.users;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Session Bean implementation class CustomerAddress
 */
@Stateless
@LocalBean
@WebService
public class User implements UserRemote, UserLocal {

    /**
     * Default constructor. 
     */
    public User() {
    }

	@Override
	public String getUserDetails() {
		return "Pune";
	}
    
    
    

}
