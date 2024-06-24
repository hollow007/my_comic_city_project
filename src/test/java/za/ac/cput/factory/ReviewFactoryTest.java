//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.ComicBook;
//import za.ac.cput.domain.Review;
//import za.ac.cput.factory.ReviewFactory;
//import za.ac.cput.domain.User;
//import static za.ac.cput.domain.User.UserBuilder;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
//class ReviewFactoryTest {
//
//    private Review review1;
//    private Review review2;
//    private Review review3;
//    private User user;
//    private List<ComicBook> comicBooks;
//
//    @BeforeEach
//    void setUp() {
//        user = new User();
//        /*user.setUserName("loki");
//        user.setFirstName("John");
//        user.setLastName("Doe");*/
//
//        comicBooks = new ArrayList<>();
//       // boolean add = comicBooks.add(new ComicBook());
//
//        review1 = ReviewFactory.buildReview(5, comicBooks, user, 5, "Great comic book!", LocalDate.now(), false, "My Review", 0, "approved");
//        review2 = ReviewFactory.buildReview(3,comicBooks, user, 3, "Okay comic book.", LocalDate.now(), true, "My Review", 0, "approved");
//        review3 = ReviewFactory.buildReview(1,comicBooks, user, 1, "Comic book is average", LocalDate.now(), false, "", 0, "approved");
//    }
//
//    @Test
//    void buildReviewWithValidDetails() {
//        assertNotNull(review1);
//        assertEquals(user, review1.getUser());
//        assertEquals(comicBooks, review1.getComicBooks());
//        assertEquals(5, review1.getReviewRating());
//        assertEquals("Great comic book!", review1.getReviewText());
//        assertEquals(LocalDate.now(), review1.getReviewDate());
//        assertEquals(false, review1.isSpoilerFlag());
//        assertEquals("My Review", review1.getReviewTitle());
//        assertEquals(0, review1.getReplyCount());
//        assertEquals("approved", review1.getReviewStatus());
//    }
//
//    @Test
//    void buildReviewWithIncorrectUser() {
//        assertNotNull(review2);
//        assertEquals(user, review2.getUser());
//        assertEquals(comicBooks, review2.getComicBooks());
//        assertEquals(3, review2.getReviewRating());
//        assertEquals("Okay comic book.", review2.getReviewText());
//        assertEquals(LocalDate.now(), review2.getReviewDate());
//        assertEquals(true, review2.isSpoilerFlag());
//        assertEquals("My Review", review2.getReviewTitle());
//        assertEquals(0, review2.getReplyCount());
//        assertEquals("approved", review2.getReviewStatus());
//    }
//
//    @Test
//    void buildReviewWithNullValues() {
//        assertNull(review3);
//    }
//}