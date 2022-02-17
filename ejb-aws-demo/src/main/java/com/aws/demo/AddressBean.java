package com.aws.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AddressBean
 */
@Stateless
@LocalBean
public class AddressBean implements AddressBeanRemote {

	Map<String, String> addressMap;


	public AddressBean() {
		addressMap = new HashMap<>();
	}

	@Override
	public String retrieveAddress() throws Exception {
		
		String houseNumber = addressMap.get("houseNumber");
		String society =addressMap.get("society");
		String locality =addressMap.get("locality");
		String city =addressMap.get("city");
		String state =addressMap.get("state");
		String pinCode =addressMap.get("pinCode");
		
		return "\n"+"houseNumber="+houseNumber+
				"\n"+"society="+society+
				"\n"+"locality="+locality+
				"\n"+"city="+city+
				"\n"+"state="+state+
				"\n"+"pinCode="+pinCode+
				"\n";

	}

	@Override
	public String createAddress(GeographicAddress address) throws Exception{
		
		
		addressMap.put("houseNumber", address.getHouseNumber());
		addressMap.put("society", address.getSociety());
		addressMap.put("locality", address.getSociety());
		addressMap.put("city", address.getCity());
		addressMap.put("state", address.getState());
		addressMap.put("pinCode", address.getPinCode());
		
		return UUID.randomUUID().toString();
	}

	@Override
	public String deleteeAddress()throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
