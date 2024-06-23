package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminFactoryTest {


    private static Admin admin1;
    private static Admin admin2;

    static Contact adminContact1;
    static Contact adminContact2;
    static Address adminAddress1;
    static Address adminAddress2;

    @BeforeAll
    static void setUp() {
        adminAddress1 = AddressFactory.buildAddress("106 Gasela", "Guguletu", "7750", "Cape Town");
        adminContact1 = AdminContactFactory.buildContact("mphumzimbula@gmail.com", "0658436358", adminAddress1);
        admin1 = AdminFactory.buildAdmin(1L, "Mpumzi", "Mbula", "20Mphmbu16!", adminContact1);

        adminAddress2 = AddressFactory.buildAddress("7 Galatasaray", "Woodstock", "8001", "Cape Town");
        adminContact2 = AdminContactFactory.buildContact("mlungisiMbuyazi@gmail.com", "0835800055", adminAddress2);
        admin2 = AdminFactory.buildAdmin(2L, "Mlungisi", "", "Mbuyazi", "20Mluyazi16!", adminContact2);
    }

    @Test
    void buildAdmin() {
        assertNotNull(admin1);
        System.out.println(admin1);
    }

    @Test
    void buildAdminFailTest() {
     assertNotNull(admin2);
     System.out.println(admin2);

        //should fail because middle name is deliberatly left empty
    }
}