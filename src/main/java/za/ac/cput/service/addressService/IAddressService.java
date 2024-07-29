//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

package za.ac.cput.service.addressService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

@Service
public interface IAddressService extends IService<Address, Long> {
    List<Address>getall();

}
