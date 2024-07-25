package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.ShippingAddress;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ShippingAddressFactoryTest {

    static ShippingAddress shippingAddress1;
    static ShippingAddress shippingAddress2;
    static ShippingAddress  shippingAddress3;

    @BeforeAll
    static void setUp() {

        shippingAddress1 = ShippingAddressFactory.buildShippingAddress(LocalTime.parse("20:00:00"),"210LoopSteert","Cape Town","8000","Cape Town");
    }

    @Test
    void a_goodShippingAddress() {

        shippingAddress2 = ShippingAddressFactory.buildShippingAddress(LocalTime.parse("18:00:00"),"210LoopSteert","Cape Town","8000","Cape Town");
        assertNotNull(shippingAddress2);
        System.out.println(shippingAddress2);
    }


    @Test
    void b_badShippingAddress() {

        shippingAddress3 = ShippingAddressFactory.buildShippingAddress(LocalTime.parse("18:00:00"),"","Cape Town","8000","Cape Town");
        assertNull(shippingAddress3);
        System.out.println(shippingAddress3);
    }

}