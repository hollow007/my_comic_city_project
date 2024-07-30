package za.ac.cput.factory;

import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

public class CustomerOrderFactory {
    public static CustomerOrder buildCustomerOrder(String orderId, Long customerId, LocalDate orderDate,List<ComicBook> comicBooks, double totalAmount) {
        if (Helper.isStringNullorEmpty(orderId) || customerId<=0 || Helper.isValidDate(orderDate)
    || comicBooks == null || comicBooks.isEmpty() || totalAmount <= 0.0 || Helper.isValidDate(orderDate)) {
            return null;
        }

        return new CustomerOrder.CustomerOrderBuilder()
                .setOrderId(orderId)
                .setOrderDate(orderDate)
                .setCustomer(customerId)
                .setComicBooks(comicBooks)
                .setTotalAmount(totalAmount)
                .build();
    }
}

