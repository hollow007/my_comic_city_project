package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
//import za.ac.cput.factory.OrderFactory.buildorder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
/* InvoiceFactoryTest.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 21 June 2024
   https://github.com/hollow007/my_comic_city_project
 */

/*class InvoiceFactoryTest {

    private Order order1;
    private Order order2;
    private Order order3;

    private Invoice invoice1;
    private Invoice invoice2;
    private Invoice invoice3;
    private List<ComicBook> comicBooks;
    private Contact contact;
    private Cart cart;
    private WishList wishlist;


    @BeforeEach
    void setUp() {
        Customer customer1 = CustomerFactory.buildCustomer(1L, "john","doe",contact,cart,wishlist);
        Customer customer2 = CustomerFactory.buildCustomer(2L, "frank","castle",contact,cart,wishlist);
        Customer customer3 = CustomerFactory.buildCustomer(3L, "sammy","gravano",contact,cart,wishlist);

       // order1 = OrderFactory.buildOrder("1AAL", LocalDate.now(), customer1, comicBooks, 50.00);
        //order2 = OrderFactory.buildOrder("2AAL", LocalDate.now(), customer2, comicBooks, 50.00);
       // order3 = OrderFactory.buildOrder("3AAL", LocalDate.now(), customer3, comicBooks, 50.00);

        invoice1 = InvoiceFactory.buildInvoice(1L, LocalDateTime.now(), order1);
        invoice2 = InvoiceFactory.buildInvoice(2L, LocalDateTime.of(2024, 07, 17), order2);
        invoice3 = InvoiceFactory.buildInvoice(3L, LocalDateTime.now(), null);
    }

    @Test
    void buildInvoice() {
        assertNotNull(invoice1);
        System.out.println(invoice1);
    }

    @Test
    void buildInvoiceWithFutureDateMustFail() {
        assertNull(invoice2);
        System.out.println(invoice2);
    }

    @Test
    void buildInvoiceWithNullOrderMustFail() {
        assertNull(invoice3);
        System.out.println(invoice3);
    }
}*/