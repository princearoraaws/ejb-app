package com.enterprise;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Session Bean implementation class CustomerAddress
 */
@Stateless
@LocalBean
@WebService
public class CustomerAddress implements CustomerAddressRemote, CustomerAddressLocal {

    /**
     * Default constructor. 
     */
    public CustomerAddress() {
    }

	@Override
	public String getCustomerAddress() {
		return "Pune";
	}
    
    
    

}
