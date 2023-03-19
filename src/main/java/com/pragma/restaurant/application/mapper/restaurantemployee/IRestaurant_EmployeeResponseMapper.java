package com.pragma.restaurant.application.mapper.restaurantemployee;

import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;
import com.pragma.restaurant.domain.model.restaurant_Employee.Restaurant_EmployeeModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRestaurant_EmployeeResponseMapper {

    Restaurant_EmployeeResponseDto toResponse(Restaurant_EmployeeModel restaurant_employeeModel);

    List<Restaurant_EmployeeResponseDto> toResponseList(List<Restaurant_EmployeeModel> restaurant_employeeModelList);
}
