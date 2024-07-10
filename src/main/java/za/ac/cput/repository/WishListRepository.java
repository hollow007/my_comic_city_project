package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.WishList;
@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {
}

