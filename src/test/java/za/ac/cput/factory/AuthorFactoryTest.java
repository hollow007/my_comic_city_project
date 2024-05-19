package za.ac.cput.factory;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Author;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthorFactoryTest {
    private Author author1;
    private  Author author2;
    private  Author author3;

    @BeforeEach
    void setUp() {
        author1 = AuthorFactory.buildAuthor(001, "Lamark", "", "Darwin");
        author2 = AuthorFactory.buildAuthor(002, "", "Gedleyihlekisa", "Zuma");
        author3 = AuthorFactory.buildAuthor(-1, "", "Negative", "Number");

    }

    @Test
    void buildAuthorWithMissingMiddleName() {
        assertNotNull(author1);
        System.out.println(author1);

    }

    @Test
    void buildAuthorWithNullFirstName() {
        assertNull(author2);
        System.out.println(author2);

    }


    @Test
    void buildAuthorWithNegativeNumber() {
        assertNull(author3);
        System.out.println(author3);

    }
}