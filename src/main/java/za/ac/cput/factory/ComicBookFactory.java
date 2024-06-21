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
    public static ComicBook buildBuilder(String sku, String name, double wieght, LocalDate releaseDate, List<Author> authors, Publisher publisher, double price) {
        if (Helper.isStringNullorEmpty(sku) || Helper.isStringNullorEmpty(name) || wieght <= 0.0 || Helper.isValidDate(releaseDate) || Helper.isListNullorEmpty(authors) || publisher==null|| price <= 0.0) {

            return null;
        }

        return new ComicBook.ComicBookBuilder().setSKU(sku)
                .setName(name)
                .setWieght(wieght)
                .setReleaseDate(releaseDate)
                .setAuthor(authors)
                .setPublisher(publisher)
                .setPrice(price)
                .build();
    }
}