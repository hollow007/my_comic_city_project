package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Mpumzi Mbula
 * 219053324
 * 17/05/2024
 *
 */
@Entity
public class WishList{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishListId;
    private String wishListName;
    @OneToOne(cascade=CascadeType.ALL)
    private Customer customer;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "wishList_comicbook",
            joinColumns = @JoinColumn(name = "wishList_id"),
            inverseJoinColumns = @JoinColumn(name = "comicbook_id")
    )
    private List<ComicBook> comicBooks;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public WishList() {
    }
    protected WishList(Builder builder){
        this.wishListId=builder.wishListId;
        this.wishListName=builder.wishListName;
        this.customer=builder.customer;
        this.comicBooks=builder.comicBooks;
        this.createdDate=builder.createdDate;
        this.updatedDate=builder.updatedDate;
    }

    public Long getWishListId() {
        return wishListId;
    }

    public String getWishListName() {
        return wishListName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishList wishList)) return false;
        return Objects.equals(wishListId, wishList.wishListId) && Objects.equals(wishListName, wishList.wishListName) && Objects.equals(customer, wishList.customer) && Objects.equals(comicBooks, wishList.comicBooks) && Objects.equals(createdDate, wishList.createdDate) && Objects.equals(updatedDate, wishList.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishListId, wishListName, customer, comicBooks, createdDate, updatedDate);
    }

    @Override
    public String toString() {
        return "WishList{" +
                "wishListId=" + wishListId +
                ", wishListName='" + wishListName + '\'' +
                ", customer=" + customer +
                ", comicBooks=" + comicBooks +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    public static class Builder{

        private Long wishListId;
        private String wishListName;
        private Customer customer;
        private List<ComicBook> comicBooks;
        private LocalDate createdDate;
        private LocalDate updatedDate;

        public Builder() {
        }

        public Builder setWishListId(Long wishListId) {
            this.wishListId = wishListId;
            return this;
        }

        public Builder setWishListName(String wishlistName) {
            this.wishListName = wishlistName;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setComicBooks(List<ComicBook> comicBooks) {
            this.comicBooks = comicBooks;
            return this;
        }

        public Builder setCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder setUpdatedDate(LocalDate updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }
        public Builder copy(WishList wishList){
            this.wishListId=wishList.wishListId;
            this.wishListName=wishList.wishListName;
            this.customer=wishList.customer;
            this.comicBooks=wishList.comicBooks;
            this.createdDate=wishList.createdDate;
            this.updatedDate=wishList.updatedDate;
            return this;
        }
        public WishList build(){
            return new WishList(this);
        }
    }
}
