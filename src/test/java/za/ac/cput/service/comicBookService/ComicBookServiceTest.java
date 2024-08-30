package za.ac.cput.service.comicBookService;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic_city_project
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.factory.ComicBookFactory;
import za.ac.cput.factory.PublisherFactory;
import za.ac.cput.service.authorService.AuthorService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComicBookServiceTest {
    @Autowired
    private ComicBookService comicBookService;
    private static ComicBook book1;
    private static ComicBook book2;
    private static ComicBook book3;

    private static Author author1;
    private static Author author2;
    private static Author author3;

    private static List<Author> authors1;
    private static List<Author> authors2;
    private static List<Author> authors3;

    private static List<ComicBook> comicBooks1;
    private static List<ComicBook> comicBooks2;
    private static List<ComicBook> comicBooks3;

    private static ByteArrayOutputStream out;
    private static BufferedImage image;


    private static ByteArrayOutputStream out1;
    private static BufferedImage image1;


    private static ByteArrayOutputStream out2;
    private static BufferedImage image2;

    private static Publisher publisher1;
    private static Publisher publisher2;
    private static Publisher publisher3;


    @BeforeAll
    static void  setUp() {

        System.out.println("============================SETUP==================================");

        String url1 ="images/ComicBookCover9.jpeg";
        String url2="images/ComicBookCover10.jpeg";
        String url3="images/ComicBookCover6.jpeg";

        try {

            image = ImageIO.read(new File(url1));
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", out);

            image1 = ImageIO.read(new File(url2));
            out1 = new ByteArrayOutputStream();
            ImageIO.write(image1, "jpeg", out1);

            image2 = ImageIO.read(new File(url3));
            out2 = new ByteArrayOutputStream();
            ImageIO.write(image2, "jpeg", out2);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }




        //Authors
        author1 = AuthorFactory.buildAuthor(001L, "Mbuyazi", "Mlu");
        System.out.println(author1);
        author2 = AuthorFactory.buildAuthor(002L, "Sherly", "Avuyile", "Bobby");
        System.out.println(author2);
        author3 = AuthorFactory.buildAuthor(003L, "Daton",  "Zwivhuya");
        System.out.println(author3);

        authors1 = new ArrayList<>();
        authors1.add(author1);
        authors1.add(author3);

        authors2 = new ArrayList<>();
        authors1.add(author1);
        authors2.add(author2);
        authors2.add(author3);

        authors3 = new ArrayList<>();
        authors3.add(author3);
        authors2.add(author1);


        publisher1 = PublisherFactory.buildPublisher(1234L, "CputComics", 2000);
        publisher2 = PublisherFactory.buildPublisher(5678L, "KwazuluComics", 2009);
        publisher3 = PublisherFactory.buildPublisher(9101L, "DCComics", 1910);
//Books

        book1 = ComicBookFactory.bookBuilder("The GAME 2", "Thriller", "Spaace Wars in far awa galaxy",
                "B10", 474.99, 1.50, 7, authors1, publisher3, LocalDate.of(2024, 8, 11), out.toByteArray());
        book2 = ComicBookFactory.bookBuilder("BeeKeeper 3", "Sci-Fi", "A scientific experiment disaster creates a superhero",
                "B11", 699.99, 3.80, 6, authors1, publisher1, LocalDate.of(2024, 7, 17), out1.toByteArray());
        book3 = ComicBookFactory.bookBuilder("The LastMan 2", "Action", "A power hungry villean threatens to destroy earth",
                "B12", 1980.99, 2.40, 3, authors2, publisher2, LocalDate.of(2024, 07, 20), out2.toByteArray());

        comicBooks1 = new ArrayList<>();
        comicBooks1.add(book1);
        comicBooks1.add(book3);

        comicBooks2 = new ArrayList<>();
        comicBooks2.add(book1);
        comicBooks1.add(book3);
        comicBooks2.add(book2);

        comicBooks3 = new ArrayList<>();
        comicBooks3.add(book2);
        comicBooks3.add(book3);

    }

    @Test
    @Order(1)
    void create() {
        System.out.println("=============================CREATE====================================");
        ComicBook savedComicCook1 = comicBookService.create(book1);
        assertNotNull(savedComicCook1);
        System.out.println(savedComicCook1);

        ComicBook savedComicCook2 = comicBookService.create(book2);
        assertNotNull(savedComicCook2);
        System.out.println(savedComicCook2);
//
//        ComicBook savedComicCook3 = comicBookService.create(book3);
//        assertNotNull(savedComicCook3);
//        System.out.println(savedComicCook3);
    }
//
    @Test
    @Order(2)
    void read() {
        System.out.println("=============================READ====================================");
        ComicBook readBook = comicBookService.read(1L);
        assertNotNull(readBook);
        System.out.println(readBook);


        ByteArrayInputStream inputStream = new ByteArrayInputStream(readBook.getPhoto());

        try {
            BufferedImage bufferedImage1=ImageIO.read(inputStream);
            ImageIO.write(bufferedImage1,"jpeg", new File("output.jpeg"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    @Test
//    @Order(3)
//    void update() {
//        System.out.println("=============================UPDATE====================================");
//        authors.add(author2);
//        ComicBook updatedComicBook = new ComicBook.Builder().copy(book2)
//                .setPrice(880)
//                .setAuthors(authors)
//                .build();
//
//        ComicBook saved = comicBookService.update(updatedComicBook);
//        assertNotNull(saved);
//        System.out.println(saved);
//
//    }
//
//    @Test
//
//    @Order(4)
//
//    void delete() {
//        System.out.println("=============================DELETE====================================");
//        boolean isDeleted = comicBookService.delete(3L);
//        assertEquals(true, isDeleted);
//        System.out.println("Successfully deleted book: " + book3.getName());
//    }
//
//    @Test
//    @Order(5)
//    void getAll() {
//        System.out.println("=============================GET-ALL====================================");
//        System.out.println(comicBookService.getAll());
//
//}
}
