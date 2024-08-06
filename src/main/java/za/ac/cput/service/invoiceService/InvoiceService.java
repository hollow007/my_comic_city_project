package za.ac.cput.service.invoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.service.customerOrderService.CustomerOrderService;

import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private InvoiceRepository repo;
    @Autowired
    private CustomerOrderService customerOrderService;

    @Transactional
    public Invoice create(Invoice invoice) {
        // Handle CustomerOrder
        CustomerOrder customerOrder = invoice.getOrder();
        if (customerOrder != null) {
            customerOrder = customerOrderService.create(customerOrder);
        }

        invoice.setOrder(customerOrder);

        return repo.save(invoice);
    }

    @Override
    public Invoice read(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Invoice update(Invoice invoice) {
        // Handle CustomerOrder
        CustomerOrder customerOrder = invoice.getOrder();
        if (customerOrder != null) {
            customerOrder = customerOrderService.create(customerOrder);
        }

        invoice.setOrder(customerOrder);

        return repo.save(invoice);
    }

    @Override
    public boolean delete(Long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    @Override
    public List<Invoice> getAll() {
        return repo.findAll();
    }
}