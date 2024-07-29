
package za.ac.cput.factory;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressFactoryTest {

    static Address address1;
    static Address address2;



    @BeforeAll
    static void setUp() {
         address1 = AddressFactory.buildAddress("34 baterseaDrive", "Kiblerpark", "2091", "Johannesburg");
    }

    @Test
    void a_buildAddress() {
        address2 = AddressFactory.buildAddress("34 baterseaDrive", "kibblerpark", "2091", "Johannesburg");
        assertNotNull(address2);
        System.out.println(address2);

    }

    @Test
    void b_nullAddress() {
        Address address3 = AddressFactory.buildAddress("34 baterseaDrive", "", "2091", "Johannesburg");
        assertNull(address3);
        System.out.println(address3);

    }
}