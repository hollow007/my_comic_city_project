package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Publisher;
import za.ac.cput.factory.PublisherFactory;
import za.ac.cput.service.publisherService.PublisherService;

import static org.junit.jupiter.api.Assertions.*;
//@Configuration
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PublisherControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private  Publisher publisher3;
    private final String base_url = "http://localhost:8080/comiccity/Publisher";

    @Autowired
    private PublisherService publisherService;

    private Publisher publisher1;
    private Publisher publisher2;

    @BeforeEach
    void setUp() {
        publisher1 = PublisherFactory.buildPublisher(67954L, "Kat Publishers", 2010);
        publisher2 = PublisherFactory.buildPublisher(87949L, "Nathan Publishers", 2007);
        // publisherService.create(publisher3);
    }

    @Test
    void a_create() {
        String url = base_url + "/create";
        ResponseEntity<Publisher> postResponse = restTemplate.postForEntity(url, publisher3, Publisher.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("PstR body: " + postResponse);
        Publisher savedPublisher = postResponse.getBody();
        System.out.println(publisher3.getPublisherId());
        System.out.println(savedPublisher.getPublisherId());
        assertEquals(publisher3.getPublisherId(), savedPublisher.getPublisherId());
        System.out.println("Saved data: " + savedPublisher);
    }

    @Test
    void b_read() {
        String url = base_url + "/read/" + 87949L;
        System.out.println("URL: " + url);
        ResponseEntity<Publisher> response = restTemplate.getForEntity(url, Publisher.class);
        System.out.println("Response: " + response);
        assertEquals( response.getBody().getPublisherId(), publisher3.getPublisherId());
    }

    @Test
    void c_update() {
        String url = base_url + "/update";
        Publisher updatePublisher = new Publisher.PublisherBuilder().copy(publisher1)
                .setName("Katleho Publishers")
                .build();
        ResponseEntity<Publisher> postResponse = restTemplate.postForEntity(url, updatePublisher, Publisher.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Publisher updatedPublisher = postResponse.getBody();
        assertEquals(updatePublisher.getPublisherId(), updatedPublisher.getPublisherId());
        System.out.println("Saved data: " + updatedPublisher);
    }

    @Test
    void d_delete() {
        String url = base_url + "/delete/" + Long.valueOf(3456);
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: deleted publisher");
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