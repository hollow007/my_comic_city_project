//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Author;
//import za.ac.cput.domain.ComicBook;
//import za.ac.cput.domain.CustomerOrder;
//import za.ac.cput.domain.Publisher;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//public class CustomerOrderFactoryTest {
//
//    private CustomerOrder customerOrder1;
//    private CustomerOrder customerOrder2;
//    private CustomerOrder customerOrder3;
//    Author author1;
//    Author author2;
//    @BeforeEach
//    void setUp() {
//        byte[] photo = new byte[0];
//
//        Publisher publisher1 = PublisherFactory.buildPublisher(34655L, "Marvel", 2000);
//
//        author1 = AuthorFactory.buildAuthor(1, "Lamark", "", "Darwin");
//        author2 = AuthorFactory.buildAuthor(2, "Jacob", "Gedleyihlekisa", "Zuma");
//
//        List<Author> authors = new ArrayList<>();
//        authors.add(author1);
//        authors.add(author2);
//
//        ComicBook comicBook1 = ComicBookFactory.bookBuilder(
//                "Secret Wars",
//                "Action/Si-Fi",
//                "A great action/sci-fi comic",
//                "ISBN001",
//                300.00,
//                1.5,
//                100,
//                authors,
//                publisher1,
//                LocalDate.of(2024,4,30),
//                photo
//        );
////        System.out.println(comicBook1);
//
//        ComicBook comicBook2 = ComicBookFactory.bookBuilder(
//                "Hulk",
//                "Action",
//                "The Hulk series",
//                "ISBN002",
//                350.00,
//                2.0,
//                200,
//                authors,
//                publisher1,
//                LocalDate.now(),
//                photo
//        );
////        System.out.println(comicBook2);;
//
//        customerOrder1 = CustomerOrderFactory.buildCustomerOrder("ORD001", LocalDate.now(), Arrays.asList(comicBook1, comicBook2), 650.00);
//        customerOrder2 = CustomerOrderFactory.buildCustomerOrder("ORD002", LocalDate.of(2024, 7, 17), Arrays.asList(comicBook1, comicBook2), 650.00);
//        customerOrder3 = CustomerOrderFactory.buildCustomerOrder("ORD003", LocalDate.now(), Arrays.asList(comicBook1, comicBook2), -100.00);
//    }
//
//    @Test
//    void buildCustomerOrderWithValidDetails() {
//        assertNotNull(customerOrder1);
//        System.out.println(customerOrder1);
//    }
//
//    @Test
//    void buildCustomerOrderWithFutureDateMustFail() {
//        assertNull(customerOrder2);
//        System.out.println(customerOrder2);
//    }
//
//    @Test
//    void buildCustomerOrderWithInvalidTotalAmountMustFail() {
//        assertNull(customerOrder3);
//        System.out.println(customerOrder3);
//    }
//}
