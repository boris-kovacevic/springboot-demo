package springbootintro.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

//import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String address, @RequestParam String city){
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setCity(city);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/get")
    public @ResponseBody ResponseEntity<String> get(){
        return new ResponseEntity<String>("GET response", HttpStatus.OK);
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody Optional<User> get(@PathVariable int id){
        return userRepository.findById(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @DeleteMapping(path="/delete/all")
    public @ResponseBody void delete(){
        userRepository.deleteAll();
    }

    @GetMapping(path="/get-city")
    public @ResponseBody String test(@RequestParam Integer id){
        return userRepository.findById((int)id).get().getCity();
    }
}

