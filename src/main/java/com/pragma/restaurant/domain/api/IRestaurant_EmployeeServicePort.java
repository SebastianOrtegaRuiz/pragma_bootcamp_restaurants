package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.Restaurant_EmployeeModel;

import java.util.List;

public interface IRestaurant_EmployeeServicePort {
    void saveRestaurant_Employee(Restaurant_EmployeeModel restaurant_employeeModel);

    List<Restaurant_EmployeeModel> getAllRestaurant_Employee();
}
