package za.ac.cput.repository.addressRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}
