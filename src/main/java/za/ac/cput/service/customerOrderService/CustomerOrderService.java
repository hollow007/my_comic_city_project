package za.ac.cput.service.customerOrderService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.repository.CustomerOrderRepository;

import java.util.List;

@Service
public class CustomerOrderService implements ICustomerOrderService {

    private CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }
    @Override
    public CustomerOrder create(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    @Override
    public CustomerOrder read(String id) {
       return customerOrderRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerOrder update(CustomerOrder customerOrder) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        customerOrderRepository.deleteById(id);
        return !customerOrderRepository.existsById(id);
    }

    @Override
    public List<CustomerOrder> getall() {
        return customerOrderRepository.findAll();
    }
}
