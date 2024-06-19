package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private LocalDateTime dateTimeGenerated;
    @OneToOne(mappedBy = "invoice")
    private Order order;

    protected Invoice() {
    }

    private Invoice(InvoiceBuilder e) {
        this.dateTimeGenerated = e.dateTimeGenerated;
        this.order = e.order;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public LocalDateTime getDateTimeGenerated() {
        return dateTimeGenerated;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceId, invoice.invoiceId) && Objects.equals(dateTimeGenerated, invoice.dateTimeGenerated) && Objects.equals(order, invoice.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, dateTimeGenerated, order);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", dateTimeGenerated=" + dateTimeGenerated +
                ", orders=" + order +
                '}';
    }

    public static class InvoiceBuilder {
        private LocalDateTime dateTimeGenerated;
        private Order order;

        public InvoiceBuilder setDateTimeGenerated(LocalDateTime dateTimeGenerated) {
            this.dateTimeGenerated = dateTimeGenerated;
            return this;
        }

        public InvoiceBuilder setOrders(Order order) {
            this.order = order;
            return this;
        }

        public InvoiceBuilder copy(Invoice e) {
            this.dateTimeGenerated = e.dateTimeGenerated;
            this.order = e.order;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }
}