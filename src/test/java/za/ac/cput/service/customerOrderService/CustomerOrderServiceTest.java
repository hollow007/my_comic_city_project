package za.ac.cput.service.customerOrderService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.factory.ComicBookFactory;
import za.ac.cput.factory.CustomerOrderFactory;
import za.ac.cput.factory.PublisherFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerOrderServiceTest {

    @Autowired
    private CustomerOrderService customerOrderService;

    private CustomerOrder customerOrder1;
    private CustomerOrder customerOrder2;
    private CustomerOrder customerOrder3;
    Author author1;
    Author author2;
    List<Author> authors = new ArrayList<>();

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

//        System.out.println(comicBook1);
        ArrayList<ComicBook> comicBooks = new ArrayList<>();
        comicBooks.add(comicBook1);

        customerOrder1 = CustomerOrderFactory.buildCustomerOrder("ORD001", 1L, LocalDate.of(2022, 03, 04), comicBooks, 650.00);
    }

    @Test
    void create() {
        System.out.println("===========================CREATE========================================");
        CustomerOrder savedCustomerOrder = customerOrderService.create(customerOrder1);
        assertNotNull(customerOrder1);
        System.out.println(customerOrder1);
    }

    @Test
    void read() {
        System.out.println("===========================READ========================================");
        CustomerOrder readCustomerOrder = customerOrderService.read(customerOrder1.getOrderId());
        assertNotNull(readCustomerOrder);
        System.out.println(readCustomerOrder);
    }

    @Test
    void update() {
        System.out.println("===========================UPDATE========================================");
        CustomerOrder updateCustomerOrder = new CustomerOrder.CustomerOrderBuilder().copy(customerOrder1)
                .setTotalAmount(850)
                .build();

        CustomerOrder savedCustomerOrder = customerOrderService.update(updateCustomerOrder);
        assertEquals(savedCustomerOrder.getOrderId(), updateCustomerOrder.getOrderId());
        assertNotNull(savedCustomerOrder);
        System.out.println(savedCustomerOrder);
    }

    @Test
    void delete() {
        boolean isDeleted = customerOrderService.delete(customerOrder1.getOrderId());
        assertTrue(isDeleted);
        System.out.println("CustomerOrder no " + customerOrder1.getOrderId() + " deleted");
    }

    @Test
    @Order(5)
    void getall(){
        System.out.println("==================================GET ALL===========================");
        System.out.println(customerOrderService.getall());
    }
}