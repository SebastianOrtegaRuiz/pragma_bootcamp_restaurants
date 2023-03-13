package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.Restaurant_EmployeeRequestDto;
import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;

import java.util.List;

public interface IRestaurant_EmployeeHandler {
    void saveRestaurant_Employee(Restaurant_EmployeeRequestDto restaurant_employeeRequestDto);

    List<Restaurant_EmployeeResponseDto> getAllRestaurant_Employee();

}
