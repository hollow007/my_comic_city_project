package za.ac.cput.service.contactRepository;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.IService;

import java.util.List;


@Service

public interface IContactService extends IService<Contact, String> {
    List<Contact> getAll();
}
