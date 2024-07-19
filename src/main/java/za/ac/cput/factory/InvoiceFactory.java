package za.ac.cput.factory;

import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Order;
import java.time.LocalDateTime;
import za.ac.cput.util.Helper;
/* InvoiceFactory.java
   Author: Cavan Ramone Swartz (221055835)
   Date: 21 June 2024
   https://github.com/hollow007/my_comic_city_project
 */

public class InvoiceFactory {
    public static Invoice buildInvoice(Long invoiceId, LocalDateTime dateTimeGenerated, Order order) {
        if (Helper.isValidDate(dateTimeGenerated.toLocalDate()) || Helper.isObjectNull(order)) {
            return null;
        }

        return new Invoice.InvoiceBuilder()
                .setInvoiceId(invoiceId)
                .setDateTimeGenerated(dateTimeGenerated)
                .setOrder(order)
                .build();
    }
}