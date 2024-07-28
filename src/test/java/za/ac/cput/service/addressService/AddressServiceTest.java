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

    Address shippingAddress_in;
    Address shippingAddress_out;
    Address billingAddress_in;
    Address billingAddress_out;
    Address billingAddress_updated;
    Address shippingAddress_updated;

    @Autowired
    private EntityManager entityManagerger;

    Address address;

    @Autowired
    AddressService addressService;

    @BeforeEach
    void setUp() {
        shippingAddress_in = ShippingAddressFactory.buildShippingAddress(LocalTime.of(13,00, 00), "109 Kloof Street" , "Gardens" , "8000", "Cape Town");
        billingAddress_in = BillingAddressFactory.buildBillingAddress("EFT", "1 Gore Street" , "Parade", "8000","Cape Town");

    }

    @Test
    @Transactional
    @Rollback(false)
    void a_create() {
        shippingAddress_out = addressService.create(shippingAddress_in);
        //entityManagerger.persist(shippingAddress_in);
       // entityManagerger.flush();
        assertNotNull(shippingAddress_out.getId());

        System.out.println("========== Created Shipping Address=========");
        System.out.println(shippingAddress_out);

        billingAddress_out = addressService.create(billingAddress_in);
        //entityManagerger.persist(billingAddress_in);
        //entityManagerger.flush();
        assertNotNull(billingAddress_out.getId());
        System.out.println("===========Created Billing Address========");
        System.out.println(billingAddress_out);
    }

    @Test
    void b_read() {
        //billingAddress_out = entityManagerger.find(BillingAddress.class, billingAddress_in.getId());
        Address billingAddress3 = addressService.read(shippingAddress_in.getId());
        assertNotNull(billingAddress3);
        System.out.println("===========Billing Address from Database========");

       Long billingId_in = billingAddress_in.getId();
       Long billingId_out = billingAddress_in.getId();

       assertEquals(billingId_in,billingId_out);
       System.out.println("The address are the same");



        shippingAddress_out = addressService.read(shippingAddress_out.getId());
        assertNotNull(shippingAddress_out);
        System.out.println("===========Shipping Address from Database========");
        System.out.println(shippingAddress_out + "ID: " + shippingAddress_in.getId());

        Long shippingId_in = shippingAddress_in.getId();
        Long shippingId_out = shippingAddress_in.getId();

        assertEquals(shippingId_in,shippingId_out);
        System.out.println("The address are the same");


    }

    @Test
    void update() {
        shippingAddress_updated= new ShippingAddress.ShippingAddressBuilder().copy(shippingAddress_in).setCity("Los Angeles").build();
        addressService.update(shippingAddress_updated);
        assertNotEquals(shippingAddress_updated,shippingAddress_in);
        System.out.println("===========Updated Shipping Address ========");
        System.out.println(shippingAddress_updated);

        billingAddress_updated = new BillingAddress.BillingAddressBuilder().copy(billingAddress_in).setPostalCode("7000").build();
        addressService.update(billingAddress_updated);
        assertEquals(billingAddress_updated,billingAddress_in);
        System.out.println("===========Updated Billing Address ========");
        System.out.println(billingAddress_updated);


    }

    @Test
    void delete() {
        addressService.delete(shippingAddress_in.getId());
        shippingAddress_out = addressService.read(shippingAddress_in.getId());
        assertNull(shippingAddress_out);
        System.out.println("The  Shipping address has been deleted");

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
}

