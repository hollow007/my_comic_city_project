package za.ac.cput.service.reviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.util.ReviewHelper;

import java.util.List;
/* ReviewService.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 19 May 2024
   https://github.com/hollow007/my_comic_city_project
 */
//@Service
//public class ReviewService implements IReviewService {
//    private final ReviewRepository reviewRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository) {
//        this.reviewRepository = reviewRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public Review create(Review review) {
//        if (ReviewHelper.isNullOrEmpty(review.getReviewText()) || ReviewHelper.isNullOrEmpty(review.getReviewTitle())) {
//            throw new IllegalArgumentException("Review text and title cannot be null or empty.");
//        }
//
//        if (review.getUserID() <= 0) {
//            throw new IllegalArgumentException("Invalid user ID.");
//        }
//
//       /* User user = userRepository.findById(review.getUserID()).orElseThrow(() -> new IllegalArgumentException("User not found."));
//        review.setUser(user);*/
//        return reviewRepository.save(review);
//    }
//
//    @Override
//    public Review read(int reviewId) {
//        return reviewRepository.findById(reviewId).orElseThrow(() -> new IllegalArgumentException("Review not found."));
//    }
//
//    @Override
//    public Review update(Review review) {
//        if (review.getReviewID() <= 0) {
//            throw new IllegalArgumentException("Invalid review ID.");
//        }
//
//        Review existingReview = read(review.getReviewID());
//        if (existingReview == null) {
//            throw new IllegalArgumentException("Review not found.");
//        }
//
//        if (ReviewHelper.isNullOrEmpty(review.getReviewText()) || ReviewHelper.isNullOrEmpty(review.getReviewTitle())) {
//            throw new IllegalArgumentException("Review text and title cannot be null or empty.");
//        }
//
//        if (review.getUserID() <= 0) {
//            throw new IllegalArgumentException("Invalid user ID.");
//        }
//
//        /*User user = userRepository.findById(review.getUserID()).orElseThrow(() -> new IllegalArgumentException("User not found."));
//        review.setUser(user);*/
//        return reviewRepository.save(review);
//    }
//
//    @Override
//    public boolean delete(int reviewId) {
//        reviewRepository.deleteById(reviewId);
//        return!reviewRepository.existsById(reviewId);
//    }
//
//    @Override
//    public List<Review> getAll() {
//        return reviewRepository.findAll();
//    }
//
//
//    @Override
//    public List<Review> findByComicBookID(long comicBookID) {
//        return reviewRepository.findByComicBookID(comicBookID);
//    }
//
//    @Override
//    public List<Review> findByUserID(int userID) {
//        return reviewRepository.findByUserID(userID);
//    }
//}