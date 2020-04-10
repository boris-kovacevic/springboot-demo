package springbootintro.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/shop")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewShop(@RequestParam String name, @RequestParam String address, @RequestParam String city){
        Shop shop = new Shop();
        shop.setName(name);
        shop.setAddress(address);
        shop.setCity(city);
        shopRepository.save(shop);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Shop> getAllUsers(){
        return shopRepository.findAll();
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody
    Optional<Shop> get(@PathVariable int id){
        return shopRepository.findById(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void delete(@PathVariable int id){
        shopRepository.deleteById(id);
    }

    @DeleteMapping(path="/delete/all")
    public @ResponseBody void delete(){
        shopRepository.deleteAll();
    }

    @GetMapping(path="/get-by-city")
    public @ResponseBody List<Shop> getByCity(@RequestParam String city){
        return shopRepository.getByCity(city);
    }

}
