package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.WishList;

public interface WishListRepository extends JpaRepository<WishList,Long> {
}
