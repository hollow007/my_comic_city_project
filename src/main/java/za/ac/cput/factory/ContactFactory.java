package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
//

import za.ac.cput.domain.BillingAdress;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.util.Helper;

public class ContactFactory {
    public static Contact buildContact(String emailAddress, String phoneNumber, ShippingAddress shippingAddress, BillingAdress billingAdress){

        if(Helper.isEmailValid(emailAddress) || Helper.isNumber10Digits(phoneNumber) || Helper.isObjectNull(shippingAddress) || Helper.isObjectNull(billingAdress)){
            return null;
        }
        return new Contact.ContactBuilder().setEmail(emailAddress)
                .setMobile(phoneNumber)
                .setBillingAdress(billingAdress)
                .setShippingAddress(shippingAddress)
                .build();

    }

}
