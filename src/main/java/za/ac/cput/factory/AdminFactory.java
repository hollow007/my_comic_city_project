package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class AdminFactory {


    public static Admin buildAdmin(String firstName, String middleName, String lastName, String password, Contact adminContact) {
        if ( Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(middleName) || Helper.isStringNullorEmpty(lastName) || Helper.isStringNullorEmpty(password) || Helper.isObjectNull(adminContact)) {
            return null;
        }
        Name name = new Name.NameBuilder().setFirstName(firstName).setMiddleName(middleName).setLastName(lastName).build();

        return new Admin.AdminBuilder()
                .setContact(adminContact)
                .setPassword(password)
                .setName(name)
                .build()
                ;
    }


    public static Admin buildAdmin(String firstName, String lastName, String password, Contact contact) {
        if ( Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(lastName) || Helper.isStringNullorEmpty(password) || Helper.isObjectNull(contact)) {
            return null;
        }
        Name name = new Name.NameBuilder().
                setFirstName(firstName).
                setLastName(lastName).
                build();

        return new Admin.AdminBuilder()
                .setContact(contact)
                .setPassword(password)
                .setName(name)
                .build()
                ;

    }
}

