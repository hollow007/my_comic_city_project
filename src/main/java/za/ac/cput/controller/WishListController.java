package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.WishList;

import za.ac.cput.service.wishListService.WishListService;

import java.util.List;

@RestController
@RequestMapping("/wishList")
public class WishListController {
private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }


    @PostMapping("/create")
    public WishList create(@RequestBody WishList WishList) {
        return wishListService.create(WishList);
    }

    @GetMapping("/read/{wishListId}")
    public WishList read(@PathVariable("wishListId") Long wishListId) {
        return wishListService.read(wishListId);
    }

    @PostMapping("/update")
    public WishList update(@RequestBody WishList WishList) {
        return wishListService.update(WishList);
    }

    @DeleteMapping("delete/{wishListId}")
    public boolean delete(@PathVariable("wishListId") Long wishListId) {
        return wishListService.delete(wishListId);
    }

    @GetMapping("/getall")
    public List<WishList> getall() {
        return wishListService.getall();
    }

    @GetMapping("/quantity/{wishListId}")
    public int quantity(@PathVariable("wishListId") Long wishListId) {
        return wishListService.calculateQuantity(wishListId);
    }
}
