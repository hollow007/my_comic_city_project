package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.WishList;
import za.ac.cput.repository.WishListRepository;

import java.util.List;

@Service
public class WishListService implements IWishListService {
    private WishListRepository wishListRepository;

    @Autowired
    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public WishList save(WishList wishList) {
     return wishListRepository.save(wishList);
    }

    @Override
    public WishList read(Long wishListId) {
        return wishListRepository.findById(wishListId).orElse(null);
    }

    @Override
    public WishList update(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public void delete(Long wishListId) {
        wishListRepository.deleteById(wishListId);
    }

    @Override
    public List<WishList> getall() {
        return wishListRepository.findAll();
    }
}
