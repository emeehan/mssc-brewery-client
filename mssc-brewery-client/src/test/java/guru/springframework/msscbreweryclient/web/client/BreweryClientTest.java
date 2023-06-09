package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    // cause SpringBoot to create a BreweryClient instance which will automatically
    // inject a RestTemplateBuilder
    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer() {
        // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        // given
        CustomerDto customerDto = CustomerDto.builder().name("Clark Kent").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Bruce Wayne").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}