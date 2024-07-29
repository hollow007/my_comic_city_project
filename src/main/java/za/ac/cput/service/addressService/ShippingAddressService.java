package za.ac.cput.service.addressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.repository.addressRepository.ShippingAddressRepository;

import java.util.List;
@Service
public class ShippingAddressService implements IShippingAddressService {

    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    public ShippingAddressService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    @Override
    public ShippingAddress create(ShippingAddress shippingAddress) {
        if (shippingAddress == null)
            throw new IllegalArgumentException("shippingAddress cannot be null");
        return shippingAddressRepository.save(shippingAddress);
    }

    @Override
    public ShippingAddress read(Long aLong) {
        if (aLong == null)
            throw new IllegalArgumentException("aLong cannot be null");
        return shippingAddressRepository.getReferenceById(aLong);
    }

    @Override
    public ShippingAddress update(ShippingAddress shippingAddress) {
        if (shippingAddress == null)
            throw new IllegalArgumentException("shippingAddress cannot be null");
        return shippingAddressRepository.save(shippingAddress);
    }

    @Override
    public boolean delete(Long aLong) {
        if (aLong < 0 || aLong == null)
            throw new IllegalArgumentException("aLong cannot be negative or null");
        shippingAddressRepository.deleteById(aLong);
        return shippingAddressRepository.existsById(aLong);
    }

    @Override
    public List<ShippingAddress> getallShippingAddress() {
        return shippingAddressRepository.findAll();
    }

}

