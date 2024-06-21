package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
//

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Publisher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ComicBookFactoryTest {

    private Author author1;
    private Author author2;

    private Publisher publisher1;
    private List<Author> authors;

    private ComicBook book1;
    private ComicBook book2;
    private ComicBook book3;
    byte[] photo;

    @BeforeEach
    void setUp() {
        photo = new byte[0];

        publisher1 = PublisherFactory.buildPublisher(34655, "Marvel",2000);


        author1 = AuthorFactory.buildAuthor(001,"Lamark", "", "Darwin");
        author2 = AuthorFactory.buildAuthor(002, "Jacob", "Gedleyihlekisa", "Zuma");

        authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        book1 = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B01", 299.99, 2.00, 1, authors, publisher1, LocalDate.of(2022, 03, 04), photo);
        book2 = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B02", 199.99, 1.80, 1, authors, publisher1, LocalDate.of(2024, 03, 15), photo);
        book3 = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B03", 539.99, 3.50, 3, authors, publisher1, LocalDate.of(2021, 05, 30), photo);
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