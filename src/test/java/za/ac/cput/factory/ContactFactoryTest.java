package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ContactFactoryTest {

    private Contact con1;
    private  Contact con2;
    private  Contact con3;


    @Test
    @BeforeEach
    void setUp() {
        con1 = ContactFactory.buildContact("mblungisi@gmail.com", "0739946042", "0216549867");

        con2 = ContactFactory.buildContact("2-mycput.za", "0739946042", "0216549869");

        con3 = ContactFactory.buildContact("22...@mycput.ac.za", "073994u042", "0216549860");

    }

    @Test
    void buildEmployeeWithValidDetails() {
        assertNotNull(con1);
        System.out.println(con1);

    }

    @Test
    void buildEmployeeWithIncorrectEmail() {
        assertNotNull(con2);
        System.out.println(con2);

    }

    @Test
    void buildEmployeeWithIncorrectEmail2() {
        assertNull(con3);
        System.out.println(con3);

    }
}