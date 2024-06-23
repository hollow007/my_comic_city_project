package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Publisher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublisherFactoryTest {

    private Publisher publisher1;
    private Publisher publisher2;
    @BeforeEach
    void setUp() {


        publisher1 = PublisherFactory.buildPublisher(34655L, "Marvel",2000);

        publisher2 = PublisherFactory.buildPublisher(34655L, "C Publishers", 2000);
    }

    @Test
    void testBuildPublisher() {
        assertNotNull(publisher1);
        System.out.println(publisher1);
    }
    @Test
    void failingTestBuildPublisher() {
        assertNotNull(publisher2);
        System.out.println(publisher2);
    }
}