package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    @OneToOne
    private CustomerOrder customerOrder;

    protected Invoice() {
    }

    private Invoice(InvoiceBuilder e) {
        this.invoiceId = e.invoiceId;
        this.dateTimeGenerated = e.dateTimeGenerated;
        this.customerOrder = e.customerOrder;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public LocalDateTime getDateTimeGenerated() {
        return dateTimeGenerated;
    }

    public CustomerOrder getOrder() {
        return customerOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceId, invoice.invoiceId) && Objects.equals(dateTimeGenerated, invoice.dateTimeGenerated) && Objects.equals(customerOrder, invoice.customerOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, dateTimeGenerated, customerOrder);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", dateTimeGenerated=" + dateTimeGenerated +
                ", orders=" + customerOrder +
                '}';
    }

    public static class InvoiceBuilder {
        private Long invoiceId;
        private LocalDateTime dateTimeGenerated;
        private CustomerOrder customerOrder;

        public InvoiceBuilder setInvoiceId(Long invoiceId){
            this.invoiceId = invoiceId;
            return this;
        }

        public InvoiceBuilder setDateTimeGenerated(LocalDateTime dateTimeGenerated) {
            this.dateTimeGenerated = dateTimeGenerated;
            return this;
        }

        public InvoiceBuilder setOrder(CustomerOrder customerOrder) {
            this.customerOrder = customerOrder;
            return this;
        }

        public InvoiceBuilder copy(Invoice e) {
            this.invoiceId = e.invoiceId;
            this.dateTimeGenerated = e.dateTimeGenerated;
            this.customerOrder = e.customerOrder;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }
}