package za.ac.cput.repository.addressRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.BillingAddress;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
}
