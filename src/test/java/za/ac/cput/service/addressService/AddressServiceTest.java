package za.ac.cput.service.addressService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
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

    private static BillingAddress billingAddress_in;
    private static BillingAddress billingAddress_out;
    private static BillingAddress billingAddress_updated;

    private static Address shippingAddress_in;
    private static Address shippingAddress_out;
    private static Address shippingAddress_updated;

    @PersistenceContext
    private EntityManager entityManagerger;

    private static Long billingAddressId;
    private static Long shippingAddressId;

    @Autowired
    BillingAddressService billingAddressService;
    @Autowired
    ShippingAddressService shippingAddressService;
    @Autowired
    AddressService addressService;

    @BeforeAll
    static void setUp() {
        shippingAddress_in = ShippingAddressFactory.buildShippingAddress(LocalTime.of(18, 0, 0), "109 Kloof Street", "Gardens", "8000", "Cape Town");
        billingAddress_in = BillingAddressFactory.buildBillingAddress("EFT", "1 Gore Street", "Parade", "8000", "Cape Town");

    }

    // Billing Address Tests

    @Test
    void a_createBillingAddress() {
        billingAddress_out = billingAddressService.create(billingAddress_in);
        //entityManagerger.flush();
        assertNotNull(billingAddress_out);
        billingAddressId = billingAddress_out.getId();
        System.out.println("===========Created Billing Address========");
        System.out.println(billingAddress_out + " BillingAddressId_out: " + billingAddress_out.getId() + " vs " + "BillingAddressId_in: " + billingAddress_in.getId());
    }

    @Test
    void b_readBillingAddress() {

        billingAddress_out = billingAddressService.read(2L);
        System.out.println("===========Billing Address from Database========");
        System.out.println("BillingAddress_out" + billingAddress_out);


    }

    @Test
    void c_updateBillingAddress() {
        billingAddress_updated = new BillingAddress.BillingAddressBuilder().copy(billingAddress_in).setPostalCode("7000").build();
        addressService.update(billingAddress_updated);
        assertNotEquals(billingAddress_updated, billingAddress_in);
        System.out.println("===========Updated Billing Address ========");
        System.out.println(billingAddress_updated);

    }

    @Test
    void d_deleteBillingAddress() {
        addressService.delete(2L);
        billingAddress_out = billingAddressService.read(2L);
        assertNull(billingAddress_out);
        System.out.println("The  Billing address has been deleted");
    }

    @Test
    void e_getallBillingAddress() {
        List<BillingAddress> billingAddresses = billingAddressService.getallBillingAddress();
        assertNotNull(billingAddresses);
        assertTrue(billingAddresses.size() > 0);

        int addressListSize = billingAddresses.size();
        while (addressListSize > 0) {
            addressListSize--;
            System.out.println(billingAddresses.get(addressListSize).getSuburb() + "\n");

        }
    }

    // Shipping Address Tests

    @Test
    @Transactional
    @Rollback(false)
    void f_createShippingAddress() {
        shippingAddress_out = addressService.create(shippingAddress_in);
        entityManagerger.flush();
        assertNotNull(shippingAddress_out);

        shippingAddressId = shippingAddress_out.getId();
        System.out.println("========== Created Shipping Address=========");
        System.out.println(shippingAddress_out + "ShippindAddressID: " + shippingAddressId);
    }

    @Test
    void g_readShippingAddress() {

        shippingAddress_out = shippingAddressService.read(6L);
        assertNotNull(shippingAddress_out);
        System.out.println("===========Shipping Address from Database========");
        System.out.println(shippingAddress_out + "ID: " + shippingAddress_out.getId());

    }

    @Test
    void h_updateShippingAddress() {
        shippingAddress_updated = new ShippingAddress.ShippingAddressBuilder().copy(shippingAddress_in).setCity("Los Angeles").build();
        addressService.update(shippingAddress_updated);
        assertNotEquals(shippingAddress_updated, shippingAddress_in);
        System.out.println("===========Updated Shipping Address ========");
        System.out.println(shippingAddress_updated);
    }

    @Test
    void i_deleteShippingAddress() {
        addressService.delete(5L);
        shippingAddress_out = shippingAddressService.read(5L);
        assertNull(shippingAddress_out);
        System.out.println("The  Shipping address has been deleted");
    }

    @Test
    void j_getallShippingAddress() {
        List<ShippingAddress> shippingAddress = shippingAddressService.getallShippingAddress();
        assertNotNull(shippingAddress);
        assertTrue(shippingAddress.size() > 0);

        int addressListSize = shippingAddress.size();
        while (addressListSize > 0) {
            addressListSize--;
            System.out.println(shippingAddress.get(addressListSize).getSuburb() + "\n");

        }


    }
}

