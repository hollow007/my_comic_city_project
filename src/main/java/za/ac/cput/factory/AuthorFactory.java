package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project


import za.ac.cput.domain.Author;
import za.ac.cput.domain.Name;
import za.ac.cput.util.Helper;

public class AuthorFactory {
    public static Author buildAuthor(String firstName, String middleName , String lastName){
        Name name;

        if(Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(lastName)){
            return null;
        }

        name = new Name.NameBuilder().setFirstName(firstName)
                .setLastName(lastName)
                .setMiddleName(middleName)
                .build();

        return new Author.AuthorBuilder()
                .setName(name)
                .build();
    }



}
