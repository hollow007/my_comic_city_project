package za.ac.cput.service.reviewService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.service.IService;

import java.util.List;
@Service
public interface IReviewService extends IService<Review, Long> {
    List<Review> getAll();
}
