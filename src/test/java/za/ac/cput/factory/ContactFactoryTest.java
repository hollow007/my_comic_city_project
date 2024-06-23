package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    @Test
    void buildContact() {
        Contact contact1=ContactFactory.buildContact("mphumzimbula@gmail.com","0658436358");
        assertNotNull(contact1);
        System.out.println(contact1);
    }

    @Test
    void buildContactWithNullAddress() {
        Contact contact2=ContactFactory.buildContact("","0658436358");
        assertNotNull(contact2);
        System.out.println(contact2);
    }
}