package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.BillingAdress;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BillingAddressFactoryTest {

    BillingAdress address;

    @BeforeEach
    void setUp() {
         address = new BillingAddressFactory().
                buildBillingAddress("card","34 Batersea Drive", "Kibbler park" , "2091" , "Johannesburg");


    }

    @Test
    void a_goodAddress() {

        address = BillingAddressFactory.buildBillingAddress("card","34 Batersea Drive", "Kibbler park" , "2091" , "Johannesburg");
        assertNotNull(address);
        System.out.println(address);


    }

    @Test
    void b_badAddress() {

        address = new BillingAddressFactory().buildBillingAddress("card","34 Batersea Drive", "" , "2091" , "Johannesburg");
        assertNull(address);
        System.out.println(address);


    }
}