package com.enterprise;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CustomerAddress
 */
@Stateless
@LocalBean
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
