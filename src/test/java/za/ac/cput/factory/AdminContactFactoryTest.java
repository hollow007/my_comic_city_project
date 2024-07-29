package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.ShippingAddress;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminContactFactoryTest {
    static Contact adminContact;
    static BillingAddress billingAddress;
    static ShippingAddress shippingAddress;

    @BeforeAll
    static void setUp() {

        billingAddress=BillingAddressFactory.buildBillingAddress("Cash","109 Gaza street","Khayelitsha","7500","Cape Town");
        adminContact=AdminContactFactory.buildContact("mphumzimbula@gmail.com","0658436358",billingAddress);

    }

    @Test
    void a_buildAdminContact() {
        assertNotNull(adminContact);
        System.out.println(adminContact);
    }

    @Test
    void b_buildAdminContactFailTest() {
        adminContact=AdminContactFactory.buildContact("","0658436358",billingAddress);
        assertNotNull(adminContact);
        System.out.println(adminContact);
    }
}