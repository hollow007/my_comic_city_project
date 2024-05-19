package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/* ReviewFactoryTest.java
   Review factory test class
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */
class ReviewFactoryTest {

    @Test
    void createReview() {
        Review review = ReviewFactory.createReview(1, 1, 5, "This is a great comic book!", LocalDate.now(), false, "Awesome comic book", 0, "approved");
        assertNotNull(review);
        assertEquals(1, review.getComicBookID());
        assertEquals(1, review.getUserID());
        assertEquals(5, review.getReviewRating());
        assertEquals("This is a great comic book!", review.getReviewText());
        assertEquals(LocalDate.now(), review.getReviewDate());
        assertFalse(review.isSpoilerFlag());
        assertEquals("Awesome comic book", review.getReviewTitle());
        assertEquals(0, review.getReplyCount());
        assertEquals("approved", review.getReviewStatus());
    }

    @Test
    void createReviewWithID() {
        Review review = ReviewFactory.createReviewWithID(1, 1, 1, 5, "This is a great comic book!", LocalDate.now(), false, "Awesome comic book", 0, "approved");
        assertNotNull(review);
        assertEquals(1, review.getReviewID());
        assertEquals(1, review.getComicBookID());
        assertEquals(1, review.getUserID());
        assertEquals(5, review.getReviewRating());
        assertEquals("This is a great comic book!", review.getReviewText());
        assertEquals(LocalDate.now(), review.getReviewDate());
        assertFalse(review.isSpoilerFlag());
        assertEquals("Awesome comic book", review.getReviewTitle());
        assertEquals(0, review.getReplyCount());
        assertEquals("approved", review.getReviewStatus());
    }
}