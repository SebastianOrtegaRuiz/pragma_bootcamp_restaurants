package com.pragma.restaurant.application.mapper.restaurantemployee;

import com.pragma.restaurant.application.dto.request.Restaurant_EmployeeRequestDto;
import com.pragma.restaurant.domain.model.restaurant_Employee.Restaurant_EmployeeModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRestaurant_EmployeeRequestMapper {
    Restaurant_EmployeeModel toRestaurant_Employee(Restaurant_EmployeeRequestDto restaurant_employeeRequestDto);
}
