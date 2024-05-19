package za.ac.cput.service.contactRepository;

import za.ac.cput.domain.Contact;
import za.ac.cput.service.IService;

import java.util.List;

public interface IContactService extends IService<Contact, String> {
    List<Contact> getAll();
}
