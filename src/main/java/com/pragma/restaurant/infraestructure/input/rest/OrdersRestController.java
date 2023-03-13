package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.application.handler.IOrdersHandler;
import com.pragma.restaurant.infraestructure.exception.NoValidNumber;
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
@RequestMapping("/api2/v1/orders")
@RequiredArgsConstructor
@Api(value = "Orders CRUD")
public class OrdersRestController {

    private final IOrdersHandler ordersHandler;

    @ApiOperation(value = "Save an Order")
    @PostMapping("/")
    public ResponseEntity<Void> saveOrders(@ApiParam(value = "require a JSON format Object to save an order", required = true) @RequestBody OrdersRequestDto ordersRequestDto) {

        ordersHandler.saveOrders(ordersRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all orders", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<OrdersResponseDto>> getAllOrders() {
        return ResponseEntity.ok(ordersHandler.getAllOrders());
    }

}
