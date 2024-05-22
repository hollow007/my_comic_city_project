package za.ac.cput.service.reviewService;

import za.ac.cput.domain.Review;
import za.ac.cput.service.IService;
import java.util.List;
/* IReviewService.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 18 May 2024
   https://github.com/hollow007/my_comic_city_project
 */

public interface IReviewService extends IService<Review, Integer> {

    List<Review> getAll();
}
