/* Joshua Mokwebo
Student Number : 222191562
GITHUB:
Date : 17/09/2024
 */


package za.ac.cput.service.adressService;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.factory.BillingAddressFactory;
import za.ac.cput.factory.ShippingAddressFactory;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    private static Address billingAddress;
    private static Address shippingAddress;


    @BeforeAll
    static void setUp() {
        billingAddress = BillingAddressFactory.buildBillingAddress(1l, "card", "5 Mpetsheni Cresent", "Khayelitsha", "7784", "Cape Town");

        shippingAddress = ShippingAddressFactory.buildShippingAddress(1l, LocalTime.of(9, 52), "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");


    }

    @Test
    void a_create() {

        Address createdBillingAdress = addressService.create(shippingAddress);
        assertNotNull(createdBillingAdress);
        Address createdShippingAdress = addressService.create(billingAddress);
        assertNotNull(createdShippingAdress);
    }


    @Test
    void b_read() {
        Address shippingAdress = addressService.read(1l);
        assertNotNull(shippingAdress);
        System.out.println(shippingAdress);

        Address billingAdress = addressService.read(2l);
        assertNotNull(billingAdress);
        System.out.println(billingAdress);
    }

    @Disabled
    @Test
    void c_update() {

      Address newshippingAdress  = new  ShippingAddress.ShippingAddressBuilder().copy(shippingAddress).setCity("Kookstaad").build();
      Address updatedShippingAdress = addressService.update(newshippingAdress);
      assertNotEquals(shippingAddress,  updatedShippingAdress);
        System.out.println(updatedShippingAdress);

    }

    @Test
    void c_delete() {
        addressService.delete(3l);
    }


    @Test
    void d_getall() {
        List<Address> allAddresses = addressService.getall();
        for (Address address : allAddresses) {
            System.out.println(address);
        }
    }

}
