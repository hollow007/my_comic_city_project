/* Joshua Mokwebo
Student Number : 222191562
GITHUB:
Date : 17/09/2024
 */


package za.ac.cput.service.adressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;


@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService (AddressRepository repository){
        this.addressRepository = repository;
        }

    @Override
    public Address create(Address address) {
        if(address == null){
            throw new IllegalArgumentException("address cannot be  null !");
        }
        return addressRepository.save(address);
    }

    @Override
    public Address read(Long aLong) {
        return addressRepository.findById(aLong).orElse(null);
    }

//    @Override
//    public Address update(Address address) {
//        if(address instanceof ShippingAddress ){
//           ShippingAddress shippingAddress = (ShippingAddress) address;
//            return  addressRepository.save(shippingAddress);
//
//        }else {
//            BillingAddress billingAddress = (BillingAddress) address;
//            return addressRepository.save(billingAddress);
//        }
//
//    }


    @Override
    public Address update(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("address cannot be  null !");
        }
        return addressRepository.save(address);
    }

    @Override
    public boolean delete(Long aLong) {
       addressRepository.deleteById(aLong);
       return  addressRepository.existsById(aLong);
    }
    @Override
    public List<Address> getall() {
        return addressRepository.findAll();
    }
}



