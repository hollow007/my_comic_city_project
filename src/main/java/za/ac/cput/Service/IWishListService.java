package za.ac.cput.Service;

import za.ac.cput.domain.WishList;

import java.util.List;

public interface IWishListService extends IService<WishList,Long> {
    List<WishList>getall();
}
