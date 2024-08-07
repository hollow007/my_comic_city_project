/*Joshua Mokwebo
Student Number : 222191562
GitHUB Usersname : Fullfy_J
 */


package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.factory.BillingAddressFactory;
import za.ac.cput.service.addressService.BillingAddressService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillingAddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String base_url = "http://localhost:8080/comiccity/billing_address";
    private static BillingAddress billingAddress;



    @BeforeAll
    static void setUp() {
         billingAddress = BillingAddressFactory.buildBillingAddress("Cash","65 Vilakazi Street", "Alex", "7800", "Johannesburg");
         System.out.println(billingAddress);
    }


    @Test
    void a_welome() throws Exception{
        String url = base_url +"/Welcome";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello There ! Welcome to the Billing Address Service");
        System.out.println(response.getBody());
    }

    @Test
    void b_createBillingAddressService() throws Exception {
      String url = base_url +"/create";


      ResponseEntity<BillingAddress> response = restTemplate.postForEntity(url,billingAddress, BillingAddress.class);
      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      billingAddress = response.getBody();

      System.out.println("billingAddres: "+ billingAddress);


    }

    @Test
    void c_readBillingAddressService() {
        String url = base_url + "/read/"+ billingAddress.getId() ;
        //System.out.println("billingAddresid: "+ billingAddress.getId());
        ResponseEntity<BillingAddress> response = restTemplate.getForEntity(url,BillingAddress.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println("retrieved address: "+response.getBody());

    }


    @Test
    void d_updateBillingAddressService() {
        String url = base_url + "/update";
        billingAddress= new BillingAddress.BillingAddressBuilder().copy(billingAddress).setPaymentMethod("on delivary").build();

        ResponseEntity<BillingAddress> response = restTemplate.postForEntity(url,billingAddress,BillingAddress.class);
        assertNotNull(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        billingAddress = response.getBody();
        System.out.println(billingAddress);

    }

    @Test
    //@Disabled
    void e_deleteBillingAddressService() {
        String url = base_url +"/delete/" + billingAddress.getId();
        restTemplate.delete(url);
        System.out.println("Address Deleted");
    }

    @Test
    //@Disabled
    void getall(){
        String url = base_url + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
    }
}