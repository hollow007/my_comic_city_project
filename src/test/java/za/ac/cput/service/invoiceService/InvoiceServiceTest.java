package za.ac.cput.service.invoiceService;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InvoiceServiceTest {
    @Autowired
    private InvoiceService invoiceService;
    private Invoice invoice1;
    private Invoice invoice2;
    private CustomerOrder customerOrder;
    private List<ComicBook> comicBooks;
    private ComicBook comicBook;
    private Publisher publisher;
    private Author author1;
    private Author author2;
    private List<Author> authors;

    @BeforeEach
    void setUp() {
        System.out.println("=============================SET-UP====================================");

        publisher = PublisherFactory.buildPublisher(5L, "Marvel",2000);

        author1 = AuthorFactory.buildAuthor(001L,"Lamark", "Mike", "Darwin");
        author2 = AuthorFactory.buildAuthor(002L, "Jacob", "Gedleyihlekisa", "Zuma");
        authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        comicBook = ComicBookFactory.bookBuilder("Thor", "Fantasy", "AsGuards Prince son of Zuis",
                "B01", 299.99, 2.00, 1, authors, publisher, LocalDate.from(LocalDateTime.now()), new byte[0]);

        comicBooks = new ArrayList<>();
        comicBooks.add(comicBook);

        customerOrder = CustomerOrderFactory.buildCustomerOrder("ORD001", 1L, LocalDate.from(LocalDateTime.now()), comicBooks, 650.00);

        invoice1 = InvoiceFactory.buildInvoice(1L, customerOrder, LocalDateTime.now());
        invoice2 = InvoiceFactory.buildInvoice(2L, null, LocalDateTime.now());
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("=============================CREATE====================================");

        Invoice savedInvoice = invoiceService.create(invoice1);
        assertNotNull(savedInvoice);
        System.out.println(savedInvoice);
    }

    @Test
    @Order(2)
    void read() {
        System.out.println("=============================READ====================================");

        Invoice readInvoice = invoiceService.read(Long.valueOf(1));
        assertNotNull(readInvoice);
        System.out.println(readInvoice);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("=============================UPDATE====================================");

        Invoice updatedInvoice = new Invoice.InvoiceBuilder().copy(invoice1)
                .setDateTimeGenerated(LocalDateTime.now())
                .build();

        Invoice savedInvoice = invoiceService.update(updatedInvoice);
        assertEquals(savedInvoice.getInvoiceId(), updatedInvoice.getInvoiceId());
        assertNotNull(savedInvoice);
        System.out.println(savedInvoice);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("=============================DELETE====================================");
        boolean isDeleted = invoiceService.delete(Long.valueOf(invoice1.getInvoiceId()));
        assertEquals(true, isDeleted);
        System.out.println("Invoice no:" + invoice1.getInvoiceId() + " Deleted");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("=============================GET-ALL====================================");
        System.out.println(invoiceService.getAll());
    }
}