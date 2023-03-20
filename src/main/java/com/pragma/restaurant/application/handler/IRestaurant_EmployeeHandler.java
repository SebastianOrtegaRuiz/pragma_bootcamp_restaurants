package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.Restaurant_EmployeeRequestDto;
import com.pragma.restaurant.application.dto.request.UsersRequestDto;
import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;

import java.util.List;

public interface IRestaurant_EmployeeHandler {
    void saveRestaurant_Employee(Restaurant_EmployeeRequestDto restaurant_employeeRequestDto);
    List<Restaurant_EmployeeResponseDto> getAllRestaurant_Employee();
    Restaurant_EmployeeResponseDto getRestaurant_EmployeeById_Person(Long id_person,  Long id_restaurant);

    Restaurant_EmployeeResponseDto getRestaurant_EmployeeById(Long id_person);
}


