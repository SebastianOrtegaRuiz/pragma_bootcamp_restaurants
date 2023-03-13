package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.Restaurant_EmployeeRequestDto;
import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;
import com.pragma.restaurant.application.handler.IRestaurant_EmployeeHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant_employee")
@RequiredArgsConstructor
@Api(value = "Used to set and consult the occupational field of every restaurant employee")
public class Restaurant_EmployeeRestController {
    private final IRestaurant_EmployeeHandler restaurant_employeeHandler;

    @ApiOperation(value = "Save the field for the employee")
    @PostMapping("/")
    public ResponseEntity<Void> saveRestaurant_Employee(@ApiParam(value = "require only the String of field in JSON format Object to save", required = true) @RequestBody Restaurant_EmployeeRequestDto restaurant_employeeRequestDto) {
        restaurant_employeeHandler.saveRestaurant_Employee(restaurant_employeeRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all restaurant's employees", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<Restaurant_EmployeeResponseDto>> getAllRestaurant_Employee() {
        return ResponseEntity.ok(restaurant_employeeHandler.getAllRestaurant_Employee());
    }
}
