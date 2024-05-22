package za.ac.cput.factory;

import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/* ReviewFactory.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */

public class ReviewFactory {

    public static Review buildReview(int reviewID, List<ComicBook> comicBooks, User user, int reviewRating, String reviewText, LocalDate reviewDate, boolean spoilerFlag, String reviewTitle, int replyCount, String reviewStatus) {
        Review review = new Review();
        review.setReviewID(reviewID);
        review.setComicBooks(comicBooks);
        review.setUser(user);
        review.setReviewRating(reviewRating);
        review.setReviewText(reviewText);
        review.setReviewDate(reviewDate);
        review.setSpoilerFlag(spoilerFlag);
        review.setReviewTitle(reviewTitle);
        review.setReplyCount(replyCount);
        review.setReviewStatus(reviewStatus);
        return review;
    }
}