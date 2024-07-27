package za.ac.cput.service.addressService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.factory.ShippingAddressFactory;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceTest {

    ShippingAddress shippingAddress;
    ShippingAddress shippingAddress2;
    BillingAddress billingAddress;
    BillingAddress billingAddress2;

    @Autowired
    AddressService addressService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getallShippingAddress() {
    }
}