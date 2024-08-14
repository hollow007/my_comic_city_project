package za.ac.cput.service.cartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.ComicBookRepository;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class CartService implements ICartService {
    private CartRepository cartRepository;
private ComicBookRepository comicBookRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerRepository customerRepository, ComicBookRepository comicBookRepository) {
        this.cartRepository = cartRepository;
        this.comicBookRepository=comicBookRepository;

    }

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart read(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        System.out.println(cart);
        comicBookRepository.saveAll(cart.getComicBooks());
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

    public double getCartTotalPrice(Long cartId){
        return cartRepository.calculateCartTotalPrice(cartId);
    }
    public int quantity(Long cartId){
        return cartRepository.numberOfBooksOnThisCart(cartId);
    }
}
