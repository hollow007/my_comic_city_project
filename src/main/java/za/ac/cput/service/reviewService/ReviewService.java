package za.ac.cput.service.reviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import java.util.List;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private ReviewRepository repo;

    @Override
    public Review create(Review review) {
        return repo.save(review);
    }

    @Override
    public Review read(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Review update(Review review) {
        return repo.save(review);
    }

    @Override
    public boolean delete(Long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    @Override
    public List<Review> getAll() {
        return repo.findAll();
    }
}
