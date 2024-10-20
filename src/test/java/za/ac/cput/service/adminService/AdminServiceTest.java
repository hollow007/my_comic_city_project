package za.ac.cput.service.adminService;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.adminService.AdminService;
import za.ac.cput.service.contactService.ContactService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminServiceTest {
    @Autowired
    private AdminService service;

    @Autowired
    private ContactService contactService;


    private Admin admin1;
    private Admin admin2;

    private List<Publisher> publishers;

    static Admin savedAdmin1;
    static Admin savedAdmin2;
    @BeforeEach
    void setUp() {

        Address billingAddress = BillingAddressFactory.buildBillingAddress("card", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(billingAddress);

        Address shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.of(9, 52), "33 sea Drive", "Kibbler park 2", "2092", "Johannesburg");
        System.out.println(shippingAddress);

        Address billingAddress2 = BillingAddressFactory.buildBillingAddress("card", "34 sea Drive", "Kibb park 2", "2092", "Johannesburg");
        System.out.println(billingAddress);

        Address shippingAddress2 = ShippingAddressFactory.buildShippingAddress(LocalTime.of(9, 52), "33 sea Drive 2", "Kibbler park 2", "2092", "Johannesburg");
        System.out.println(shippingAddress);

        Contact con1 = CustomerContactFactory.buildContact("admin1@gmail.com", "0739946042", shippingAddress, billingAddress);
        System.out.println(con1);

        Contact con2 = CustomerContactFactory.buildContact("admin2@gmail.com", "0739946042", shippingAddress2, billingAddress2);

        admin1 = AdminFactory.buildAdmin("Leroy", "Kulcha", "Liam", "ad1@123", con1);
        admin2 = AdminFactory.buildAdmin("James", "Kulcha", "Jimmy", "ad2@123", con2);
    }

    @Test
    @Order(1)
    void create() {
        System.out.println("===========================CREATE========================================");
        contactService.create(admin1.getContact());
        savedAdmin1 = service.create(admin1);
        assertNotNull(admin1);
        System.out.println(savedAdmin1);

        contactService.create(admin2.getContact());
        savedAdmin2 = service.create(admin2);
        assertNotNull(admin2);
        System.out.println(savedAdmin2);


    }

    @Test
    @Order(2)
    void read() {
        System.out.println("===========================READ========================================");
        Admin readAdmin = service.read(savedAdmin2.getUserId());
        assertNotNull(readAdmin);
        System.out.println(readAdmin);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("===========================UPDATE========================================");
        Admin updateAdmin = new Admin.AdminBuilder().copy(savedAdmin1)
                .setPassword("l2@123")
                .build();

        Admin savedAdmin = service.update(updateAdmin);
        assertEquals(savedAdmin.getUserId(), updateAdmin.getUserId());
        assertNotNull(savedAdmin);
        System.out.println(savedAdmin);
    }
    @Test
    @Order(4)
    void delete(){
        boolean isDeleted = service.delete(Long.valueOf(savedAdmin1.getUserId()));
        assertTrue(isDeleted);
        System.out.println("Customer no " + savedAdmin1.getUserId() + " deleted");
    }
    @Test
    @Order(5)
    void getall(){
        System.out.println("==================================GET ALL===========================");
        System.out.println(service.getAll());
    }
//    @Test
//    @Order(6)
//    void getByEmail(){
//        System.out.println("==================================GET By Email===========================");
//        Customer customer=service.("vxayiya@gmail.com");
//        assertNotNull(customer);
//        System.out.println(customer);
//    }

}