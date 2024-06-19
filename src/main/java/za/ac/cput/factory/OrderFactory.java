//package za.ac.cput.factory;
//
//import za.ac.cput.domain.ComicBook;
//import za.ac.cput.domain.Customer;
//import za.ac.cput.domain.Order;
//import za.ac.cput.domain.User;
//import za.ac.cput.util.Helper;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public class OrderFactory {
//    public static Order buildOrder(String orderId, LocalDate orderDate, Customer user, List<ComicBook> comicBooks, double totalAmount) {
//        if (Helper.isStringNullorEmpty(orderId) || user == null || comicBooks == null || comicBooks.isEmpty() || totalAmount <= 0.0 || !Helper.isValidDate(orderDate)) {
//            return null;
//        }
//
//        return new Order.OrderBuilder()
//                .setOrderId(orderId)
//                .setOrderDate(orderDate)
//                .setUser(user)
//                .setComicBooks(comicBooks)
//                .setTotalAmount(totalAmount)
//                .build();
//    }
//}
//
