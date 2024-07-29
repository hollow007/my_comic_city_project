//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

package za.ac.cput.service.addressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.repository.addressRepository.BillingAddressRepository;

import java.util.List;
@Service
public class BillingAddressService implements IBillingAddressService {

    private BillingAddressRepository billingAddressRepository;
    private BillingAddress billingAddress = new BillingAddress();



    @Autowired
    public BillingAddressService(BillingAddressRepository billingAddressRepository) {
        this.billingAddressRepository = billingAddressRepository;
    }



    @Override
    public BillingAddress create(BillingAddress billingAddress) {
        if (billingAddress == null)
            throw new IllegalArgumentException("billingAddress cannot be null");

        return billingAddressRepository.save(billingAddress);
    }

    @Override
    public BillingAddress read(Long aLong ) {
        if(aLong == null || aLong < 0L)
            throw new IllegalArgumentException("billingAddress cannot be negative or null");
        return billingAddressRepository.findById(aLong).orElse(null);
    }

    @Override
    public BillingAddress update(BillingAddress billingAddress) {
        if (billingAddress == null)
            throw new IllegalArgumentException("billingAddress cannot be null");

        return billingAddressRepository.save(billingAddress);
    }

    @Override
    public boolean delete(Long aLong) {
        if(aLong < 0L || aLong == null)
            throw new IllegalArgumentException("billingAddress cannot be negative or null");
        billingAddressRepository.deleteById(aLong);
        return billingAddressRepository.existsById(aLong);
    }

    @Override
    public List<BillingAddress> getallBillingAddress() {
        return billingAddressRepository.findAll();
    }
}
