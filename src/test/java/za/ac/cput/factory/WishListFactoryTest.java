package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.WishList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WishListFactoryTest {
    private WishList wishList1;
    private WishList wishList2;
    private WishList wishList3;
    private Author author1;

    private Author author2;
    private List<Author> authors;
    private ComicBook book1;
    private ComicBook book2;


    private List<ComicBook> comicBookList;

    @BeforeEach
    void setup() {
        author1 = AuthorFactory.buildAuthor(001, "Lamark", "", "Darwin");
        author2 = AuthorFactory.buildAuthor(002, "Jacob", "Gedleyihlekisa", "Zuma");


        authors = new ArrayList<>();

        authors.add(author1);
        authors.add(author2);

        book1 = ComicBookFactory.buildBuilder("CMB01", "Thor", 3.4, LocalDate.now(), authors, 300.00);
        book2 = ComicBookFactory.buildBuilder("CMB02", "Hulk", 3.4, LocalDate.of(2024, 05, 18), authors, 300.00);

        comicBookList = new ArrayList<>();

        comicBookList.add(book1);
        comicBookList.add(book2);

        wishList1 = WishListFactory.buildWishList("myWishList1", comicBookList, LocalDate.of(2024, 02, 14), LocalDate.of(2024, 02, 15));
        wishList2 = WishListFactory.buildWishList("", comicBookList, LocalDate.of(2024, 04, 20), LocalDate.of(2024, 05, 01));
        wishList3 = WishListFactory.buildWishList("Books I Wish To Buy ", comicBookList, LocalDate.of(2025, 04, 20), LocalDate.of(2024, 05, 01));
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
    void wishListWithFutureCreationDateMustFail() {
        assertNull(wishList3);
        System.out.println(wishList3);
    }


}