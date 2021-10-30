package com.enterprise;

import javax.ejb.Remote;

@Remote
public interface CustomerAddressRemote {
	public String getCustomerAddress();
}
