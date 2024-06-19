package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {
    @Id
    private String orderId;
    private LocalDate orderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_comicbook",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_book_id")
    )
    private List<ComicBook> comicBooks;
    private double totalAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoiceId")
    private Invoice invoice;

    protected Order() {
    }

    private Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.customer = builder.customer;
        this.comicBooks = builder.comicBooks;
        this.totalAmount = builder.totalAmount;
        this.invoice = builder.invoice;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalAmount, totalAmount) == 0 &&
                Objects.equals(orderId, order.orderId) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(comicBooks, order.comicBooks) &&
                Objects.equals(invoice, order.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, customer, comicBooks, totalAmount, invoice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", comicBooks=" + comicBooks +
                ", totalAmount=" + totalAmount +
                ", invoice=" + invoice +
                '}';
    }

    public static class OrderBuilder {
        private String orderId;
        private LocalDate orderDate;
        private Customer customer;
        private List<ComicBook> comicBooks;
        private double totalAmount;
        private Invoice invoice;

        public OrderBuilder() {
        }

        public OrderBuilder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public OrderBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public OrderBuilder setComicBooks(List<ComicBook> comicBooks) {
            this.comicBooks = comicBooks;
            return this;
        }

        public OrderBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public OrderBuilder setInvoice(Invoice invoice) {
            this.invoice = invoice;
            return this;
        }

        public OrderBuilder copy(Order order) {
            this.orderId = order.orderId;
            this.orderDate = order.orderDate;
            this.customer = order.customer;
            this.comicBooks = order.comicBooks;
            this.totalAmount = order.totalAmount;
            this.invoice = order.invoice;

            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
