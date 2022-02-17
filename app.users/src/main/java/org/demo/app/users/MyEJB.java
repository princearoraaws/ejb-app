package org.demo.app.users;

import javax.ejb.Stateless;

@Stateless
public class MyEJB {

	public String helloWorld(String name) {
		return "Hello " + name;
	}

}
