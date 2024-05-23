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
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class AddressFactoryTest {

    @BeforeEach
    void setUp() {
        Address address = new AddressFactory().buildAddress("34 baterseaDrive", "Kiblerpark", "2091", "Johannesburg");
    }

    @Test
    void a_buildAddress() {
        Address address2 = new AddressFactory().buildAddress("34 baterseaDrive", "kibblerpark", "2091", "Johannesburg");
        assertNotNull(address2);
        System.out.println(address2);

    }
}