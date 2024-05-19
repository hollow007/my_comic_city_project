package za.ac.cput.util;

import org.springframework.stereotype.Component;
import za.ac.cput.domain.Review;

/* ReviewValidator.java
   Review validator class
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */
@Component
public class ReviewValidator {

    public boolean isValidReview(Review review) {
        if (review.getReviewID() <= 0 || review.getComicBookID() <= 0 || review.getUserID() <= 0) {
            return false;
        }
        if (ReviewHelper.isNullOrEmpty(review.getReviewText()) || ReviewHelper.isNullOrEmpty(review.getReviewTitle())) {
            return false;
        }
        return true;
    }
}

