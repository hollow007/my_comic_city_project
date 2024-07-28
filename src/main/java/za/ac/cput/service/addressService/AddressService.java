package za.ac.cput.service.addressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.repository.addressRepository.AddressRepository;
import za.ac.cput.repository.addressRepository.BillingAddressRepository;
import za.ac.cput.repository.addressRepository.ShippingAddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService  implements IAddressService{

    private AddressRepository addressRepository;
    private BillingAddressRepository billingAddressRepository;
    private ShippingAddressRepository shippingAddressRepository;

    @Autowired
    AddressService (AddressRepository addressRepository , ShippingAddressRepository shippingAddressRepository , BillingAddressRepository billingAddressRepository){
        this.addressRepository = addressRepository;
        this.shippingAddressRepository = shippingAddressRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    @Override
    public Address create(Address address) {
        if(address == null)
            throw new IllegalArgumentException("address cannot be null");
        else if(address instanceof BillingAddress){
            return billingAddressRepository.save((BillingAddress) address);
        }else if(address instanceof ShippingAddress){
            return shippingAddressRepository.save((ShippingAddress) address);

    }
        return addressRepository.save(address);}

    @Override
    public Address read(Long aLong) {
        if (aLong < 0L)
            throw new IllegalArgumentException("id cannot be negative or zero");
        return addressRepository.findById(aLong).orElse(null);
    }

    @Override
    public Address update(Address address) {
        if (address == null)
            throw new IllegalArgumentException("address cannot be null");
        else if (address instanceof BillingAddress) {
            return billingAddressRepository.save((BillingAddress) address);
        } else if (address instanceof ShippingAddress) {
            return shippingAddressRepository.save((ShippingAddress) address);
        }
        return addressRepository.save(address);
    }

    @Override
    public boolean delete(Long aLong) {
        if (aLong<0L)
            throw new IllegalArgumentException("id cannot be negative or zero");
        addressRepository.deleteById(aLong);
        return addressRepository.existsById(aLong);
    }


    @Override
    public List<BillingAddress> getallBillingAddress() {
        return List.of();
    }

    @Override
    public List<ShippingAddress> getallShippingAddress() {
        return List.of();
    }

    @Override
    public List<Address> getall() {
        return addressRepository.findAll();
    }
}
