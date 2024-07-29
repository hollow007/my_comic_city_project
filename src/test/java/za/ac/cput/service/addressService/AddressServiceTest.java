package za.ac.cput.service.addressService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.factory.BillingAddressFactory;
import za.ac.cput.factory.ShippingAddressFactory;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceTest {

    Address billingAddress_in;
    Address billingAddress_out;
    Address billingAddress_updated;

    Address shippingAddress_in;
    Address shippingAddress_out;
    Address shippingAddress_updated;

    @Autowired
    private EntityManager entityManagerger;

    @Autowired
    BillingAddressService billingAddressService;
    @Autowired
    ShippingAddressService shippingAddressService;
    @Autowired
    AddressService addressService;

    @BeforeEach
    void setUp() {
        shippingAddress_in = ShippingAddressFactory.buildShippingAddress(LocalTime.of(13,00, 00), "109 Kloof Street" , "Gardens" , "8000", "Cape Town");
        billingAddress_in = BillingAddressFactory.buildBillingAddress("EFT", "1 Gore Street" , "Parade", "8000","Cape Town");

    }

    // Billing Address Tests

    @Test
    void a_createBillingAddress() {
        billingAddress_out = addressService.create(billingAddress_in);
        assertNotNull(billingAddress_out.getId());
        System.out.println("===========Created Billing Address========");
        System.out.println(billingAddress_out);
    }

    @Test
    void b_readBillingAddress() {
        billingAddress_out = addressService.read(billingAddress_in.getId());
        assertNotNull(billingAddress_out);
        System.out.println("===========Billing Address from Database========");

       Long billingId_in = billingAddress_in.getId();
       Long billingId_out = billingAddress_in.getId();

       assertEquals(billingId_in,billingId_out);
       System.out.println("The address are the same");

    }

    @Test
    void updateBillingAddress() {
        billingAddress_updated = new BillingAddress.BillingAddressBuilder().copy(billingAddress_in).setPostalCode("7000").build();
        addressService.update(billingAddress_updated);
        assertEquals(billingAddress_updated,billingAddress_in);
        System.out.println("===========Updated Billing Address ========");
        System.out.println(billingAddress_updated);

    }

    @Test
    void deleteBillingAddress() {
        addressService.delete(billingAddress_in.getId());
        billingAddress_out = addressService.read(billingAddress_in.getId());
        assertNull(billingAddress_out);
        System.out.println("The  Billing address has been deleted");
    }

    @Test
    void getall(){
        List<Address> addressList = addressService.getall();
        assertNotNull(addressList);
        assertTrue(addressList.size() > 0);
        System.out.println(addressList);
    }

    // Shipping Address Tests

    @Test
    void createShippingAddress() {
        shippingAddress_out = addressService.create(shippingAddress_in);
        assertNotNull(shippingAddress_out.getId());

        System.out.println("========== Created Shipping Address=========");
        System.out.println(shippingAddress_out);
    }

    @Test
    void readShippingAddress() {

        shippingAddress_out = shippingAddressService.read(shippingAddress_out.getId());
        assertNotNull(shippingAddress_out);
        System.out.println("===========Shipping Address from Database========");
        System.out.println(shippingAddress_out + "ID: " + shippingAddress_in.getId());

        Long shippingId_in = shippingAddress_in.getId();
        Long shippingId_out = shippingAddress_in.getId();

        assertEquals(shippingId_in,shippingId_out);
        System.out.println("The address are the same");
    }

    @Test
    void updateShippingAddress() {
        shippingAddress_updated= new ShippingAddress.ShippingAddressBuilder().copy(shippingAddress_in).setCity("Los Angeles").build();
        addressService.update(shippingAddress_updated);
        assertNotEquals(shippingAddress_updated,shippingAddress_in);
        System.out.println("===========Updated Shipping Address ========");
        System.out.println(shippingAddress_updated);
    }

    @Test
    void deleteShippingAddress() {
        addressService.delete(shippingAddress_in.getId());
        shippingAddress_out = shippingAddressService.read(shippingAddress_in.getId());
        assertNull(shippingAddress_out);
        System.out.println("The  Shipping address has been deleted");
    }







}

