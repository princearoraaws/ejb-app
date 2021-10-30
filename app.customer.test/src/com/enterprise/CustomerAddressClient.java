package com.enterprise;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CustomerAddressClient {

	private static Context initialContext;
	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	public static void main(String[] args) throws NamingException {
		CustomerAddressRemote bean = doLookup();
		System.out.println(bean.getCustomerAddress()); // 4. Call business logic
	}

	private static CustomerAddressRemote doLookup() {
		Context context = null;
		CustomerAddressRemote bean = null;
		try {
			// 1. Obtaining Context
			context = getInitialContext();
			// 2. Generate JNDI Lookup name
			String lookupName = getLookupName();
			// 3. Lookup and cast
			bean = (CustomerAddressRemote) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			jndiProperties.put("jboss.naming.client.ejb.context", true);
			initialContext = new InitialContext(jndiProperties);
		}
		return initialContext;
	}

	private static String getLookupName() {
		/*
		 * The app name is the EAR name of the deployed EJB without .ear suffix. Since
		 * we haven't deployed the application as a .ear, the app name for us will be an
		 * empty string
		 */
		String appName = "";

		/*
		 * The module name is the JAR name of the deployed EJB without the .jar suffix.
		 */
		String moduleName = "app.customer";

		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This can be
		 * an empty string if distinct name is not specified.
		 */
		String distinctName = "";

		// The EJB bean implementation class name
		String beanName = CustomerAddress.class.getSimpleName();

		// Fully qualified remote interface name
		final String interfaceName = CustomerAddressRemote.class.getName();

		// Create a look up string name
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		System.out.println("name is =" + name);
		return name;
	}

}
