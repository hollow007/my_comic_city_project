package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
//

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.BillingAdress;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.ShippingAddress;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ContactFactoryTest {

    private Contact con1;
    private  Contact con2;
    private  Contact con3;

    private BillingAdress billingAddress;

    private ShippingAddress shippingAddress;


    @Test
    @BeforeEach
    void setUp() {
        billingAddress = new BillingAddressFactory().
                buildBillingAddress("card","Email" , "34 Batersea Drive", "Kibbler park" , "2091" , "Johannesburg");
        System.out.println(billingAddress);

        shippingAddress = new ShippingAddressFactory().buildShippingAddress(LocalTime.of(10, 20),"M.Mbuyazi" , "34 Batersea Drive", "Kibbler park" , "2091" , "Johannesburg");
        System.out.println(shippingAddress);

        con1 = ContactFactory.buildContact("mblungisi@gmail.com", "0739946042",  shippingAddress , billingAddress);

        con2 = ContactFactory.buildContact("2-mycput.za", "0739946042",  shippingAddress , billingAddress);

        con3 = ContactFactory.buildContact("22...@mycput.ac.za", "073994u042", shippingAddress , billingAddress );

    }

    @Test
    void buildEmployeeWithValidDetails() {
        assertNotNull(con1);
        System.out.println(con1);

    }

    @Test
    void buildEmployeeWithIncorrectEmail() {
        assertNull(con2);
        System.out.println(con2);

    }

    @Test
    void buildEmployeeWithIncorrectEmail2() {
        assertNull(con3);
        System.out.println(con3);

    }
}