package za.ac.cput.service.cartService;

import za.ac.cput.domain.Cart;
import za.ac.cput.service.IService;

import java.util.List;

public interface ICartService extends IService<Cart,Long> {

    List<Cart>getall();



}
