package za.ac.cput.factory;

import za.ac.cput.domain.*;

import za.ac.cput.util.Helper;

public class CustomerContactFactory {

    public static Contact buildContact(String emailAddress, String phoneNumber, Address shippingAddress, Address billingAddress){

        if(Helper.isEmailValid(emailAddress) || Helper.isNumber10Digits(phoneNumber) || Helper.isObjectNull(shippingAddress) || Helper.isObjectNull(billingAddress)){
            return null;
        }
        return new CustomerContact.CustomerContactBuilder()
                .setBillingAddress((BillingAddress) billingAddress)
                .setShippingAddress((ShippingAddress) shippingAddress)
                .setEmail(emailAddress)
                .setMobile(phoneNumber)
                .build();
    }
}
