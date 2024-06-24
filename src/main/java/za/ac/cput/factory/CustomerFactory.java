package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.util.List;

public class CustomerFactory {
    public static Customer buildCustomer(long customerId, String firstName, String lastName,String middleName, String password, Contact contact){
        if(customerId<=0 || Helper.isStringNullorEmpty(firstName)
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
}

