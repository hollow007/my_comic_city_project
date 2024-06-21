package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project

import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Publisher;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

public class ComicBookFactory {
    public static ComicBook bookBuilder(String name, String genre, String description, String ISBN, double price, double weight,
                                        int quantity, List<Author> authors, Publisher publisher,  LocalDate releaseDate, byte[] photo) {
        if ( Helper.isStringNullorEmpty(name) || weight <= 0 || Helper.isValidDate(releaseDate) || Helper.isListNullorEmpty(authors)
                || Helper.isObjectNull(publisher)|| price <= 0 || Helper.isStringNullorEmpty(description)|| Helper.isStringNullorEmpty(ISBN)
                || Helper.isStringNullorEmpty(genre) || Helper.isArrayNullOrEmpty(photo)){

            return null;
        }

        return new ComicBook.Builder()
                .setName(name)
                .setWeight(weight)
                .setReleaseDate(releaseDate)
                .setAuthors(authors)
                .setPublisher(publisher)
                .setPrice(price)
                .setCategory(genre)
                .setISBN(ISBN)
                .setDescription(description)
                .setQuantity(quantity)
                .setPhoto(photo)
                .build();

    }
}