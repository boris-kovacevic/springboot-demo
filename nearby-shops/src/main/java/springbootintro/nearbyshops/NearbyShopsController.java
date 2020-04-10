package springbootintro.nearbyshops;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/nearby-shops")
public class NearbyShopsController {

    @GetMapping(path = "/get-by-city")
    public @ResponseBody
    Iterable<Shop> getNearbyShops(@RequestParam Integer userId) {
        RestTemplate restTemplate = new RestTemplate();
        String shopUrl = "http://localhost:8081/shop";
        String userUrl = "http://localhost:8080/user";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userUrl + "/get-city").queryParam("id", userId);
        String city = restTemplate.getForObject(builder.toUriString(), String.class);

        builder = UriComponentsBuilder.fromHttpUrl(shopUrl + "/get-by-city").queryParam("city", city);
        List<Shop> shop = restTemplate.getForObject(builder.toUriString(), List.class);
        return shop;
    }
}
