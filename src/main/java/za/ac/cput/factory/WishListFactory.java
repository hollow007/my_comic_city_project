package za.ac.cput.factory;

import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.WishList;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

public class WishListFactory {
    public static  WishList buildWishList(String wishListName, List<ComicBook> comicBookList, LocalDate createdDate, LocalDate updatedDate){
        if(Helper.isStringNullorEmpty(wishListName)||Helper.isListNullorEmpty(comicBookList)|| !Helper.isNotAfter(createdDate,LocalDate.now())||Helper.isValidDate(updatedDate)){
            return null;
        }
        return new WishList.Builder().setWishlistName(wishListName)
                .setComicBooks(comicBookList)
                .setCreatedDate(createdDate)
                .setUpdatedDate(updatedDate)
                .build();
    }
}
