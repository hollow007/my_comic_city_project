package za.ac.cput.controller;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.*;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.ComicBookFactory;
import za.ac.cput.factory.PublisherFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
/**
 * Mpumzi Mbula
 * 219053324
 * 26/05/2024
 */
class CartControllerTest {


    @Autowired
    TestRestTemplate restTemplate;
    private static final String BASE_URL="http://localhost:8080/comiccity/cart";
    private static Cart cart1;

    private static Author author1;

    static Publisher publisher1;

    private static ComicBook book1;

    private static List<Author> authors1;

    private static List<ComicBook> comicBookList1;



    @BeforeAll
    static void a_setUp() {


        publisher1 = PublisherFactory.buildPublisher(67954, "Kat Publishers", 2010);

        author1 = AuthorFactory.buildAuthor(001, "Lamark", "Principle", "Darwin");

        authors1 = new ArrayList<>();
        authors1.add(author1);


        book1 = ComicBookFactory.buildBuilder("CMB01", "Thor", 3.4, LocalDate.now(), authors1, publisher1,300.00);
        System.out.println(book1);

        comicBookList1 = new ArrayList<>();
        comicBookList1.add(book1);

        cart1 = CartFactory.buildCart( 200.00, comicBookList1, LocalDate.of(2024, 02, 15), LocalDate.now());

        System.out.println(cart1);


    }

    @Test
    void b_create() {

        String url=BASE_URL+"/create";
        System.out.println(cart1);
        ResponseEntity<Cart> postResponse=restTemplate.postForEntity(url,cart1,Cart.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Cart cartSaved =postResponse.getBody();
        System.out.println("Recieved cart"+cartSaved);
        assertEquals(cart1.getTotalPrice(), cartSaved.getTotalPrice());
        System.out.println("Saved data: "+ cartSaved);


    }

    @Test
    void c_read() {
        String url=BASE_URL+"/read/"+1L;
        System.out.println("URL: "+url);
        ResponseEntity<Cart>response=restTemplate.getForEntity(url, Cart.class);
        System.out.println("Read:"+response.getBody());
    }

    @Test
    void d_update() {
        String url= BASE_URL + "/update";
        Cart newCart=new Cart.Builder().copy(cart1).setTotalPrice(700).build();
        ResponseEntity<Cart> postResponse=restTemplate.postForEntity(url,newCart,Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Cart cartUpdated =postResponse.getBody();
        assertEquals(newCart.getTotalPrice(),cartUpdated.getTotalPrice());

    }

    @Test
    void e_delete() {
        String url=BASE_URL+"/delete/"+2L;
        System.out.println("URL:"+url);
        restTemplate.delete(url);
        System.out.println("Success:Deleted cart");
    }

    @Test
    void f_getall() {
        String url=BASE_URL+"/getall";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity=new HttpEntity<>(null,headers);
        ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}