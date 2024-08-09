package za.ac.cput.factory;

import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.domain.Invoice;
import za.ac.cput.util.Helper;
import java.time.LocalDateTime;

/* InvoiceFactory.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 18 June 2024
   https://github.com/hollow007/my_comic_city_project
 */
public class InvoiceFactory {
    public static Invoice buildInvoice(Long invoiceId, CustomerOrder customerOrder, LocalDateTime dateTimeGenerated) {
        if (Helper.isObjectNull(customerOrder) || Helper.isObjectNull(dateTimeGenerated)) {
            return null;
        }

        return new Invoice.InvoiceBuilder()
                .setInvoiceId(invoiceId)
                .setOrder(customerOrder)
                .setDateTimeGenerated(dateTimeGenerated)
                .build();
    }
}