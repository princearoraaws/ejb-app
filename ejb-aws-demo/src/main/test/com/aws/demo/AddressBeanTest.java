package com.aws.demo;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddressBeanTest {

	public static void main(String[] args) throws NamingException {
        AddressBeanRemote address = EJBFactory
          .createAddressBeanFromJNDI("ejb:");
        
        String houseNumber="403";
        String society="parkstreet";
        String locality="wakad";
        String city="pune";
        String state="maharashtra";
        String pinCode="411055";
        
        GeographicAddress geoAdd = new GeographicAddress();
        
        
        geoAdd.setHouseNumber(houseNumber);
        geoAdd.setSociety(society);
        geoAdd.setLocality(locality);
        geoAdd.setCity(city);
        geoAdd.setState(state);
        geoAdd.setPinCode(pinCode);
        try {
        System.out.print("Creating address = "+address.createAddress(geoAdd));
        
        
        System.out.print("Retrieving address ="+address.retrieveAddress());
        }
        catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	

    private static class EJBFactory {

        private static AddressBeanRemote createAddressBeanFromJNDI
          (String namespace) throws NamingException {
            return lookupAddressBean(namespace);
        }

        private static AddressBeanRemote lookupAddressBean
          (String namespace) throws NamingException {
            Context ctx = createInitialContext();
			/*
			 * Properties p = (Properties) ctx.getEnvironment();
			 * System.out.println("java.naming.provider.url="+p.get(
			 * "java.naming.provider.url"));
			 * System.out.println("remote.connection.default.username"+p.get(
			 * "remote.connection.default.username"));
			 */
            String appName = "";
            String moduleName = "ejb-aws-demo";
            String distinctName = "";
            String beanName = AddressBean.class.getSimpleName();
            String viewClassName = AddressBeanRemote.class.getName();
            System.out.println("lookupAddressBean ===== "+namespace 
              + appName + "/" + moduleName 
              + "/" + beanName + "!" + viewClassName);
           // return (AddressBeanRemote) ctx.lookup("ejb:/ejb-aws-demo/AddressBean!com.aws.demo.AddressBeanRemote");
            return (AddressBeanRemote) ctx.lookup(namespace 
              + appName + "/" + moduleName 
              +  "/" + beanName + "!" + viewClassName);
        }

        private static Context createInitialContext() throws NamingException {
            Properties jndiProperties = new Properties();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, 
              "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProperties.put(Context.URL_PKG_PREFIXES, 
              "org.jboss.ejb.client.naming");
            jndiProperties.put(Context.PROVIDER_URL, 
               "http-remoting://176.34.146.5:8080");
            jndiProperties.put("jboss.naming.client.ejb.context", true);
            return new InitialContext(jndiProperties);
        }
    }
}
