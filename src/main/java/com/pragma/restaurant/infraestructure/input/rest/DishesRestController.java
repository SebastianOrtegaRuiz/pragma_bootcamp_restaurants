package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.dishes.DishesChangeStatusRequestDto;
import com.pragma.restaurant.application.dto.request.dishes.DishesRequestDto;
import com.pragma.restaurant.application.dto.request.dishes.DishesUpdateRequestDto;
import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.handler.IDishesHandler;
import com.pragma.restaurant.application.handler.IRestaurantsHandler;
import com.pragma.restaurant.infraestructure.utilities.IUtilities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2/v1/dishes")
@RequiredArgsConstructor
@Api(value = "Dishes CRUD")
public class DishesRestController {

    private final IDishesHandler dishesHandler;

    private final IRestaurantsHandler restaurantsHandler;

    private IUtilities utilities;

    @Autowired
    public void setUtilities(IUtilities utilities) { this.utilities = utilities;}

    @ApiOperation(value = "Save a dish")
    @PostMapping("/")
    public ResponseEntity<Void> saveDishes(@ApiParam(value = "require a JSON format Object to save a dish", required = true)
                                           @RequestBody DishesRequestDto dishesRequestDto,
                                           @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("PROPIETARIO")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        RestaurantsOwnerResponseDto restaurant = restaurantsHandler.getRestaurantsOwnerById(dishesRequestDto.getId_restaurant());

        if(restaurant==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserResponseDto user = dishesHandler.getUserByEmail(utilities.getEmail(authorization), authorization);

        if(user.getId()!=restaurant.getId_owner()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        dishesHandler.saveDishes(dishesRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a dish")
    @PutMapping("/updateDescription/")
    public ResponseEntity<String> updateDishes(@ApiParam(value = "require a JSON format Object to update a dish", required = true)
                                           @RequestBody DishesUpdateRequestDto dishesUpdateRequestDto,
                                           @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("PROPIETARIO")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        DishesResponseDto dishesResponseDto = dishesHandler.getDishesById(dishesUpdateRequestDto.getId());

        if(dishesResponseDto==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El plato no existe");
        }

        UserResponseDto user = dishesHandler.getUserByEmail(utilities.getEmail(authorization), authorization);

        if(user.getId()!=dishesResponseDto.getRestaurantsOwnerResponseDto().getId_owner()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El plato pertenece a un restaurante que no corresponde al usuario propietario");
        }

        dishesResponseDto.setDescription(dishesUpdateRequestDto.getDescription());
        dishesResponseDto.setPrice(dishesUpdateRequestDto.getPrice());

        dishesHandler.updateDishes(dishesResponseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Active or inactive a dish")
    @PutMapping("/changestatus/")
    public ResponseEntity<String> updateDishes(@ApiParam(value = "require a JSON format Object to change status to a dish", required = true)
                                               @RequestBody DishesChangeStatusRequestDto dishesChangeStatusRequestDto,
                                               @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("PROPIETARIO")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        DishesResponseDto dishesResponseDto = dishesHandler.getDishesById(dishesChangeStatusRequestDto.getId());

        if(dishesResponseDto==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El plato no existe");
        }

        UserResponseDto user = dishesHandler.getUserByEmail(utilities.getEmail(authorization), authorization);

        if (user.getId() != dishesResponseDto.getRestaurantsOwnerResponseDto().getId_owner()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El plato pertenece a un restaurante que no corresponde al usuario propietario");
        }

        dishesResponseDto.setActive(dishesChangeStatusRequestDto.getActive());

        dishesHandler.changeStatusDishes(dishesResponseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all dishes", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<DishesResponseDto>> getAllDishes() {
        return ResponseEntity.ok(dishesHandler.getAllDishes());
    }

    @ApiOperation(value = "Get one specific dishes by id", response = DishesResponseDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<DishesResponseDto> getDishesById(@ApiParam(value = "id to search for a specific dishes", required = true) @PathVariable("id") Long id) {
        DishesResponseDto dishesResponseDto = dishesHandler.getDishesById(id);
        if(dishesResponseDto==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(dishesResponseDto);
    }

}
