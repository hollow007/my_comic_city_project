package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
class BillingAddressFactoryTest {

    static Address billingAddress;

    @BeforeAll
    static void setUp() {
         billingAddress = BillingAddressFactory.
                buildBillingAddress("card","34 Batersea Drive", "Kibbler park" , "2091" , "Johannesburg");


    }

    @Test
    void a_goodAddress() {

        assertNotNull(billingAddress);
        System.out.println(billingAddress);


    }

    @Test
    void b_badAddress() {

        billingAddress = BillingAddressFactory.buildBillingAddress("card","34 Batersea Drive", "" , "2091" , "Johannesburg");
        assertNull(billingAddress);
        System.out.println(billingAddress);


    }
}