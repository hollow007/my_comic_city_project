package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import za.ac.cput.domain.BillingAddress;
import za.ac.cput.factory.BillingAddressFactory;
import za.ac.cput.service.addressService.BillingAddressService;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class BillingAddressControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private BillingAddressService billingAddressService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static BillingAddress billingAddress;
    private static BillingAddress billingAddress2;



    @BeforeAll
    static void setUp() {
         billingAddress = BillingAddressFactory.buildBillingAddress("Cash","65 Vilakazi Street", "Alex", "78000", "Johannesburg");
    }


    @Test
    void createBillingAddressService() throws Exception {
        billingAddress2 = BillingAddressFactory.buildBillingAddress("Cash","65 Vilakazi Street", "Alex", "78000", "Johannesburg");
        String billingAddressJson = objectMapper.writeValueAsString(billingAddress2);

        MvcResult result = mvc.perform(post("/comiccity/billing_address")
                .contentType(MediaType.APPLICATION_JSON)
                .content(billingAddressJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paymentMethod", is("Cash")))
                .andExpect(jsonPath("$.street", is("65 Vilakazi street")))
                .andExpect((jsonPath("$.suburb", is("Alex"))))
                .andExpect(jsonPath("$.postalCode", is("78000")))
                .andExpect(jsonPath("$.city",is("Johannesburg")))
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        System.out.println("responseBody: " + responseBody);

    }

    @Test
    void readBillingAddressService() {
    }

    @Test
    void updateBillingAddressService() {
    }

    @Test
    void deleteBillingAddressService() {
    }
}