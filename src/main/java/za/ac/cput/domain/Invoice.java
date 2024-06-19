package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* Invoice.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 18 June 2024
   https://github.com/hollow007/my_comic_city_project
 */

@Entity
public class Invoice {
    @Id
    private Long invoiceId;
    private LocalDateTime dateTimeGenerated;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    protected Invoice() {
    }

    private Invoice(InvoiceBuilder e) {
        this.invoiceId = e.invoiceId;
        this.dateTimeGenerated = e.dateTimeGenerated;
        this.orders = e.orders;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public LocalDateTime getDateTimeGenerated() {
        return dateTimeGenerated;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceId, invoice.invoiceId) && Objects.equals(dateTimeGenerated, invoice.dateTimeGenerated) && Objects.equals(orders, invoice.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, dateTimeGenerated, orders);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", dateTimeGenerated=" + dateTimeGenerated +
                ", orders=" + orders +
                '}';
    }

    public static class InvoiceBuilder {
        private Long invoiceId;
        private LocalDateTime dateTimeGenerated;
        private List<Order> orders;

        public InvoiceBuilder setInvoiceId(Long invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        public InvoiceBuilder setDateTimeGenerated(LocalDateTime dateTimeGenerated) {
            this.dateTimeGenerated = dateTimeGenerated;
            return this;
        }

        public InvoiceBuilder setOrders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public InvoiceBuilder copy(Invoice e) {
            this.invoiceId = e.invoiceId;
            this.dateTimeGenerated = e.dateTimeGenerated;
            this.orders = e.orders;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }
}