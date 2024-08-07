package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.service.addressService.ShippingAddressService;

import java.util.List;

@RestController
@RequestMapping("/shipping_address")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    ShippingAddressController(ShippingAddressService shippingAddressService){this.shippingAddressService = shippingAddressService;}

    @GetMapping("/Welcome")
    public String welcome(){return "Hello There! Welcome to the shipping Address Service";}

    @PostMapping("/create")
    public ShippingAddress createShippingAddress(@RequestBody ShippingAddress shippingAddress){
        System.out.println("creating Shipping Address ...");
       return shippingAddressService.create(shippingAddress);

    }

    @GetMapping("/read/{id}")
    public ShippingAddress readShippingAddress(@PathVariable Long id){
        ShippingAddress read_billingAddress = shippingAddressService.read(id);
        return shippingAddressService.read(id);
    }

    @PostMapping("/update")
    public ShippingAddress updateShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        System.out.println("updating Shipping Address ...");
        return shippingAddressService.update(shippingAddress);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteShippingAddress (@PathVariable Long id) {
        return shippingAddressService.delete(id);
    }

    @GetMapping("/getall")
    public List<ShippingAddress> getall(){return shippingAddressService.getallShippingAddress();}


}
