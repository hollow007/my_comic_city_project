package za.ac.cput.service.invoiceService;

import za.ac.cput.domain.Invoice;
import za.ac.cput.service.IService;
import java.util.List;

public interface IInvoiceService extends IService<Invoice, Long> {
    List<Invoice> getAll();
}
