package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import za.ac.cput.domain.Address;
import za.ac.cput.domain.BillingAddress;

import za.ac.cput.util.Helper;



public class BillingAddressFactory {


    public static Address buildBillingAddress (String paymentMethod, String street , String suburb, String postalCode, String city ) {
        if (Helper.isStringNullorEmpty(street) || Helper.isStringNullorEmpty(suburb) || Helper.isInvalidPostalCode(postalCode) ||
                Helper.isStringNullorEmpty(city) || Helper.isStringNullorEmpty(paymentMethod)) {
            return null;
        }
        return new BillingAddress.BillingAddressBuilder().
                setPaymentMethod(paymentMethod).
                setStreet(street).
                setSuburb(suburb).
                setPostalCode(postalCode).
                setCity(city).
                build();

    }

}
