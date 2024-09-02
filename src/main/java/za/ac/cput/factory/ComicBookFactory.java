package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic_city_project

import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Genre;
import za.ac.cput.domain.Publisher;
import za.ac.cput.exception.InvalidArgumentException;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class ComicBookFactory {

    public static ComicBook bookBuilder(String name, Set<Genre> genres, String description, String ISBN, double price, double weight,
                                        int quantity, List<Author> authors, Publisher publisher, LocalDate releaseDate, byte[] photo) {

        if (Helper.isStringNullorEmpty(name)) {
            throw new InvalidArgumentException("Name cannot be null or empty");
        }
        if (Helper.isSetNullorEmpty(genres)) {
            throw new InvalidArgumentException("Genres cannot be null or empty");
        }
        if (Helper.isStringNullorEmpty(description)) {
            throw new InvalidArgumentException("Description cannot be null or empty");
        }
        if (Helper.isStringNullorEmpty(ISBN)) {
            throw new InvalidArgumentException("ISBN cannot be null or empty");
        }
        if (weight <= 0) {
            throw new InvalidArgumentException("Weight must be greater than zero");
        }
        if (Helper.isValidDate(releaseDate)) {
            throw new InvalidArgumentException("Invalid release date");
        }
        if (Helper.isListNullorEmpty(authors)) {
            throw new InvalidArgumentException("Authors cannot be null or empty");
        }
        if (Helper.isObjectNull(publisher)) {
            throw new InvalidArgumentException("Publisher cannot be null");
        }
        if (price <= 0) {
            throw new InvalidArgumentException("Price must be greater than zero");
        }
        if (Helper.isArrayNullOrEmpty(photo)) {
            throw new InvalidArgumentException("Photo cannot be null or empty");
        }

        return new ComicBook.Builder()
                .setName(name)
                .setWeight(weight)
                .setReleaseDate(releaseDate)
                .setAuthors(authors)
                .setPublisher(publisher)
                .setPrice(price)
                .setGenres(genres)
                .setISBN(ISBN)
                .setDescription(description)
                .setQuantity(quantity)
                .setPhoto(photo)
                .build();
    }
}