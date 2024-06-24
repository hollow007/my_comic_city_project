package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private Customer customer1;
    private Customer customer2;
    @BeforeEach
    public void setUp(){

        Address billingAddress = new BillingAddressFactory().
                buildBillingAddress("card", "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(billingAddress);

        Address shippingAddress = new ShippingAddressFactory().buildShippingAddress(LocalTime.parse("10:30:00"), "34 Batersea Drive", "Kibbler park", "2091", "Johannesburg");
        System.out.println(shippingAddress);

        Contact con1 = CustomerContactFactory.buildContact("leroyk@gmail.com", "0739946042", shippingAddress, billingAddress);


        Contact con2 = CustomerContactFactory.buildContact("2-mycput.za", "0739946042",  shippingAddress , billingAddress);
        customer1 = CustomerFactory.buildCustomer(1234,"Leroy" , "Kulcha", "","Lkulcha123",con1);
        customer2 = CustomerFactory.buildCustomer(1234,"James" , "Kulcha", "Liam","jkulcha456",con2);

    }

    @Test
    void buildCustomer() {
        assertNotNull(customer1);
        System.out.println(customer1);
    }
    @Test
    @Disabled
    void failingBuildCustomer(){
        assertNotNull(customer2);
        System.out.println(customer2);
    }
}