package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.service.cartService.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/create")
    public Cart create(@RequestBody Cart cart){
        return cartService.create(cart);
    }

    @GetMapping("/read/{cartId}")
    public Cart read(@PathVariable long cartId){
        return cartService.read(cartId);
    }

    @PostMapping("/update")
    public Cart update(@RequestBody Cart cart){
        return cartService.update(cart);
    }

    @DeleteMapping("/delete/{cartId}")
    public boolean delete(long cartId){

        return cartService.delete(cartId);
    }

    @GetMapping("/getall")

    public List<Cart> getall(){
        return cartService.getall();
    }

}
