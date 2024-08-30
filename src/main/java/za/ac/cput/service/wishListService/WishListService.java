package za.ac.cput.service.wishListService;

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
    public WishList create(WishList wishList) {
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
    public boolean delete(Long wishListId) {
        wishListRepository.deleteById(wishListId);
        return !wishListRepository.existsById(wishListId);
    }

    @Override
    public List<WishList> getall() {
        return wishListRepository.findAll();
    }

    public int calculateQuantity(Long wishListId) {
        return wishListRepository.numberOfBooksOnThisWishList(wishListId);
    }

    public WishList getWishListWithCustomerEmail(String email) {
        return wishListRepository.findByCustomer_Contact_Email(email);
    }
}
