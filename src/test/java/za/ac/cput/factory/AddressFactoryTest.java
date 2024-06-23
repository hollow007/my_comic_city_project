package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class AddressFactoryTest {

    Address address1;
    Address address2;

    Address address3;

    @BeforeEach
    void setUp() {
         address1 = new AddressFactory().buildAddress("34 baterseaDrive", "Kiblerpark", "2091", "Johannesburg");
    }

    @Test
    void a_buildAddress() {
        address2 = new AddressFactory().buildAddress("34 baterseaDrive", "kibblerpark", "2091", "Johannesburg");
        assertNotNull(address2);
        System.out.println(address2);

    }

    @Test
    void b_nullAddress() {
        Address address3 = new AddressFactory().buildAddress("34 baterseaDrive", "", "2091", "Johannesburg");
        assertNull(address3);
        System.out.println(address3);

    }
}