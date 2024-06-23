package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.boot.test.context.SpringBootTest;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.BillingAdress;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.ShippingAddress;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminFactoryTest {


    private Admin admin1;
    private Admin admin2;
    private Admin admin3;


    @BeforeEach
    void setUp() {

        admin1 = AdminFactory.buildAdmin("Faranani","Mokwebo","passWord");
    }

    @Test
    void a_nullObject() {
        admin2 = AdminFactory.buildAdmin("Faranani","", "passWord");
        assertNull(admin2);
    }

    @Test
    void b_goodObject() {
        admin3 = AdminFactory.buildAdmin("Faranani","Joshua","mokwebo","passWord");
        assertNotNull(admin3);
        System.out.println("object created: "+admin3);
    }


    @Test
    void c_NotEuqalObjects() {
        admin3 = AdminFactory.buildAdmin("Joshua","Paten","password");
        assertNotEquals(admin1, admin3);

    }
}