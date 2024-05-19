package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.WishList;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer buildCustomer(long customerId, String firstName, String lastName, Contact contact, Cart cart, WishList wishList){
        if(customerId<=0 || Helper.isStringNullorEmpty(firstName)
                || Helper.isStringNullorEmpty(lastName) ||contact == null
                || cart == null || wishList == null){
            return null;
        }
        return new Customer.CustomerBuilder()
                .setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .setCart(cart)
                .setWishList(wishList)
                .build();

    }
}
