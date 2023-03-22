package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

// @Component causes Spring to register this class as a bean
// @ConfigurationProperties provides a way to bind a configuration
// value from applications.properties to this bean

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
    // we are persisting the V1 path to the msc-brewery here
    public final String BEER_PATH_V1 = "/api/v1/beer";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer";

    // by using the @ConfigurationProperties we can easily specify a different
    // host by just changing the value in application.properties
    private String apihost;

    private final RestTemplate restTemplate;

    // set up a constructor to get a RestTemplateBuilder injected from Spring
    // we are using the default configuration at this point to create a
    // RestTemplate which we are persisting in the instance variable
    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // HTTP GET method BEER API
    public BeerDto getBeerById(UUID uuid){
        // using the RestTemplate invoke a get http://localhost:8080/api/v1/beer/{UUID} and marshal
        // the return into a BeerDto.class object
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + "/" + uuid.toString(), BeerDto.class);
    }

    // HTTP POST method BEER API
    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    // HTTP PUT method BEER API
    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
    }

    // HTTP DELETE method BEER API
    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid.toString());
    }

    // HTTP GET method CUSTOMER API
    public CustomerDto getCustomerById(UUID uuid){
        // using the RestTemplate invoke a get http://localhost:8080/api/v1/beer/{UUID} and marshal
        // the return into a BeerDto.class object
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), CustomerDto.class);
    }

    // HTTP POST method CUSTOMER API
    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    // HTTP PUT method BEER API
    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), customerDto);
    }

    // HTTP DELETE method BEER API
    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString());
    }


    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
