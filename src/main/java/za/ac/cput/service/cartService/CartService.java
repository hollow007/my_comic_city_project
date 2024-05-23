package za.ac.cput.service.cartService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.ComicBookRepository;

import java.util.List;
/**
 * Mpumzi Mbula
 * 219053324
 * 19/05/2024
 */
@Service
public class CartService implements ICartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ComicBookRepository comicBookRepository;

    @Override
    public Cart create(Cart cart) {

        comicBookRepository.saveAll(cart.getComicBookList());



        return cartRepository.save(cart);
    }

    @Override
    public Cart read(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public boolean delete(Long cartId) {
      cartRepository.deleteById(cartId);
        return !cartRepository.existsById(cartId);
    }

    @Override
    public List<Cart> getall() {
        return cartRepository.findAll();
    }
}
