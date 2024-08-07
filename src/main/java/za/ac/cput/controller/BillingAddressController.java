package za.ac.cput.controller;

import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.service.addressService.BillingAddressService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/billing_address")
public class BillingAddressController {

    private BillingAddressService billingAddressService;
    BillingAddressController(BillingAddressService billingAddressService){this.billingAddressService = billingAddressService;}


    @GetMapping("/Welcome")
    public String welome(){
        return "Hello There ! Welcome to the Billing Address Service";
    }

    @PostMapping("/create")
    public BillingAddress createBillingAddressService(@RequestBody BillingAddress billingAddress) {
        System.out.println("creating Billing Address ...");
        BillingAddress savedBillingAddress =  billingAddressService.create(billingAddress) ;
        System.out.println(savedBillingAddress);
        return savedBillingAddress;
    }

    @GetMapping("/read/{id}")
    public BillingAddress readBillingAddressService(@PathVariable Long id) {

       BillingAddress read_billingAddress = billingAddressService.read(id);
       System.out.println(read_billingAddress);
       return read_billingAddress;

    }

    @PostMapping ("/update")
    public BillingAddress updateBillingAddressService(@RequestBody BillingAddress billingAddress) {
        return billingAddressService.update(billingAddress);

    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBillingAddressService(@PathVariable Long id) {
        return billingAddressService.delete(id);
    }

    @GetMapping("/getall")
    public List<BillingAddress> getall(){return billingAddressService.getallBillingAddress();}

}
