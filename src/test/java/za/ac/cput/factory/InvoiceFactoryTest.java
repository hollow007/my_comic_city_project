package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/* InvoiceFactoryTest.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 6 August 2024
   https://github.com/hollow007/my_comic_city_project
 */
class InvoiceFactoryTest {

    private CustomerOrder customerOrder1;
    private CustomerOrder customerOrder2;
    private CustomerOrder customerOrder3;
    private Invoice invoice1;
    private Invoice invoice2;
    private Invoice invoice3;
    private Author author1;
    private Author author2;
    private List<Author> authors;

    @BeforeEach
    void setUp() {
        byte[] photo = new byte[0];

        Publisher publisher1 = PublisherFactory.buildPublisher(34655L, "Marvel",2000);

        author1 = AuthorFactory.buildAuthor(001L,"Lamark", "", "Darwin");
        author2 = AuthorFactory.buildAuthor(002L, "Jacob", "Gedleyihlekisa", "Zuma");

        authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        ComicBook comicBook1 = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B01", 299.99, 2.00, 1, authors, publisher1, LocalDate.of(2022, 03, 04), photo);

        ArrayList<ComicBook> comicBooks = new ArrayList<>();
        comicBooks.add(comicBook1);

        customerOrder1 = CustomerOrderFactory.buildCustomerOrder("ORD001", 1L, LocalDate.of(2022, 03, 04), comicBooks, 650.00);
        customerOrder2 = null;
        customerOrder3 = CustomerOrderFactory.buildCustomerOrder("ORD003", 2L, LocalDate.now(), comicBooks, 650.00);

        invoice1 = InvoiceFactory.buildInvoice(1L, customerOrder1, LocalDateTime.now());
        invoice2 = InvoiceFactory.buildInvoice(2L, customerOrder2, LocalDateTime.now());
        invoice3 = InvoiceFactory.buildInvoice(3L, customerOrder3, null);
    }

    @Test
    void buildInvoiceWithValidDetails() {
        assertNotNull(invoice1);
        System.out.println(invoice1);
    }

    @Test
    void buildInvoiceWithNullCustomerOrderMustFail() {
        assertNull(invoice2);
        System.out.println(invoice2);
    }

    @Test
    void buildInvoiceWithNullDateTimeGeneratedMustFail() {
        assertNull(invoice3);
        System.out.println(invoice3);
    }
}