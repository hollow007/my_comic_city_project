package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.service.customerOrderService.CustomerOrderService;

import java.util.List;

@RestController
@RequestMapping("/CustomerOrder")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/create")
    public CustomerOrder create(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.create(customerOrder);
    }

    @GetMapping("/read/{customerOrderId}")
    public CustomerOrder read(@PathVariable String id) {
        return customerOrderService.read(id);
    }

    @PostMapping("/update")
    public CustomerOrder update(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.update(customerOrder);
    }

    @DeleteMapping("/delete/{customerId}")
    public void delete(@PathVariable String customerId) {
        customerOrderService.delete(customerId);
    }

    @GetMapping
    public List<CustomerOrder> findAll() {
        return customerOrderService.getall();
    }
}
