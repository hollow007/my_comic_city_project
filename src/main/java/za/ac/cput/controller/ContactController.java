package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.contactService.ContactService;

import java.util.List;

@RestController
@RequestMapping("/Contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {
    @Autowired
    private ContactService service;

    @PostMapping("/create")
    public ResponseEntity<Contact> create(@RequestBody Contact contact) {
        System.out.println("Entered Contact");

        Contact savedContact = service.create(contact);
        System.out.println("Saved Contact: " + savedContact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    @GetMapping("/read/{email}")
    public ResponseEntity<Contact> read(@PathVariable String email) {
        Contact contact = service.read(email);
        if (contact == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(contact);
    }

    @PostMapping("/update")
    public ResponseEntity<Contact> update(@RequestBody Contact contact) {
        Contact updatedContact = service.update(contact);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) {
        if (service.delete(email)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contacts = service.getAll();
        return ResponseEntity.ok(contacts);
    }
}
