package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminContactFactoryTest {
    static Contact adminContact;
    static Address address;

    @BeforeAll
    static void setUp() {
        address=AddressFactory.buildAddress("106 Gasela","Guguletu","7750","Cape Town");
        adminContact=AdminContactFactory.buildContact("mphumzimbula@gmail.com","0658436358",address);

    }

    @Test
    void a_buildAdminContact() {
        assertNotNull(adminContact);
        System.out.println(adminContact);
    }

    @Test
    void b_buildAdminContactFailTest() {
        adminContact=AdminContactFactory.buildContact("","0658436358",address);
        assertNotNull(adminContact);
        System.out.println(adminContact);
    }
}