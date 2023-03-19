package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.restaurant_employee.Restaurant_EmployeeEntity;
import com.pragma.restaurant.infraestructure.output.entity.restaurant_employee.Restaurant_EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurant_EmployeeRepository extends JpaRepository<Restaurant_EmployeeEntity, Restaurant_EmployeeId> {

}
