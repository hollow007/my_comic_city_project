package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Invoice;
import za.ac.cput.service.invoiceService.InvoiceService;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create")
    public Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.create(invoice);
    }

    @GetMapping("/read/{invoiceId}")
    public Invoice read(@PathVariable Long invoiceId) {
        return invoiceService.read(invoiceId);
    }

    @PostMapping("/update")
    public Invoice update(@RequestBody Invoice invoice) {
        return invoiceService.update(invoice);
    }

    @DeleteMapping("/delete/{invoiceId}")
    public boolean delete(@PathVariable Long invoiceId) {
        return invoiceService.delete(invoiceId);
    }

    @GetMapping("/getAll")
    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }
}