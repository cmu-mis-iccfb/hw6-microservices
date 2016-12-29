package io.spring.cloud.samples.commerce.ui.services.backends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author sgupta
 * @since 10/14/16.
 */
@Service
public class PriceService {

  @Autowired
  RestTemplate restTemplate;


}
