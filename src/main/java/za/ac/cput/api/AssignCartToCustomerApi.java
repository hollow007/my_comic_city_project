package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.cartService.CartService;
import za.ac.cput.service.customerService.CustomerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AssignCartToCustomerApi {
    //My goal here is to assign a cart to a customer as soon as its is created
    CustomerService customerService;
    CartService cartService;

    @Autowired
    public AssignCartToCustomerApi(CustomerService customerService, CartService cartService) {
        this.customerService = customerService;
        this.cartService = cartService;
    }

    public  Cart assignCartToCustomer(Long customerId) {

        System.out.println("Before Assigning Customer To Cart");
        System.out.println("Customer Id To assign: "+customerId);

        if (customerId > 0) {

            Customer customer = customerService.read(customerId);
            System.out.println("Fetched Customer To be assigned:"+customer);

            List<ComicBook> comicBookList = new ArrayList<>();

            Cart newCart = new Cart.Builder()
                    .setCartId(1L)
                    .setComicBooks(comicBookList)
                    .setCustomer(customer)
                    .setCreatedDate(LocalDate.now())
                    .setUpdatedDate(LocalDate.now())
                    .build();
            System.out.println("Cart Assigned:");

            Cart cartFromDB=cartService.create(newCart);

            return cartFromDB;
        }

        throw new IllegalArgumentException();

    }


}
