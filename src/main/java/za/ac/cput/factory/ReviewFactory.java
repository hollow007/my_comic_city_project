package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import java.time.LocalDate;

/* ReviewFactory.java
   Review factory class
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */
public class ReviewFactory {

    public static Review createReview(int comicBookID, int userID, int reviewRating, String reviewText, LocalDate reviewDate, boolean spoilerFlag, String reviewTitle, int replyCount, String reviewStatus) {
        Review review = new Review();
        review.setComicBookID(comicBookID);
        review.setUserID(userID);
        review.setReviewRating(reviewRating);
        review.setReviewText(reviewText);
        review.setReviewDate(reviewDate);
        review.setSpoilerFlag(spoilerFlag);
        review.setReviewTitle(reviewTitle);
        review.setReplyCount(replyCount);
        review.setReviewStatus(reviewStatus);
        return review;
    }

    public static Review createReviewWithID(int reviewID, int comicBookID, int userID, int reviewRating, String reviewText, LocalDate reviewDate, boolean spoilerFlag, String reviewTitle, int replyCount, String reviewStatus) {
        Review review = new Review();
        review.setReviewID(reviewID);
        review.setComicBookID(comicBookID);
        review.setUserID(userID);
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