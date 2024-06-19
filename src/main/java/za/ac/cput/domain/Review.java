package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/* Review.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 18 June 2024
   https://github.com/hollow007/my_comic_city_project
 */

@Entity
public class Review {
    @Id
    private Long reviewID;

    @ManyToMany(mappedBy = "reviews", fetch = FetchType.EAGER)
    private List<ComicBook> comicBooks = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;

    private int reviewRating;

    private String reviewText;

    private LocalDate reviewDate;

    private String reviewTitle;

    protected Review() {}

    private Review(ReviewBuilder e) {
        this.reviewID = e.reviewID;
        this.customer = e.customer;
        this.comicBooks = e.comicBooks;
        this.reviewRating = e.reviewRating;
        this.reviewText = e.reviewText;
        this.reviewDate = e.reviewDate;
        this.reviewTitle = e.reviewTitle;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewID, review.reviewID) && Objects.equals(customer, review.customer) && Objects.equals(comicBooks, review.comicBooks) && reviewRating == review.reviewRating && Objects.equals(reviewText, review.reviewText) && Objects.equals(reviewDate, review.reviewDate) && Objects.equals(reviewTitle, review.reviewTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewID, customer, comicBooks, reviewRating, reviewText, reviewDate, reviewTitle);
    }

    @Override
    public String toString() {
        String comicBookNames = comicBooks.stream().map(comicBook -> comicBook.getName()).collect(Collectors.joining(", "));
        return "Review{" +
                "reviewID=" + reviewID +
                ", comicBooks=[" + comicBookNames + "]" +
                ", customer=" + customer +
                ", reviewRating=" + reviewRating +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate +
                ", reviewTitle='" + reviewTitle + '\'' +
                '}';
    }

    public static class ReviewBuilder {
        private Long reviewID;
        private Customer customer;
        private List<ComicBook> comicBooks;
        private int reviewRating;
        private String reviewText;
        private LocalDate reviewDate;
        private String reviewTitle;

        public ReviewBuilder setReviewID(Long reviewID) {
            this.reviewID = reviewID;
            return this;
        }

        public ReviewBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public ReviewBuilder setComicBooks(List<ComicBook> comicBooks) {
            this.comicBooks = comicBooks;
            return this;
        }

        public ReviewBuilder setReviewRating(int reviewRating) {
            this.reviewRating = reviewRating;
            return this;
        }

        public ReviewBuilder setReviewText(String reviewText) {
            this.reviewText = reviewText;
            return this;
        }

        public ReviewBuilder setReviewDate(LocalDate reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public ReviewBuilder setReviewTitle(String reviewTitle) {
            this.reviewTitle = reviewTitle;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}