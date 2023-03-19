package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.Restaurant_EmployeeRequestDto;
import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.handler.IRestaurant_EmployeeHandler;
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
@RequestMapping("/api2/v1/restaurant_employee")
@RequiredArgsConstructor
@Api(value = "Used to set and consult the occupational field of every restaurant employee")
public class Restaurant_EmployeeRestController {
    private final IRestaurant_EmployeeHandler restaurant_employeeHandler;

    private final IRestaurantsHandler restaurantsHandler;

    private IUtilities utilities;

    @Autowired
    public void setUtilities(IUtilities utilities) { this.utilities = utilities;}

    @ApiOperation(value = "Save the field for the employee")
    @PostMapping("/")
    public ResponseEntity<Void> saveRestaurant_Employee(@ApiParam(value = "require only the String of field in JSON format Object to save", required = true)
                                                        @RequestBody Restaurant_EmployeeRequestDto restaurant_employeeRequestDto,
                                                        @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.getRol(authorization).equals("PROPIETARIO")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        RestaurantsOwnerResponseDto restaurant = restaurantsHandler.getRestaurantsOwnerById(restaurant_employeeRequestDto.getId_restaurant());

        if(restaurant==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        restaurant_employeeRequestDto.getUsersRequestDto().setId_rol(3L);
        UserResponseDto userResponseDto = restaurantsHandler.saveUser(restaurant_employeeRequestDto.getUsersRequestDto(), authorization);

        if(userResponseDto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        restaurant_employeeRequestDto.setId_person(userResponseDto.getId());

        restaurant_employeeHandler.saveRestaurant_Employee(restaurant_employeeRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all restaurant's employees", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<Restaurant_EmployeeResponseDto>> getAllRestaurant_Employee() {
        return ResponseEntity.ok(restaurant_employeeHandler.getAllRestaurant_Employee());
    }
}
