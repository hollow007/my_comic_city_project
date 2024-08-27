package za.ac.cput.service.customerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private CustomerRepository repository;


    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public boolean delete(Long aLong) {
        repository.deleteById(aLong);
        return !repository.existsById(aLong);
    }


    @Override
    public List<Customer> getall() {
        return repository.findAll();
    }

    public Customer authenticationByEmail(String email, String password) {
        return repository.findByContactEmailAndPassword(email, password);
    }
}
