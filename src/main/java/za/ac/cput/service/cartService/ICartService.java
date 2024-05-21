package za.ac.cput.service.cartService;

import za.ac.cput.domain.Cart;
import za.ac.cput.service.IService;

import java.util.List;
/**
 * Mpumzi Mbula
 * 219053324
 * 19/05/2024
 */
public interface ICartService extends IService<Cart,Long> {
    List<Cart> getall();

}
