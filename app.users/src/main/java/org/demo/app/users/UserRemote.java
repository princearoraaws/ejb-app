package org.demo.app.users;

import javax.ejb.Remote;

@Remote
public interface UserRemote {
	public String getUserDetails();
}
