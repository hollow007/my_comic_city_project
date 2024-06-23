package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public Address buildAddress (String street, String suburb, String postalCode, String city ){
        if(Helper.isStringNullorEmpty(street) || Helper.isStringNullorEmpty(suburb) ||
                Helper.isInvalidPostalCode(postalCode) || Helper.isStringNullorEmpty(city))

        throw new IllegalStateException("bad object : Null object");
        return new Address.AddressBuilder().
                setStreet(street).
                setSuburb(suburb).
                setPostalCode(postalCode).
                setCity(city).
                build();

    }
}
