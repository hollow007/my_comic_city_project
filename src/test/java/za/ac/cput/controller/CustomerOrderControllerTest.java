package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.domain.Publisher;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.factory.ComicBookFactory;
import za.ac.cput.factory.CustomerOrderFactory;
import za.ac.cput.factory.PublisherFactory;
import za.ac.cput.service.publisherService.PublisherService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerOrderControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String base_url = "http://localhost:8080/comiccitydb/CustomerOrder";

    private CustomerOrder customerOrder1;
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
    void a_create() {
        String url = base_url + "/create";
        ResponseEntity<CustomerOrder> postResponse = restTemplate.postForEntity(url, customerOrder1, CustomerOrder.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("PstR body: " + postResponse);
        CustomerOrder savedCustomerOrder = postResponse.getBody();
        System.out.println(customerOrder1.getOrderId());
        System.out.println(savedCustomerOrder.getOrderId());
        assertEquals(customerOrder1.getOrderId(), savedCustomerOrder.getOrderId());
        System.out.println("Saved data: " + savedCustomerOrder);
    }

    @Test
    void b_read() {
        String url = base_url + "/read/" + customerOrder1.getOrderId();
        System.out.println("URL: " + url);
        ResponseEntity<CustomerOrder> response = restTemplate.getForEntity(url, CustomerOrder.class);
        System.out.println("Response: " + response);
        assertEquals( response.getBody().getOrderId(), customerOrder1.getOrderId());
    }

    @Test
    void c_update() {
        String url = base_url + "/update";
        CustomerOrder updatedCustomerOrder = new CustomerOrder.CustomerOrderBuilder().copy(customerOrder1)
                .setTotalAmount(700)
                .build();
        ResponseEntity<CustomerOrder> postResponse = restTemplate.postForEntity(url, updatedCustomerOrder, CustomerOrder.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        CustomerOrder updatedCustomer = postResponse.getBody();
        assertEquals(updatedCustomer.getOrderId(), postResponse.getBody().getOrderId());
        System.out.println("Saved data: " + updatedCustomer);
    }

    @Test
    void d_delete() {
        String url = base_url + "/delete/" + customerOrder1.getOrderId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: deleted customer order");
    }

    @Test
    void e_getall() {
        String url = base_url + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("SHOW ALL:");
        System.out.println(response);
    }
}