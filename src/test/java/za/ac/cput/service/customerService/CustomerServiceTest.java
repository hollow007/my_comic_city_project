package za.ac.cput.service.customerService;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {
    @Autowired
    private CustomerService service;


    private Customer customer1;
    private Customer customer2;

    private List<Publisher> publishers;

    @BeforeEach
    void setUp() {

        Address billingAddress = BillingAddressFactory.buildBillingAddress("card", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(billingAddress);

        Address shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.of(9, 52), "33 sea Drive", "Kibbler park 2", "2092", "Johannesburg");
        System.out.println(shippingAddress);

        Contact con1 = CustomerContactFactory.buildContact("leroy@gmail.com", "0739946042", shippingAddress, billingAddress);
        System.out.println(con1);

        Contact con2 = CustomerContactFactory.buildContact("2-mycput.za", "0739946042", shippingAddress, billingAddress);

        customer1 = CustomerFactory.buildCustomer(1234, "Leroy", "Kulcha", "Liam", "Lkulcha123", con1);
        customer2 = CustomerFactory.buildCustomer(4567, "James", "Kulcha", "", "jkulcha456", con2);
    }



        @Test
    @Order(1)
    void create() {
        System.out.println("===========================CREATE========================================");
    Customer savedCustomer = service.create(customer1);
    assertNotNull(savedCustomer);
    System.out.println(savedCustomer);

//    Customer savedCustomer2 = service.create(customer2);
//    assertNotNull(savedCustomer2);
//    System.out.println(savedCustomer2);


    }

    @Test
    @Order(2)
    void read() {
        System.out.println("===========================READ========================================");
        Customer readCustomer = service.read(Long.valueOf(1234));
        assertNotNull(readCustomer);
        System.out.println(readCustomer);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println("===========================UPDATE========================================");
        Customer updateCustomer = new Customer.CustomerBuilder().copy(customer1)
                .setPassword("lkulcha456")
                .build();

        Customer savedCustomer = service.update(updateCustomer);
        assertEquals(savedCustomer.getCustomerId(), updateCustomer.getCustomerId());
        assertNotNull(savedCustomer);
        System.out.println(savedCustomer);
    }
    @Test
    @Order(4)
    void delete(){
//        boolean isDeleted = service.delete(Long.valueOf(customer1.getCustomerId()));
//        assertTrue(isDeleted);
        System.out.println("Customer no " + customer1.getCustomerId() + " deleted");
    }
    @Test
    @Order(5)
    void getall(){
        System.out.println("==================================GET ALL===========================");
        System.out.println(service.getall());
    }

}