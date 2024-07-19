package za.ac.cput.service.reviewService;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.reviewService.ReviewService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewServiceTest {
    @Autowired
    private ReviewService service;
    private Review review1;
    private Review review2;
    private Review review3;
    private Customer customer;
    private ComicBook comicBook;
    private Publisher publisher;
    private List<Author> authors;
    private Author author1;
    private Author author2;
    byte[] photo;

    @BeforeEach
    void setUp() {
        System.out.println("=============================SET-UP====================================");

        photo = new byte[0];

        publisher = PublisherFactory.buildPublisher(5L, "Marvel",2000);

        Address billingAddress = BillingAddressFactory.buildBillingAddress("card", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(billingAddress);

        Address shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.of(9,52), "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(shippingAddress);

        Contact con1 = CustomerContactFactory.buildContact("leroyk@gmail.com", "0739946042", shippingAddress, billingAddress);
        customer = CustomerFactory.buildCustomer(1234,"Leroy" , "Kulcha", "Sane","Lkulcha123",con1);


        author1 = AuthorFactory.buildAuthor(001L,"Lamark", "", "Darwin");
        author2 = AuthorFactory.buildAuthor(002L, "Jacob", "Gedleyihlekisa", "Zuma");
        authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        comicBook = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B01", 299.99, 2.00, 1, authors, publisher, LocalDate.of(2022, 03, 04), photo);

        review1 = ReviewFactory.buildReview(1L, customer, comicBook, 4, "Good book", LocalDate.now(), "Good book review");
        System.out.println(review1);
        review2 = ReviewFactory.buildReview(2L, customer, comicBook, 2, "Bad book", LocalDate.now(), "Bad book review");
        System.out.println(review2);
        review3 = ReviewFactory.buildReview(3L, customer, comicBook, 3, "Okay book", LocalDate.now(), "Okay book review");
        System.out.println(review3);
        System.out.println(review3);
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("=============================CREATE====================================");

        Review savedReview1 = service.create(review1);
        assertNotNull(savedReview1);
        System.out.println(savedReview1);

        Review savedReview2 = service.create(review2);
        assertNotNull(savedReview2);
        System.out.println(savedReview2);

        Review savedReview3 = service.create(review3);
        assertNotNull(savedReview3);
        System.out.println(savedReview3);
    }

    @Test
    @Order(2)
    void read() {
        System.out.println("=============================READ====================================");

        Review readReview1 = service.read(Long.valueOf(1));
        assertNotNull(readReview1);
        System.out.println(readReview1);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("=============================UPDATE====================================");

        Review updatedReview3 = new Review.ReviewBuilder().copy(review3)
                .setReviewTitle("New title")
                .setReviewDescription("New description")
                .build();

        Review savedReview = service.update(updatedReview3);
        assertEquals(savedReview.getReviewID(), review3.getReviewID());
        assertNotNull(savedReview);
        System.out.println(savedReview);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("=============================DELETE====================================");
        boolean isDeleted = service.delete(Long.valueOf(review2.getReviewID()));
        assertEquals(true, isDeleted);
        System.out.println("Review no:" + review2.getReviewID() + " Deleted");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("=============================GET-ALL====================================");
        System.out.println(service.getAll());
    }
}