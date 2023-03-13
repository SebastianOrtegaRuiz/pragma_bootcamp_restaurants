package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.Restaurant_EmployeeModel;
import com.pragma.restaurant.infraestructure.output.entity.restaurant_employee.Restaurant_EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring"
)
public interface IRestaurant_EmployeeEntityMapper {
    Restaurant_EmployeeEntity toEntity(Restaurant_EmployeeModel restaurant_employee);
    Restaurant_EmployeeModel toRestaurant_EmployeeModel(Restaurant_EmployeeEntity restaurant_employeeEntity);
    List<Restaurant_EmployeeModel> toRestaurant_EmployeeModelList(List<Restaurant_EmployeeEntity> restaurant_employeeEntityList);
}
