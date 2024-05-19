package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;
@Entity
public class Customer {
    @Id
    private long customerId;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)

    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToOne(cascade = CascadeType.ALL)
    private WishList wishList;

    protected Customer() {
    }

    private Customer(CustomerBuilder c) {
        this.customerId = c.customerId;
        this.firstName = c.firstName;
        this.lastName = c.lastName;
        this.contact = c.contact;
        this.cart = c.cart;
        this.wishList = c.wishList;

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

    public Contact getContact() {
        return contact;
    }

    public Cart getCart() {
        return cart;
    }

    public WishList getWishList() {
        return wishList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "\ncontact=" + contact +
                "\ncart=" + cart +
                "\nwishList=" + wishList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(contact, customer.contact) && Objects.equals(cart, customer.cart) && Objects.equals(wishList, customer.wishList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, contact, cart, wishList);
    }

    public static class CustomerBuilder{

        private long customerId;
        private String firstName;
        private String lastName;

        private Contact contact;
        private Cart cart;
        private WishList wishList;

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

        public CustomerBuilder copy(Customer c) {
            this.customerId = c.customerId;
            this.firstName = c.firstName;
            this.lastName = c.lastName;
            this.contact = c.contact;
            this.cart = c.cart;
            this.wishList = c.wishList;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
