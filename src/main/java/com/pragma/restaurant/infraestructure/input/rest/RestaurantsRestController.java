package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.RestaurantsRequestDto;
import com.pragma.restaurant.application.dto.response.ResponsePagedDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.application.handler.IRestaurantsHandler;
import com.pragma.restaurant.infraestructure.exception.NoValidNumber;
import com.pragma.restaurant.infraestructure.pagination.Pagination;
import com.pragma.restaurant.infraestructure.utilities.IUtilities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api2/v1/restaurants")
@RequiredArgsConstructor
@Api(value = "Restaurants CRUD")
public class RestaurantsRestController {

    private final IRestaurantsHandler restaurantsHandler;
    private final Pagination<RestaurantsResponseDto> pagination;
    private IUtilities utilities;
    @Autowired
    public void setUtilities(IUtilities utilities) { this.utilities = utilities;}

    @ApiOperation(value = "Save a restaurant")
    @PostMapping("/")
    public ResponseEntity<Void> saveRestaurants(@ApiParam(value = "require a JSON format Object to save a restaurant",
                                                required = true) @RequestBody RestaurantsRequestDto restaurantsRequestDto,
                                                @RequestHeader(value="Authorization") String authorization) {

        if(!utilities.validPhoneNumber(restaurantsRequestDto.getPhone())) {
            throw new NoValidNumber();
        }

        if(!utilities.getRol(authorization).equals("ADMINISTRADOR")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserResponseDto user = restaurantsHandler.getUser(restaurantsRequestDto.getId_owner(), authorization);
        if(user.getId_rol()==2) {
            restaurantsHandler.saveRestaurants(restaurantsRequestDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Get a list of all restaurants paginated by the parameters", response = List.class)
    @GetMapping("/{page}/{records}")
    public ResponseEntity<ResponsePagedDto<RestaurantsResponseDto>> getAllRestaurants(@ApiParam(value = "require an int for specified the page thats needs ", required = true) @PathVariable("page") int page,
                                                                                      @ApiParam(value = "require an int for specified the number of records per page", required = true) @PathVariable("records") int records) {

        Page<RestaurantsResponseDto> restaurantsDto = restaurantsHandler.getAllRestaurants(page, records);

        ResponsePagedDto<RestaurantsResponseDto> responsePagedDto = pagination.paginate(page, restaurantsDto);

        return ResponseEntity.ok(responsePagedDto);
    }

    @ApiOperation(value = "Get one specific restaurant by id", response = RestaurantsOwnerResponseDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantsResponseDto> getRestaurantsById(@ApiParam(value = "id to search for a specific restaurant", required = true) @PathVariable("id") Long id) {
        return ResponseEntity.ok(restaurantsHandler.getRestaurantsById(id));
    }

}
