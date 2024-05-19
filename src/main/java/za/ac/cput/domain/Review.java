package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.time.LocalDate;
import java.util.Objects;

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

    @Column(nullable = false)
    private int comicBookID;

    @Column(nullable = false)
    private int userID;

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
        this.comicBookID = builder.comicBookID;
        this.userID = builder.userID;
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

    public void setComicBookID(int comicBookID) {
        this.comicBookID = comicBookID;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public static class Builder {
        private int comicBookID;
        private int userID;
        private int reviewRating;
        private String reviewText;
        private LocalDate reviewDate;
        private boolean spoilerFlag;
        private String reviewTitle;
        private int replyCount;
        private String reviewStatus;

        public Builder comicBookID(int comicBookID) {
            this.comicBookID = comicBookID;
            return this;
        }

        public Builder userID(int userID) {
            this.userID = userID;
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

        public Builder replyCount(int replyCount) {
            this.replyCount = replyCount;
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

    public int getComicBookID() {
        return comicBookID;
    }

    public int getUserID() {
        return userID;
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
                getComicBookID() == review.getComicBookID() &&
                getUserID() == review.getUserID() &&
                getReviewRating() == review.getReviewRating() &&
                isSpoilerFlag() == review.isSpoilerFlag() &&
                getReplyCount() == review.getReplyCount() &&
                getReviewStatus().equals(review.getReviewStatus()) &&
                getReviewText().equals(review.getReviewText()) &&
                getReviewDate().equals(review.getReviewDate()) &&
                getReviewTitle().equals(review.getReviewTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewID, comicBookID, userID, reviewRating, reviewText, reviewDate, spoilerFlag, reviewTitle, replyCount, reviewStatus);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", comicBookID=" + comicBookID +
                ", userID=" + userID +
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