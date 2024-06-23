package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class AdminContactFactory {
    public static Contact buildContact(String emailAddress, String phoneNumber, Address address){

        if(Helper.isEmailValid(emailAddress) || Helper.isNumber10Digits(phoneNumber) || Helper.isObjectNull(address)){
            return null;
        }
        return new AdminContact.AdminContactBuilder()
                .setAddress(address)
                .setEmail(emailAddress)
                .setMobile(phoneNumber)
                .build();
    }
}
