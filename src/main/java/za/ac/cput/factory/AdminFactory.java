package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class AdminFactory {



    public static Admin buildAdmin(String firstName, String  middleName,  String lastName, String password){


        if(Helper.isStringNullorEmpty(firstName)||Helper.isStringNullorEmpty(lastName)
                ||Helper.isStringNullorEmpty(middleName)||Helper.isStringNullorEmpty(password))
              throw new IllegalStateException ("bad object: Object Null");
        return new Admin.AdminBuilder()
                .setName(firstName,middleName,lastName)
                .setPassword(password)
                .build();
    }



    public static Admin buildAdmin(String firstName, String lastName, String password){


        if(Helper.isStringNullorEmpty(firstName)||Helper.isStringNullorEmpty(password)||Helper.isStringNullorEmpty(lastName))
            throw new IllegalStateException("bad object: Object Null");
        return new Admin.AdminBuilder()
                .setFName(firstName)
                .setLName(lastName)
                .setPassword(password)
                .build();
    }
    }

