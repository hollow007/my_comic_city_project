/*Joshua Mokwebo
Student Number : 222191562
GitHUB Usersname : Fullfy_J
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.ShippingAddress;
import za.ac.cput.factory.ShippingAddressFactory;

import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ShippingAddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String base_url = "http://localhost:8080/comiccity/shipping_address";
    private static ShippingAddress shippingAddress;

    @BeforeAll
    static void setUp() {shippingAddress = ShippingAddressFactory.buildShippingAddress(LocalTime.of(18,00,00), "109 KuliChana Street", "Milnerton", "7220","Durban");}

    @Test
    void a_welcome() {
        String url = base_url + "/Welcome";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    }

    @Test
    void b_createShippingAddress() {
        String url = base_url +"/create";
        ResponseEntity<ShippingAddress> response = restTemplate.postForEntity(url,shippingAddress,ShippingAddress.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertNotNull(response);
        shippingAddress = response.getBody();
        System.out.println(shippingAddress + " [Saved]");

    }

    @Test
    void b_readShippingAddress() {
        String url = base_url + "/read/" + shippingAddress.getId();
        ResponseEntity<ShippingAddress> response = restTemplate.getForEntity(url,ShippingAddress.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(response);

        shippingAddress = response.getBody();
        System.out.println(shippingAddress + "[Read]");
    }

    @Test
    void d_updateShippingAddress() {
        String url = base_url +"/update";
        shippingAddress = new ShippingAddress.ShippingAddressBuilder().copy(shippingAddress).setStreet("69 baker street").build();

        ResponseEntity<ShippingAddress> response = restTemplate.postForEntity(url,shippingAddress,ShippingAddress.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertNotNull(response);
        shippingAddress = response.getBody();
        System.out.println(shippingAddress + " [updated]");
    }

    @Test
    void delete(){
        String url = base_url +"/delete/"+shippingAddress.getId();
        restTemplate.delete(url);
        System.out.println("Shipping Address deleted");
    }

    @Test
    void getall() {
        String url = base_url + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);

    }
}