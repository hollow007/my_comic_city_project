package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.util.ReviewValidator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/* ReviewRepositoryTest.java
   Review repository test class
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewValidator reviewValidator;

    @Test
    void testCreateReview() {
        Review review = new Review();
        review.setComicBookID(1);
        review.setUserID(1);
        review.setReviewTitle("Test Review");
        review.setReviewText("This is a test review");

        assertTrue(reviewValidator.isValidReview(review));

        Review createdReview = reviewRepository.create(review);
        assertNotNull(createdReview);
        assertEquals(review.getReviewTitle(), createdReview.getReviewTitle());
    }

    @Test
    void testReadReview() {
        Review review = reviewRepository.read(1);
        assertNotNull(review);
        assertEquals(1, review.getReviewID());
    }

    @Test
    void testUpdateReview() {
        Review review = reviewRepository.read(1);
        assertNotNull(review);

        review.setReviewText("Updated review text");
        Review updatedReview = reviewRepository.update(review);
        assertNotNull(updatedReview);
        assertEquals("Updated review text", updatedReview.getReviewText());
    }

    @Test
    void testDeleteReview() {
        boolean deleted = reviewRepository.delete(1);
        assertTrue(deleted);
    }

    @Test
    void testFindByComicBookID() {
        List<Review> reviews = reviewRepository.findByComicBookID(1);
        assertNotNull(reviews);
        assertEquals(1, reviews.size());
    }

    @Test
    void testFindByUserID() {
        List<Review> reviews = reviewRepository.findByUserID(1);
        assertNotNull(reviews);
        assertEquals(1, reviews.size());
    }

    @Test
    void testGetAllReviews() {
        List<Review> reviews = reviewRepository.getAll();
        assertNotNull(reviews);
        assertTrue(reviews.size() > 0);
    }
}