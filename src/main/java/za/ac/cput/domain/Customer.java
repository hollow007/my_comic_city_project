package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity
public class Customer extends User{
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToOne(cascade = CascadeType.ALL)
    private WishList wishList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Customer() {
    }

    private Customer(CustomerBuilder c) {
        this.customerId = c.customerId;
        name = c.name;
        password = c.password;
        contact = c.contact;
        this.cart = c.cart;
        this.wishList = c.wishList;
        this.orders = c.orders;
        this.reviews = c.reviews;

    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getPassword() {
        return password;
    }

    public Cart getCart() {
        return cart;
    }

    public WishList getWishList() {
        return wishList;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name=" + name +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                ", cart=" + cart +
                ", wishList=" + wishList +
                ", orders=" + orders +
                ", reviews=" + reviews +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(cart, customer.cart) && Objects.equals(wishList, customer.wishList) && Objects.equals(orders, customer.orders) && Objects.equals(reviews, customer.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerId, cart, wishList, orders, reviews);
    }

    public static class CustomerBuilder{

        private long customerId;
        private Name name;
        private String password;
        private Contact contact;
        private Cart cart;
        private WishList wishList;
        private List<Order> orders;
        private List<Review> reviews;

        public CustomerBuilder() {
        }


        public CustomerBuilder setCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public CustomerBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public CustomerBuilder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public CustomerBuilder setWishList(WishList wishList) {
            this.wishList = wishList;
            return this;
        }

        public CustomerBuilder setOrders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public CustomerBuilder setReviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public CustomerBuilder copy(Customer c) {
            this.customerId = c.customerId;
            this.name = c.name;
            this.password = c.password;
            this.contact = c.contact;
            this.cart = c.cart;
            this.wishList = c.wishList;
            this.orders = c.orders;
            this.reviews = c.reviews;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
