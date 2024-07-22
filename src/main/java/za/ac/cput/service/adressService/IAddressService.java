/* Joshua Mokwebo
Student Number : 222191562
GITHUB :
Date: 17/09/2024
 */


package za.ac.cput.service.adressService;

import za.ac.cput.domain.Address;
import za.ac.cput.service.IService;

import java.util.List;

public interface IAddressService extends IService<Address, Long> {
    List<Address>getall();
}
