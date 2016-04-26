package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.FromAddress;

public class FromAddressImpl implements FromAddress {

    private String phoneNumber;

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
