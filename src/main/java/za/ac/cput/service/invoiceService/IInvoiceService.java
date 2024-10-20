package za.ac.cput.service.invoiceService;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Invoice;
import za.ac.cput.service.IService;
import java.util.List;
@Service
public interface IInvoiceService extends IService<Invoice, Long> {
    List<Invoice> getAll();
}
