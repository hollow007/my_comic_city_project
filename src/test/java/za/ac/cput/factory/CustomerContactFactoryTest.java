package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class CustomerContactFactoryTest {
    static Address billingAddress;
    static Address shippingAddress;

    @Test
    void a_buildContact() {
        billingAddress = BillingAddressFactory.
                buildBillingAddress("card","34 Batersea Drive", "Kibbler park" , "2091" , "Johannesburg");
        shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.parse("18:00:00"),"210LoopSteert","Cape Town","8000","Cape Town");

        Contact contact1=CustomerContactFactory.buildContact("mphumzimbula@gmail.com","0658436358",shippingAddress,billingAddress);
        assertNotNull(contact1);
        System.out.println(contact1);

    }

    @Test
    void b_buildContactFailTest() {
        billingAddress = BillingAddressFactory.
                buildBillingAddress("card","34 Batersea Drive", "Kibbler park" , "2091" , "Johannesburg");
        shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.parse("18:00:00"),"210LoopSteert","Cape Town","8000","Cape Town");

        Contact contact1=CustomerContactFactory.buildContact("mphumzimbula@gmail.com","",shippingAddress,billingAddress);
        assertNotNull(contact1);
        System.out.println(contact1);
    }
}