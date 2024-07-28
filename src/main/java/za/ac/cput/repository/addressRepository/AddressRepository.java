package za.ac.cput.repository;

//Author : FarananiJoshua Mokwebo 
//StudentNumber : 222191562
//GitHub repository : My_comic_city_project
//Day and Time : 25 / 07 / 2024


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.ShippingAddress;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

public interface  ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {}
