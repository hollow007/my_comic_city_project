package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/* Review.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 17 May 2024
   https://github.com/hollow007/my_comic_city_project
 */

@Entity
@Table(name = "reviews")
@DynamicInsert
@DynamicUpdate
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewID;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reviews_comic_books",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_book_id"))
    private List<ComicBook> comicBooks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int reviewRating;

    @Column(nullable = false)
    private String reviewText;

    @Column(nullable = false)
    private LocalDate reviewDate;

    @Column(nullable = false)
    private boolean spoilerFlag;

    @Column(nullable = false)
    private String reviewTitle;

    @Column(nullable = false)
    private int replyCount;

    @Column(nullable = false)
    private String reviewStatus;

    public Review() {}

    private Review(Builder builder) {
        this.comicBooks = builder.comicBooks;
        this.user = builder.user;
        this.reviewRating = builder.reviewRating;
        this.reviewText = builder.reviewText;
        this.reviewDate = builder.reviewDate;
        this.spoilerFlag = builder.spoilerFlag;
        this.reviewTitle = builder.reviewTitle;
        this.replyCount = builder.replyCount;
        this.reviewStatus = builder.reviewStatus;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void setComicBooks(List<ComicBook> comicBooks) {
        this.comicBooks = comicBooks;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReviewID(int reviewID) {
    }

    public void setReviewRating(int reviewRating) {
    }

    public void setReviewText(String reviewText) {
    }

    public void setReviewDate(LocalDate reviewDate) {
    }

    public void setSpoilerFlag(boolean spoilerFlag) {
    }

    public void setReviewTitle(String reviewTitle) {
    }

    public void setReplyCount(int replyCount) {
    }

    public void setReviewStatus(String reviewStatus) {
    }

    public static class Builder {
        private List<ComicBook> comicBooks;
        private User user;
        private int reviewRating;
        private String reviewText;
        private LocalDate reviewDate;
        private boolean spoilerFlag;
        private String reviewTitle;
        private int replyCount;
        private String reviewStatus;

        public Builder comicBooks(List<ComicBook> comicBooks) {
            this.comicBooks = comicBooks;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder reviewRating(int reviewRating) {
            this.reviewRating = reviewRating;
            return this;
        }

        public Builder reviewText(String reviewText) {
            this.reviewText = reviewText;
            return this;
        }

        public Builder reviewDate(LocalDate reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public Builder spoilerFlag(boolean spoilerFlag) {
            this.spoilerFlag = spoilerFlag;
            return this;
        }

        public Builder reviewTitle(String reviewTitle) {
            this.reviewTitle = reviewTitle;
            return this;
        }

        public Builder replyCount(int replyCount) {this.replyCount = replyCount;
            return this;
        }

        public Builder reviewStatus(String reviewStatus) {
            this.reviewStatus = reviewStatus;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }

    public int getReviewID() {
        return reviewID;
    }

    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    public User getUser() {
        return user;
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

    public boolean isSpoilerFlag() {
        return spoilerFlag;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getReviewID() == review.getReviewID() &&
                getReviewRating() == review.getReviewRating() &&
                isSpoilerFlag() == review.isSpoilerFlag() &&
                getReplyCount() == review.getReplyCount() &&
                getReviewStatus().equals(review.getReviewStatus()) &&
                getReviewText().equals(review.getReviewText()) &&
                getReviewDate().equals(review.getReviewDate()) &&
                getReviewTitle().equals(review.getReviewTitle()) &&
                getComicBooks().equals(review.getComicBooks()) &&
                getUser().equals(review.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewID, getComicBooks(), getUser(), getReviewRating(), getReviewText(), getReviewDate(), spoilerFlag, getReviewTitle(), replyCount, reviewStatus);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", comicBooks=" + comicBooks +
                ", user=" + user +
                ", reviewRating=" + reviewRating +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate +
                ", spoilerFlag=" + spoilerFlag +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", replyCount=" + replyCount +
                ", reviewStatus='" + reviewStatus + '\'' +
                '}';
    }
}