package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project


import za.ac.cput.domain.Author;
import za.ac.cput.domain.Name;
import za.ac.cput.util.Helper;

public class AuthorFactory {
    public static Author buildAuthor(long authorID, String firstName, String middleName , String lastName){
        Name name;

        if(authorID <= 0 || Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(lastName)){
            return null;
        }

        name = new Name.NameBuilder().setFirstName(firstName)
                .setLastName(lastName)
                .setMiddleName(middleName)
                .build();
        return new Author.AuthorBuilder().setAuthorID(authorID)
                .setName(name)
                .build();
    }
    public static Author buildAuthor(long authorID, String firstName, String lastName){
        Name name;

        if(authorID <= 0 || Helper.isStringNullorEmpty(firstName) || Helper.isStringNullorEmpty(lastName)){
            return null;
        }

        name = new Name.NameBuilder().setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return new Author.AuthorBuilder().setAuthorID(authorID)
                .setName(name)
                .build();
    }



}
