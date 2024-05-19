package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import java.time.LocalDate;

/* ReviewFactory.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */
public class ReviewFactory {

    public static Review createReview(int comicBookID, int userID, int reviewRating, String reviewText, LocalDate reviewDate, boolean spoilerFlag, String reviewTitle, int replyCount, String reviewStatus) {
        return Review.builder()
                .comicBookID(comicBookID)
                .userID(userID)
                .reviewRating(reviewRating)
                .reviewText(reviewText)
                .reviewDate(reviewDate)
                .spoilerFlag(spoilerFlag)
                .reviewTitle(reviewTitle)
                .replyCount(replyCount)
                .reviewStatus(reviewStatus)
                .build();
    }

    public static Review createReviewWithID(int reviewID, int comicBookID, int userID, int reviewRating, String reviewText, LocalDate reviewDate, boolean spoilerFlag, String reviewTitle, int replyCount, String reviewStatus) {
        return Review.builder()
                .comicBookID(comicBookID)
                .userID(userID)
                .reviewRating(reviewRating)
                .reviewText(reviewText)
                .reviewDate(reviewDate)
                .spoilerFlag(spoilerFlag)
                .reviewTitle(reviewTitle)
                .replyCount(replyCount)
                .reviewStatus(reviewStatus)
                .build();
    }
}