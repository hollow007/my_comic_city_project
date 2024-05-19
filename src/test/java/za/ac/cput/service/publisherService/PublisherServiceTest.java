package za.ac.cput.service.publisherService;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Publisher;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.PublisherFactory;
import za.ac.cput.repository.PublisherRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PublisherServiceTest {
    @Autowired
    private PublisherService service;
    private Publisher publisher1;
    private Publisher publisher2;
    private Publisher publisher3;
    @BeforeEach
    void setUp() {
        publisher1 = PublisherFactory.buildPublisher(67954, "Kat Publishers", 2010);
        publisher2 = PublisherFactory.buildPublisher(87949, "Nathan Publishers", 2007);
        publisher3 = publisher1;
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("===========================CREATE========================================");
        Publisher savedPublisher = service.create(publisher1);
        assertNotNull(savedPublisher);
        System.out.println(savedPublisher);

        Publisher savedPublisher2 = service.create(publisher2);
        assertNotNull(savedPublisher2);
        System.out.println(savedPublisher2);
    }

    @Test
    @Order(2)
    void read() {
        System.out.println("===========================READ========================================");
    Publisher readPublisher = service.read(Long.valueOf(67954));
    assertNotNull(readPublisher);
    System.out.println(readPublisher);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("===========================UPDATE========================================");
    Publisher updatePublisher = new Publisher.PublisherBuilder().copy(publisher1)
            .setName("Katleho Publishers")
            .build();

    Publisher savedPublisher = service.update(updatePublisher);
    assertEquals(savedPublisher.getPublisherId(), updatePublisher.getPublisherId());
    assertNotNull(savedPublisher);
    System.out.println(savedPublisher);
    }

    @Test
    @Order(4)
    void delete() {
        System.out.println("===========================DELETE========================================");
        service.delete(Long.valueOf(publisher1.getPublisherId()));
        System.out.println("Publisher no: " + publisher1.getPublisherId() + " deleted");
    }

    @Test
    @Order(5)
    void getall() {
        System.out.println("===========================GETALL========================================");
        System.out.println(service.getall());
    }
}