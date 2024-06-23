package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class AdminFactory {


    public static Admin buildAdmin(Long employeeId, String firstName, String middleName, String lastName, String password, Contact adminContact) {
        if (employeeId <= 0 || Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(middleName) || Helper.isStringNullorEmpty(lastName) || Helper.isStringNullorEmpty(password) || Helper.isObjectNull(adminContact)) {
            return null;
        }
        Name name = new Name.NameBuilder().setFirstName(firstName).setMiddleName(middleName).setLastName(lastName).build();

        return new Admin.AdminBuilder().setEmployeeId(employeeId)
                .setContact(adminContact)
                .setPassword(password)
                .setName(name)
                .build()
                ;
    }


    public static Admin buildAdmin(Long employeeId, String firstName, String lastName, String password, Contact contact) {
        if (employeeId <= 0 || Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(lastName) || Helper.isStringNullorEmpty(password) || Helper.isObjectNull(contact)) {
            return null;
        }
        Name name = new Name.NameBuilder().
                setFirstName(firstName).
                setLastName(lastName).
                build();

        return new Admin.AdminBuilder().setEmployeeId(employeeId)
                .setContact(contact)
                .setPassword(password)
                .setName(name)
                .build()
                ;

    }
}

