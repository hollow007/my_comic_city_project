package za.ac.cput.service.wishListService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.WishList;
import za.ac.cput.service.IService;

import java.util.List;
@Service
public interface IWishListService extends IService<WishList,Long> {

    List<WishList>getall();
}
