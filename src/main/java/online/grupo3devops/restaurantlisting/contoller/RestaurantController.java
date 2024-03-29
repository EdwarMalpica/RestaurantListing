package online.grupo3devops.restaurantlisting.contoller;

import online.grupo3devops.restaurantlisting.dto.RestaurantDTO;
import online.grupo3devops.restaurantlisting.entity.Restaurant;
import online.grupo3devops.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping(value = "/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInBD(restaurantDTO);
       /* Restaurant restaurantAdded = restaurantService.addRestaurantInBD(restaurantDTO);*/
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Long id){
        return restaurantService.fetchRestaurantById(id);
    }
}
