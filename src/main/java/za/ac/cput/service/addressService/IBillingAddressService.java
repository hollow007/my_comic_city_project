//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

package za.ac.cput.service.addressService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.service.IService;

import java.util.List;

@Service
public interface IBillingAddressService extends IService<BillingAddress, Long> {
    List<BillingAddress> getallBillingAddress();
}
