package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.service.addressService.BillingAddressService;

@RestController
@RequestMapping("/billing_address")
public class BillingAddressController {

    @Autowired
    private BillingAddressService billingAddressService;

    @PostMapping("/create")
    public BillingAddress createBillingAddressService(@RequestBody BillingAddress billingAddress) {
        System.out.println("creating Billing Address ...");
        return billingAddressService.create(billingAddress);
    }

    @GetMapping("/read/{id}")
    public BillingAddress readBillingAddressService(@PathVariable Long id) {

       BillingAddress read_billingAddress = billingAddressService.read(id);
        System.out.println(read_billingAddress);
       return read_billingAddress;

    }

    @PutMapping("/update/{payment_method}")
    public BillingAddress updateBillingAddressService(@PathVariable String payment_method, @RequestBody BillingAddress billingAddress) {

        billingAddress = new BillingAddress.BillingAddressBuilder().copy(billingAddress).setPaymentMethod(payment_method).build();
        return billingAddressService.update(billingAddress);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteBillingAddressService(@PathVariable Long id) {
        billingAddressService.delete(id);
    }






}
