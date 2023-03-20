package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;
import com.pragma.restaurant.domain.model.restaurant_Employee.Restaurant_EmployeeModel;

import java.util.List;

public interface IRestaurant_EmployeeServicePort {
    void saveRestaurant_Employee(Restaurant_EmployeeModel restaurant_employeeModel);

    List<Restaurant_EmployeeModel> getAllRestaurant_Employee();

    Restaurant_EmployeeModel getRestaurant_EmployeeById_Person(Long id_client,  Long id_restaurant);

    Restaurant_EmployeeModel getRestaurant_EmployeeById(Long id_person);
}
