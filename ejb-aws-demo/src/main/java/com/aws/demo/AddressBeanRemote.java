package com.aws.demo;

import javax.ejb.Remote;

@Remote
public interface AddressBeanRemote {

    public String retrieveAddress() throws Exception;
    public String createAddress(GeographicAddress address)throws Exception;
    public String deleteeAddress()throws Exception;
}
