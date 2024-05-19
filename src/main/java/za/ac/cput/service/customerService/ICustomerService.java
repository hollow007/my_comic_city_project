package za.ac.cput.service.customerService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.IService;

import java.util.List;
@Service
public interface ICustomerService extends IService<Customer, Long> {
    List<Customer> getall();
}
