package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.DishesRequestDto;
import com.pragma.restaurant.application.dto.response.DishesResponseDto;
import com.pragma.restaurant.application.handler.IDishesHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api2/v1/dishes")
@RequiredArgsConstructor
@Api(value = "Dishes CRUD")
public class DishesRestController {

    private final IDishesHandler dishesHandler;

    @ApiOperation(value = "Save a dish")
    @PostMapping("/")
    public ResponseEntity<Void> saveDishes(@ApiParam(value = "require a JSON format Object to save a dish", required = true) @RequestBody DishesRequestDto dishesRequestDto) {
        dishesHandler.saveDishes(dishesRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all dishes", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<DishesResponseDto>> getAllDishes() {
        return ResponseEntity.ok(dishesHandler.getAllDishes());
    }

}
