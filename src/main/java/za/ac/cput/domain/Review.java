package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.time.LocalDate;
import java.util.Objects;
/* Review.java
   Review model class
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

    public Review(int comicBookID, int userID, int reviewRating, String reviewText, LocalDate reviewDate, boolean spoilerFlag, String reviewTitle, int replyCount, String reviewStatus) {
        this.comicBookID = comicBookID;
        this.userID = userID;
        this.reviewRating = reviewRating;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.spoilerFlag = spoilerFlag;
        this.reviewTitle = reviewTitle;
        this.replyCount = replyCount;
        this.reviewStatus = reviewStatus;
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

    public void setReviewID(int reviewID) {
    }

    public void setComicBookID(int comicBookID) {
    }

    public void setUserID(int userID) {
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
}