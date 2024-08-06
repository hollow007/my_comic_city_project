package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Review;
import za.ac.cput.service.reviewService.ReviewService;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public Review create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @GetMapping("/read/{reviewID}")
    public Review read(@PathVariable/*("reviewID")*/ Long reviewID) {
        return reviewService.read(reviewID);
    }

    @PostMapping("/update")
    public Review update(@RequestBody Review review) {
        return reviewService.update(review);
    }

    @DeleteMapping("/delete/{reviewID}")
    public boolean delete(@PathVariable/*("reviewID")*/ Long reviewID) {
        return reviewService.delete(reviewID);
    }

    @GetMapping("/getAll")
    public List<Review> getAll() {
        return reviewService.getAll();
    }
}