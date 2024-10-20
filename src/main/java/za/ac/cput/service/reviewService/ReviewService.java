package za.ac.cput.service.reviewService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import za.ac.cput.service.comicBookService.ComicBookService;
import za.ac.cput.service.customerService.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {
    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository repo;
    @Autowired
    private ComicBookService comicBookService;
    @Autowired
    private CustomerService customerService;

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public Review create(Review review) {
        logger.info("Creating new review");
        Customer customer = handleCustomer(review.getCustomer());
        review.setCustomer(customer);

        ComicBook comicBook = handleComicBook(review.getComicBook());
        review.setComicBook(comicBook);

        Review savedReview = repo.save(review);
        logger.info("Review created with ID: {}", savedReview.getReviewID());
        return savedReview;
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public Review read(Long id) {
        logger.info("Reading review with ID: {}", id);
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public Review update(Review review) {
        logger.info("Updating review with ID: {}", review.getReviewID());
        Customer customer = handleCustomer(review.getCustomer());
        review.setCustomer(customer);

        ComicBook comicBook = handleComicBook(review.getComicBook());
        review.setComicBook(comicBook);

        return repo.save(review);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public boolean delete(Long id) {
        logger.info("Deleting review with ID: {}", id);
        repo.deleteById(id);
        boolean deleted = !repo.existsById(id);
        logger.info("Review deletion result: {}", deleted);
        return deleted;
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Review> getAll() {
        logger.info("Retrieving all reviews");
        return repo.findAll();
    }

    // Helper method to handle ComicBook creation or update
    private ComicBook handleComicBook(ComicBook comicBook) {
        if (comicBook != null && comicBook.getSKU() != null) {
            return Optional.ofNullable(comicBookService.read(comicBook.getSKU()))
                    .map(existingBook -> comicBook)
                    .orElseGet(() -> comicBookService.create(comicBook));
        }
        return comicBook;
    }

    // Helper method to handle Customer creation or update
    private Customer handleCustomer(Customer customer) {
        if (customer != null && customer.getUserId() != null) {
            return Optional.ofNullable(customerService.read(customer.getUserId()))
                    .map(existingCustomer -> customer)
                    .orElseGet(() -> customerService.create(customer));
        }
        return customer;
    }
}