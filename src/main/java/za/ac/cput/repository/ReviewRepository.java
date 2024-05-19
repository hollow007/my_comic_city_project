package za.ac.cput.repository;

import za.ac.cput.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/* ReviewRepository.interface
   Review repository interface class
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByComicBookID(int comicBookID);
    List<Review> findByUserID(int userID);
    Review create(Review review);
    Review read(int reviewId);
    Review update(Review review);
    boolean delete(int reviewId);
    List<Review> getAll();
}
