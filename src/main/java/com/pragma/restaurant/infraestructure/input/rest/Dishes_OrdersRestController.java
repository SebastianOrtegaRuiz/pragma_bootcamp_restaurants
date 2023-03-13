package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.Dishes_OrdersResponseDto;
import com.pragma.restaurant.application.handler.IDishes_OrdersHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dishes_orders")
@RequiredArgsConstructor
@Api(value = "Used to set and consult the amount of dishes for every order")
public class Dishes_OrdersRestController {
    private final IDishes_OrdersHandler dishes_ordersHandler;

    @ApiOperation(value = "Save the units for the order")
    @PostMapping("/")
    public ResponseEntity<Void> saveDishes_Orders(@ApiParam(value = "require only the units in JSON format Object to save an order", required = true) @RequestBody Dishes_OrdersRequestDto dishes_ordersRequestDto) {
        dishes_ordersHandler.saveDishes_Orders(dishes_ordersRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all Dishes order", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<Dishes_OrdersResponseDto>> getAllDishes_Orders() {
        return ResponseEntity.ok(dishes_ordersHandler.getAllDishes_Orders());
    }
}
