package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Publisher;
import za.ac.cput.domain.WishList;
import za.ac.cput.factory.AuthorFactory;
import za.ac.cput.factory.ComicBookFactory;
import za.ac.cput.factory.PublisherFactory;
import za.ac.cput.factory.WishListFactory;

import org.springframework.http.HttpHeaders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Mpumzi Mbula
 * 219053324
 * 26/05/2024
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
class WishListControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BASE_URL="http://localhost:8080/comiccity/wishlist";

    private static WishList wishList;
    private static Author author1;
    private static ComicBook book1;

    private static List<Author> authors1;
    private static List<ComicBook> comicBookList1;
    private static Publisher publisher1;


    @BeforeAll
   public static void  a_setUp() {

        publisher1 = PublisherFactory.buildPublisher(67954, "Kat Publishers", 2010);

        author1 = AuthorFactory.buildAuthor(005, "Mpumzi", "August", "Mbula");
        authors1 = new ArrayList<>();
        authors1.add(author1);

        book1 = ComicBookFactory.buildBuilder("CMB01", "Thor", 3.4, LocalDate.now(), authors1, publisher1, 300.00);
        System.out.println(book1);

        comicBookList1 = new ArrayList<>();
        comicBookList1.add(book1);


        wishList = WishListFactory.buildWishList("Boyfriend's favoritBook To Buy", comicBookList1, LocalDate.of(2024, 02, 14), LocalDate.of(2024, 02, 15));

    }

    @Test
    void b_create() {

        String url=BASE_URL+"/create";
        System.out.println(wishList);
        ResponseEntity<WishList> postResponse=restTemplate.postForEntity(url,wishList,WishList.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        WishList wishListSaved =postResponse.getBody();
        System.out.println("Recieved WishList"+wishListSaved);
        assertEquals(wishList.getWishlistName(),wishListSaved.getWishlistName());
        System.out.println("Saved data: "+ wishListSaved);

    }

    @Test
    void c_read() {

        String url=BASE_URL+"/read/"+1L;
        System.out.println("URL: "+url);
        ResponseEntity<WishList>response=restTemplate.getForEntity(url, WishList.class);
       // assertEquals(1,response.getBody().getWishListId());
        System.out.println("Read:"+response.getBody());


    }

    @Test
    void d_update() {

        String url= BASE_URL + "/update";
        WishList newWishList=new WishList.Builder().copy(wishList).setWishlistName("Birthday Present Items").build();
        ResponseEntity<WishList> postResponse=restTemplate.postForEntity(url,newWishList,WishList.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        WishList wishListUpdated =postResponse.getBody();
        assertEquals(newWishList.getComicBooks(),wishListUpdated.getComicBooks());
    }

    @Test
    void e_delete() {
        String url=BASE_URL+"/delete/"+4L;
        System.out.println("URL:"+url);
        restTemplate.delete(url);
        System.out.println("Success:Deleted wishList");

    }

    @Test
    void f_getall() {
        String url=BASE_URL+"/getall";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String>entity=new HttpEntity<>(null,headers);
        ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}