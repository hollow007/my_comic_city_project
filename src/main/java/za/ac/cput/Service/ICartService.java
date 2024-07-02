package za.ac.cput.Service;

import za.ac.cput.domain.Cart;

import java.util.List;

public interface ICartService extends IService<Cart,Long>{
    List<Cart>getall();

}
