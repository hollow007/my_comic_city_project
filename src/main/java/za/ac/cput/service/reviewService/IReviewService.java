package za.ac.cput.service.reviewService;

import za.ac.cput.domain.Review;
import java.util.List;
/* IReviewService.interface
   Author: Cavan Ramone Swartz (221055835)
   Date: 18 May 2024
   https://github.com/hollow007/my_comic_city_project
 */

public interface IReviewService {
    Review create(Review review);
    Review read(int reviewId);
    Review update(Review review);
    boolean delete(int reviewId);
    List<Review> getAll();
    List<Review> findByComicBookID(int comicBookID);
    List<Review> findByUserID(int userID);
}
