package za.ac.cput.service.reviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;

/* ReviewService.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 19 May 2024
   https://github.com/hollow007/my_comic_city_project
 */

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }
}