package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import za.ac.cput.domain.Address;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.util.Helper;

import java.time.LocalTime;



public class ShippingAddressFactory {

    public static Address buildShippingAddress (LocalTime prefferedDeliveryTime, String street , String suburb, String postalCode, String city ) {
        if (Helper.isInvalidTime(prefferedDeliveryTime)|| Helper.isStringNullorEmpty(street) || Helper.isStringNullorEmpty(suburb) ||
                Helper.isInvalidPostalCode(postalCode) || Helper.isStringNullorEmpty(city))

       return null;

        return  new ShippingAddress.ShippingAddressBuilder().
                setPreffered_delivery_time(prefferedDeliveryTime).
                setStreet(street).
                setSuburb(suburb).
                setCity(city).
                setPostalCode(postalCode).
                build();

    }

}
