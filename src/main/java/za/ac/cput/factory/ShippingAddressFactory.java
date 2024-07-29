package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import za.ac.cput.domain.Address;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.util.Helper;

import java.time.LocalTime;



public class ShippingAddressFactory {

    public static ShippingAddress buildShippingAddress (LocalTime preferredDeliveryTime, String street , String suburb, String postalCode, String city ) {
        if (!Helper.isInvalidTime(preferredDeliveryTime)|| Helper.isStringNullorEmpty(street) || Helper.isStringNullorEmpty(suburb) ||
                Helper.isInvalidPostalCode(postalCode) || Helper.isStringNullorEmpty(city))

       return null;

        return new ShippingAddress.ShippingAddressBuilder().
                setPreffered_delivery_time(preferredDeliveryTime).
                setStreet(street).
                setSuburb(suburb).
                setPostalCode(postalCode).
                setCity(city).
                build();

    }

}
