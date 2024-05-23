package za.ac.cput.repository;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressId;

@Repository
@Deprecated
public interface ShippingAdderssRepository extends JpaRepository <Address , AddressId> {
}
