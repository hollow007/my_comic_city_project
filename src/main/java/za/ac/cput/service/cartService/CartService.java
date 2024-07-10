package za.ac.cput.service.cartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.ComicBookRepository;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class CartService implements ICartService {
    private CartRepository cartRepository;


    @Autowired
    public CartService(CartRepository cartRepository,CustomerRepository customerRepository,ComicBookRepository comicBookRepository) {
        this.cartRepository = cartRepository;

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
