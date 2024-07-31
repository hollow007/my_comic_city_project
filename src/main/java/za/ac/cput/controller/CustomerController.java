package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.customerService.CustomerService;

import java.util.List;

@RestController

@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return service.create(customer);
    }

    @GetMapping("/read/{customerId}")
    public Customer read(@PathVariable long customerId){
        return service.read(customerId);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return service.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }

    @GetMapping("/getall")
    public List<Customer> getall(){
        return service.getall();
    }

}
