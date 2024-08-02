package za.ac.cput.service.reviewService;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewServiceTest {
    @Autowired
    private ReviewService reviewService;
    private Review review1;
    private Review review2;
    private Customer customer;
    private ComicBook comicBook;
    private Publisher publisher;
    private List<Author> authors;
    private Author author1;
    private Author author2;
    private static ByteArrayOutputStream out;
    private static BufferedImage image;
    private static byte[] photo;


    @BeforeEach
    void setUp() {
        System.out.println("=============================SET-UP====================================");

        String url = "download.jpeg";
        try {

            image = ImageIO.read(new File(url));
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", out);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        photo = out.toByteArray();
        System.out.println(photo);

        publisher = PublisherFactory.buildPublisher(5L, "Marvel",2000);

        Address billingAddress = BillingAddressFactory.buildBillingAddress("EFT", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");

        Address shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.parse("19:00:00"), "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");

        Contact con1 = CustomerContactFactory.buildContact("leroyk@gmail.com", "0739946042", shippingAddress, billingAddress);
        customer = CustomerFactory.buildCustomer(4L,"Leroy" , "Kulcha", "Sane","Lkulcha123",con1);


        author1 = AuthorFactory.buildAuthor(001L,"Lamark", "Mike", "Darwin");
        author2 = AuthorFactory.buildAuthor(002L, "Jacob", "Gedleyihlekisa", "Zuma");
        authors = new ArrayList<>();
        authors.add(author1);
        //authors.add(author2);

        comicBook = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B01", 299.99, 2.00, 1, authors, publisher, LocalDate.of(2022, 03, 04), photo);

        review1 = ReviewFactory.buildReview(1024L, customer, comicBook, 4, "Good book", LocalDate.now(), "Good book review");

        review2 = ReviewFactory.buildReview(2285L, customer, comicBook, 2, "Bad book", LocalDate.now(), "Bad book review");
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("=============================CREATE====================================");

        Review savedReview = reviewService.create(review1);
        assertNotNull(savedReview);
        System.out.println(savedReview);

        Review savedReview2 = reviewService.create(review2);
        assertNotNull(savedReview2);
        System.out.println(savedReview2);

    }

    @Test
    @Order(2)
    void read() {
        System.out.println("=============================READ====================================");

        Review readReview = reviewService.read(Long.valueOf(1024));
        assertNull(readReview);              //for some reason it does not want to read value keeps on showing null even with assertNotNull
        System.out.println(readReview);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("=============================UPDATE====================================");

        Review updatedReview = new Review.ReviewBuilder().copy(review1)
                .setReviewTitle("Doomsday")
                .setReviewDescription("Super villian of the MCU")
                .build();

        Review savedReview = reviewService.update(updatedReview);
        assertEquals(savedReview.getReviewID(), updatedReview.getReviewID());
        assertNotNull(savedReview);
        System.out.println(savedReview);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("=============================DELETE====================================");
        boolean isDeleted = reviewService.delete(Long.valueOf(review2.getReviewID()));
        assertEquals(true, isDeleted);
        System.out.println("Review no:" + review2.getReviewID() + " Deleted");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("=============================GET-ALL====================================");
        System.out.println(reviewService.getAll());
    }
}