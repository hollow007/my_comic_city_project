package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Publisher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {
    private Cart cart1;
    private Cart cart2;
    private Cart cart3;
    private Publisher publisher1;

    private List<Publisher> publishers;
    private Author author1;
    private Author author2;
    private List<Author> authors;
    private ComicBook book1;
    private ComicBook book2;

    List<ComicBook>comicBookList;

    @BeforeEach
    void setUp() {


        author1 = AuthorFactory.buildAuthor(001, "Lamark", "", "Darwin");
        author2 = AuthorFactory.buildAuthor(002, "Jacob", "Gedleyihlekisa", "Zuma");

        authors = new ArrayList<>();

        authors.add(author1);
        authors.add(author2);

        publisher1 = PublisherFactory.buildPublisher(34655, "Marvel",2000);
        publishers = new ArrayList<>();
        publishers.add(publisher1);

        book1 = ComicBookFactory.buildBuilder("CMB01", "Thor", 3.4, LocalDate.now(), authors, publishers, 300.00);
        book2 = ComicBookFactory.buildBuilder("CMB02", "Hulk", 3.4, LocalDate.of(2024,07,17), authors, publishers,300.00);

        comicBookList=new ArrayList<>();

        comicBookList.add(book1);
        comicBookList.add(book2);



        cart1=CartFactory.buildCart(2001,600.00,comicBookList,LocalDate.of(2024,02,15),LocalDate.now());
        cart2=CartFactory.buildCart(2002,-8,comicBookList,LocalDate.of(2024,04,20),LocalDate.of(2024,05,01));
        cart3=CartFactory.buildCart(2003,600,comicBookList,LocalDate.of(2025,04,20),LocalDate.of(2024,05,01));

    }
    @Test
    void buildCart(){
        assertNotNull(cart1);
        System.out.println(cart1);
    }
    @Test
    void cartWithInvalidPriceMustBeNull(){
    assertNull(cart2);
        System.out.println(cart2);
    }
    @Test
    void cartWithFutureCreationDateMustFail(){
        assertNotNull(cart3);
        System.out.println(cart3);
    }

}