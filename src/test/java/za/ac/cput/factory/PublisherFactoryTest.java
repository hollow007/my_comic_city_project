package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Publisher;

import static org.junit.jupiter.api.Assertions.*;

class PublisherFactoryTest {
    private Publisher publisher1;
    private Publisher publisher2;

    @BeforeEach
    void setUp() {
        publisher1 = PublisherFactory.buildPublisher(34655, "Cabane Publishers",2000);
        publisher2 = publisher1;
    }

    @Test
    void buildPublisher() {
        assertNotNull(publisher1);
        System.out.println(publisher1);
    }
    @Test
    void identityTest(){
        assertSame(publisher1, publisher2);
        System.out.println(publisher2);
    }
}