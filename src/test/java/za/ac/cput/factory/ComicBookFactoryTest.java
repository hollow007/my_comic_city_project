package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ComicBookFactoryTest {
    private ComicBook book1;
    private Author author1;
    private Author author2;
    private List<Author> authors;
    private ComicBook book2;
    private ComicBook book3;

    @BeforeEach
    void setUp() {
        author1 = AuthorFactory.buildAuthor(001, "Lamark", "", "Darwin");
        author2 = AuthorFactory.buildAuthor(002, "Jacob", "Gedleyihlekisa", "Zuma");

        authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        book1 = ComicBookFactory.buildBuilder("CMB01", "Thor", 3.4, LocalDate.now(), authors, 300.00);
        book2 = ComicBookFactory.buildBuilder("CMB02", "Hulk", 3.4, LocalDate.of(2024,07,17), authors, 300.00);
        book3 = ComicBookFactory.buildBuilder("CMB03", "Spider-Man", 3.4, LocalDate.now(), authors, -1);

    }

    @Test
    void buildBuilder() {
        assertNotNull(book1);
        System.out.println(book1);

    }

    @Test
    void buildBuilderWithFutureDateMustFail() {
        assertNull(book2);
        System.out.println(book2);

    }
    @Test
    void buildBuilderWithInvalidPriceMustFail() {
        assertNull(book3);
        System.out.println(book3);

    }
}