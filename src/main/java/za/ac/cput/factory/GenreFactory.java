package za.ac.cput.factory;

import za.ac.cput.domain.Author;
import za.ac.cput.domain.Genre;
import za.ac.cput.domain.Name;
import za.ac.cput.exception.InvalidArgumentException;
import za.ac.cput.util.Helper;

public class GenreFactory {
    public static Genre buildGenre(String name) {

        if (Helper.isStringNullorEmpty(name)) {
            throw new InvalidArgumentException("Name cannot be null or empty");
        }

        return new Genre.Builder()
                .setName(name)
                .build();
    }

}
