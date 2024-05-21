package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Mpumzi Mbula
 * 219053324
 * 17/05/2024
 *
 */
@Entity
public class Cart {
    @Id
    private long cartId;
 master
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
=======

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "cart_comicbook",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_book_id")
    )
 master
    List<ComicBook> comicBookList;
    private double totalPrice;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    protected Cart (Builder builder) {
        this.cartId = builder.cartId;
        this.comicBookList = builder.comicBookList;
        this.totalPrice = builder.totalPrice;
        this.createdDate = builder.createdDate;
        this.updatedDate = builder.updatedDate;

    }

    public Cart() {

    }

    public long getCartId() {
        return cartId;
    }

    public List<ComicBook> getComicBookList() {
        return comicBookList;
    }

    public double getTotalPrice() {
        return totalPrice;
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
        if (!(o instanceof Cart cart)) return false;
        return cartId == cart.cartId && Double.compare(totalPrice, cart.totalPrice) == 0 && Objects.equals(comicBookList, cart.comicBookList) && Objects.equals(createdDate, cart.createdDate) && Objects.equals(updatedDate, cart.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, comicBookList, totalPrice, createdDate, updatedDate);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", comicBookList=" + comicBookList +
                ", totalPrice=" + totalPrice +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    public static class Builder {
        private long cartId;

        List<ComicBook> comicBookList;
        private double totalPrice;
        private LocalDate createdDate;
        private LocalDate updatedDate;
        public Builder (){

        }

        public Builder setCartId(long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setComicBookList(List<ComicBook> comicBookList) {
            this.comicBookList = comicBookList;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
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
        public Builder copy (Cart cart) {
            this.cartId = cart.cartId;
            this.comicBookList = cart.comicBookList;
            this.totalPrice = cart.totalPrice;
            this.createdDate = cart.createdDate;
            this.updatedDate = cart.updatedDate;
            return this;
        }

        public Cart build(){
            return new Cart(this);
        }

    }

}
