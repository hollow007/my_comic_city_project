package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Publisher;
import za.ac.cput.domain.WishList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Mpumzi Mbula
 * 219053324
 * 19/05/2024
 */
class WishListFactoryTest {
    private WishList wishList1;
    private WishList wishList2;
    private WishList wishList3;
    byte[]photo;
    private Author author1;
    private Author author2;
    private List<Author> authors;
    private ComicBook book1;
    private ComicBook book2;
    private ComicBook book3;
    private List<ComicBook> comicBooks;
    private Publisher publisher1;


    @BeforeEach
    void setup() {
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

        comicBooks=new ArrayList<>();
        comicBooks.add(book1);
        comicBooks.add(book2);
        comicBooks.add(book3);

        wishList1 = WishListFactory.buildWishList(1L,"myWishList1", comicBooks, LocalDate.of(2024, 02, 14), LocalDate.of(2024, 02, 15));
        wishList2 = WishListFactory.buildWishList(2L,"", comicBooks, LocalDate.of(2024, 04, 20), LocalDate.of(2024, 05, 01));
        wishList3 = WishListFactory.buildWishList(3L,"Books I Wish To Buy ", comicBooks, LocalDate.of(2025, 04, 20), LocalDate.of(2024, 05, 01));
    }

    @Test
    void buildWishList() {
        assertNotNull(wishList1);
        System.out.println(wishList1);
    }

    @Test
    void wishListWithNoNameMustBeNull() {
        assertNull(wishList2);
        System.out.println(wishList2);
    }

    @Test
    void wishListWithFutureCreationDateMustBeNull() {
        assertNull(wishList3);
        System.out.println(wishList3);
    }


}