package za.ac.cput.service.wishListService;

import za.ac.cput.domain.WishList;
import za.ac.cput.service.IService;

import java.util.List;

public interface IWishListService extends IService<WishList,Long> {

    List<WishList>getall();
}
