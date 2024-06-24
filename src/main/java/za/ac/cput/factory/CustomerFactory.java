package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;


public class CustomerFactory {
    public static Customer buildCustomer(long customerId, String firstName,String middleName, String lastName, String password, Contact contact){
        if(customerId<=0 || Helper.isStringNullorEmpty(firstName)|| Helper.isStringNullorEmpty(middleName)
                || Helper.isStringNullorEmpty(lastName) || Helper.isStringNullorEmpty(password) ||
                contact == null
        ){

            return null;
        }
        Name name = new Name.NameBuilder().setFirstName(firstName)
                .setLastName(lastName)
                .setMiddleName(middleName)
                .build();
        return new Customer.CustomerBuilder()
                .setCustomerId(customerId)
                .setName(name)
                .setPassword(password)
                .setContact(contact)
                .build();
    }
    public static Customer buildCustomer(long customerId, String firstName, String lastName, String password, Contact contact){
        if(customerId<=0 || Helper.isStringNullorEmpty(firstName)
                || Helper.isStringNullorEmpty(lastName) || Helper.isStringNullorEmpty(password) ||
                contact == null
        ){

            return null;
        }
        Name name = new Name.NameBuilder().setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return new Customer.CustomerBuilder()
                .setCustomerId(customerId)
                .setName(name)
                .setPassword(password)
                .setContact(contact)
                .build();
    }
}

