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



    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_comicbook",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_book_id")
    )
    private List<ComicBook> comicBooks;
    private double totalAmount;



    protected Order() {
    }

    private Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;

        this.comicBooks = builder.comicBooks;
        this.totalAmount = builder.totalAmount;

    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }


    public List<ComicBook> getComicBooks() {
        return comicBooks;
    }

    public double getTotalAmount() {
        return totalAmount;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalAmount, totalAmount) == 0 &&
                Objects.equals(orderId, order.orderId) &&
                Objects.equals(orderDate, order.orderDate) &&

                Objects.equals(comicBooks, order.comicBooks) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, comicBooks, totalAmount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +

                ", comicBooks=" + comicBooks +
                ", totalAmount=" + totalAmount +

                '}';
    }

    public static class OrderBuilder {
        private String orderId;
        private LocalDate orderDate;

        private List<ComicBook> comicBooks;
        private double totalAmount;


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



        public OrderBuilder setComicBooks(List<ComicBook> comicBooks) {
            this.comicBooks = comicBooks;
            return this;
        }

        public OrderBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }



        public OrderBuilder copy(Order order) {
            this.orderId = order.orderId;
            this.orderDate = order.orderDate;

            this.comicBooks = order.comicBooks;
            this.totalAmount = order.totalAmount;


            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
