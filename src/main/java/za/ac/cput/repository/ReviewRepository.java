package za.ac.cput.repository;

import za.ac.cput.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/* ReviewRepository.java (interface)
   Author: Cavan Ramone Swartz (221055835)
   Date: 1 July 2024
   https://github.com/hollow007/my_comic_city_project
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>  {
}
