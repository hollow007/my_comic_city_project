package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity
public class Customer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToOne(cascade = CascadeType.ALL)
    private WishList wishList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    protected Customer() {
    }

    private Customer(CustomerBuilder c) {
        this.customerId = c.customerId;
        firstName = c.firstName;
        lastName = c.lastName;
        password = c.password;
        this.contact = c.contact;
        this.cart = c.cart;
        this.wishList = c.wishList;
        this.orders = c.orders;

    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Contact getContact() {
        return contact;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                ", cart=" + cart +
                ", wishList=" + wishList +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(password, customer.password) && Objects.equals(contact, customer.contact) && Objects.equals(cart, customer.cart) && Objects.equals(wishList, customer.wishList) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, password, contact, cart, wishList, orders);
    }

    public static class CustomerBuilder{

        private long customerId;
        private String firstName;
        private String lastName;

        private String password;
        private Contact contact;
        private Cart cart;
        private WishList wishList;
        private List<Order> orders;

        public CustomerBuilder() {
        }


        public CustomerBuilder setCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public CustomerBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder setLastName(String lastName) {
            this.lastName = lastName;
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

        public CustomerBuilder copy(Customer c) {
            this.customerId = c.customerId;
            this.firstName = c.firstName;
            this.lastName = c.lastName;
            this.password = c.password;
            this.contact = c.contact;
            this.cart = c.cart;
            this.wishList = c.wishList;
            this.orders = c.orders;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
