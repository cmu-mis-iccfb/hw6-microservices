package io.spring.cloud.samples.commerce.ui.services.backends;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackItems")
    public Item[] allItems() {
      ResponseEntity<Item[]> responseEntity =
          restTemplate.getForEntity("http://item/items", Item[].class);
      return responseEntity.getBody();
    }

    private Item[] fallbackItems() {
      return new Item[]{new Item(0L, "Items not found, try again :(")};
    }
}
