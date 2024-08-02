package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.service.addressService.BillingAddressService;

@RestController

public class BillingAddressController {

    @Autowired
    private BillingAddressService billingAddressService;

    @RequestMapping("/billing_address")
    public void entry(){
        System.out.println("Hello There , welcome to the billing address controller");}

    @PostMapping("/create")
    public BillingAddress createBillingAddressService(@RequestBody BillingAddress billingAddress) {
        System.out.println("creating Billing Address ...");
        return billingAddressService.create(billingAddress);
    }

    @GetMapping("/{id}")
    public BillingAddress getBillingAddressService(@PathVariable Long id) {

       BillingAddress read_billingAddres = billingAddressService.read(id);
        System.out.println(read_billingAddres);
       return read_billingAddres;

    }

    @PutMapping("/{payment_method}")
    public BillingAddress updateBillingAddressService(@PathVariable String payment_method, @RequestBody BillingAddress billingAddress) {

        billingAddress = new BillingAddress.BillingAddressBuilder().copy(billingAddress).setPaymentMethod(payment_method).build();
        return billingAddressService.update(billingAddress);

    }

    @DeleteMapping("/{id}")
    public void deleteBillingAddressService(@PathVariable Long id) {
        billingAddressService.delete(id);
    }






}
