package guru.springframework.msscbreweryclient;

import guru.springframework.msscbreweryclient.web.client.BreweryClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableConfigurationProperties({BreweryClient.class})
class MsscBreweryClientApplicationTests {

    @Test
    void contextLoads() {
    }

}
