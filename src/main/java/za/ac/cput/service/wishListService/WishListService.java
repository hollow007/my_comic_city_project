package za.ac.cput.service.wishListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.WishList;
import za.ac.cput.repository.ComicBookRepository;
import za.ac.cput.repository.WishListRepository;

import java.util.List;
/**
 * Mpumzi Mbula
 * 219053324
 * 19/05/2024
 */
@Service
public class WishListService implements IWishListService{

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
   private ComicBookRepository comicBookRepository;

    @Override
    public WishList create(WishList wishList) {
        comicBookRepository.saveAll(wishList.getComicBooks());
        return wishListRepository.save(wishList);
    }

    @Override
    public WishList read(Long aLong) {
   return wishListRepository.findById(aLong).orElse(null);
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
}
