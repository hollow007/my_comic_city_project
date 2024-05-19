package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.ComicBook;

import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

public class CartFactory {
    public static Cart buildCart(double totalPrice, List<ComicBook> comicBooks, LocalDate createdDate, LocalDate updatedDate) {
        if (Helper.isValidPrice(totalPrice) || Helper.isComicBooksListNullOrEmpty(comicBooks) ||!Helper.isNotAfter(createdDate, LocalDate.now()) || Helper.isValidDate(updatedDate)) {
            return null;
        }
        return new Cart.Builder().setTotalPrice(totalPrice)
                .setComicBookList(comicBooks)
                .setCreatedDate(createdDate)
                .setUpdatedDate(updatedDate)
                .build();
    }
}
