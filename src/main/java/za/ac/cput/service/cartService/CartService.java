package za.ac.cput.service.cartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.ComicBookRepository;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.comicBookService.ComicBookService;
import za.ac.cput.service.customerService.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService {
    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
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

    public double getCartTotalPrice(Long cartId) {
        return cartRepository.calculateCartTotalPrice(cartId);
    }

    public int quantity(Long cartId) {
        return cartRepository.numberOfBooksOnThisCart(cartId);
    }

    public Cart getCartByCustomerEmail(String email) {
        return cartRepository.findCartByCustomer_ContactEmail(email);
    }
}
