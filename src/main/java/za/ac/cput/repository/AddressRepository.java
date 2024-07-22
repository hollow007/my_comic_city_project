/*Joshua Mokwebo
Student Number 222191562
GitHub :
Date : 17/07/2024
 */


package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository <Address , Long> {
}
