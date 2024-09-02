package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project

import za.ac.cput.domain.Author;
import za.ac.cput.domain.Name;
import za.ac.cput.exception.InvalidArgumentException;
import za.ac.cput.util.Helper;

public class AuthorFactory {

    public static Author buildAuthor(Long authorID, String firstName, String middleName, String lastName) {
        if (authorID <= 0) {
            throw new InvalidArgumentException("Author ID must be greater than zero");
        }
        if (Helper.isStringNullorEmpty(firstName)) {
            throw new InvalidArgumentException("First name cannot be null or empty");
        }
        if (Helper.isStringNullorEmpty(middleName)) {
            throw new InvalidArgumentException("Middle name cannot be null or empty");
        }
        if (Helper.isStringNullorEmpty(lastName)) {
            throw new InvalidArgumentException("Last name cannot be null or empty");
        }

        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();

        return new Author.AuthorBuilder()
                .setAuthorID(authorID)
                .setName(name)
                .build();
    }

    public static Author buildAuthor(Long authorID, String firstName, String lastName) {

        if (authorID <= 0) {
            throw new InvalidArgumentException("Author ID must be greater than zero");
        }
        if (Helper.isStringNullorEmpty(firstName)) {
            throw new InvalidArgumentException("First name cannot be null or empty");
        }
        if (Helper.isStringNullorEmpty(lastName)) {
            throw new InvalidArgumentException("Last name cannot be null or empty");
        }

        Name name = new Name.NameBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

        return new Author.AuthorBuilder()
                .setAuthorID(authorID)
                .setName(name)
                .build();
    }
}
