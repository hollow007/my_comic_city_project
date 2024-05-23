package za.ac.cput.service.addressService;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressId;
import za.ac.cput.repository.AddressRepository;

@Service
public class AddressService implements IAddressService {
    @Autowired
    AddressRepository repository;
    @Override
    public Address create(Address address) {return repository.save(address) ;}

    @Override
    public Address read(AddressId addressId) {
        return repository.findById(addressId).orElse(null);
    }

    @Override
    public Address update(Address address) {return repository.save(address);
    }

    @Override
    public boolean delete(AddressId addressId) {
         repository.deleteById(addressId);
        return !repository.existsById(addressId);
    }

}