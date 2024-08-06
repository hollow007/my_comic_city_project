package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InvoiceControllerTest {
    private final String BASE_URL = "http://localhost:8080/comiccity/invoice";

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static Invoice invoice1;
    private static CustomerOrder customerOrder;
    private static List<ComicBook> comicBooks;
    private static ComicBook comicBook;
    private static Publisher publisher;
    private static Author author1;
    private static List<Author> authors;

    static Invoice savedInvoice;

    @BeforeAll
    static void setUp() {
        System.out.println("=============================SET-UP====================================");

        publisher = PublisherFactory.buildPublisher(5L, "Marvel", 2000);

        author1 = AuthorFactory.buildAuthor(001L, "Lamark", "Mike", "Darwin");
        authors = new ArrayList<>();
        authors.add(author1);

        comicBook = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B01", 299.99, 2.00, 1, authors, publisher, LocalDate.from(LocalDateTime.now()), new byte[0]);

        comicBooks = new ArrayList<>();
        comicBooks.add(comicBook);

        customerOrder = CustomerOrderFactory.buildCustomerOrder("ORD001", 1L, LocalDate.from(LocalDateTime.now()), comicBooks, 650.00);

        invoice1 = InvoiceFactory.buildInvoice(1L, customerOrder, LocalDateTime.now());
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Invoice> response = testRestTemplate.postForEntity(url, invoice1, Invoice.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        savedInvoice = response.getBody();
        System.out.println("Invoice Created:");
        System.out.println("Invoice ID: " + savedInvoice.getInvoiceId());
        System.out.println("Invoice Date: " + savedInvoice.getDateTimeGenerated());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + savedInvoice.getInvoiceId();
        ResponseEntity<Invoice> response = testRestTemplate.getForEntity(url, Invoice.class);
        Invoice readInvoice = response.getBody();
        assertEquals(readInvoice.getInvoiceId(), response.getBody().getInvoiceId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Invoice newInvoice = new Invoice.InvoiceBuilder().copy(invoice1)
                .setDateTimeGenerated(LocalDateTime.now())
                .build();
        System.out.println(newInvoice);

        ResponseEntity<Invoice> postResponse = testRestTemplate.postForEntity(url, newInvoice, Invoice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Invoice invoiceUpdated = postResponse.getBody();
        assertEquals(postResponse.getBody(), invoiceUpdated);
        System.out.println(invoiceUpdated);
    }

    @Test
    @Order(4)
    void delete() {
        String url = BASE_URL + "/delete/" + savedInvoice.getInvoiceId();
        testRestTemplate.delete(url);
        System.out.println("Invoice with ID:" + savedInvoice.getInvoiceId() + " is deleted!");
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("SHOW ALL:");
        System.out.println(response);
    }
}