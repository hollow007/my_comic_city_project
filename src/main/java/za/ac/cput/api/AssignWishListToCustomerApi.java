package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.WishList;
import za.ac.cput.factory.WishListFactory;
import za.ac.cput.service.customerService.CustomerService;
import za.ac.cput.service.wishListService.WishListService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AssignWishListToCustomerApi {
    private CustomerService customerService;
    private WishListService wishListService;

    @Autowired
    public AssignWishListToCustomerApi(CustomerService customerService, WishListService wishListService) {
        this.customerService = customerService;
        this.wishListService = wishListService;
    }

    public WishList assignWishListToCustomer(Long customerId) {

        if (customerId > 0) {

            Customer customer = customerService.read(customerId);

            if (customer != null) {

                WishList newWishList = new WishList.Builder()
                        .setWishListId(1L)
                        .setCustomer(customer)
                        .setWishListName("MyList")
                        .setCreatedDate(LocalDate.now())
                        .setUpdatedDate(LocalDate.now())
                        .build();

                WishList assignedWishList = wishListService.create(newWishList);
                System.out.println("Assigned WishList" + assignedWishList);

                return assignedWishList;
            }
            throw new NullPointerException(" No Customer for specified Id" + customerId);
        }
        throw new IllegalArgumentException("Invalid Customer Id " + customerId);
    }

}
