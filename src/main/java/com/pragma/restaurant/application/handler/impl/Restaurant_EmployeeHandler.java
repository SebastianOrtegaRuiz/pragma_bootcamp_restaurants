package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.Restaurant_EmployeeRequestDto;
import com.pragma.restaurant.application.dto.response.Restaurant_EmployeeResponseDto;
import com.pragma.restaurant.application.handler.IRestaurant_EmployeeHandler;
import com.pragma.restaurant.application.mapper.restaurantemployee.IRestaurant_EmployeeRequestMapper;
import com.pragma.restaurant.application.mapper.restaurantemployee.IRestaurant_EmployeeResponseMapper;
import com.pragma.restaurant.domain.api.IRestaurant_EmployeeServicePort;
import com.pragma.restaurant.domain.model.restaurant_Employee.Restaurant_EmployeeIdModel;
import com.pragma.restaurant.domain.model.restaurant_Employee.Restaurant_EmployeeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Restaurant_EmployeeHandler implements IRestaurant_EmployeeHandler {
    private final IRestaurant_EmployeeServicePort restaurant_employeeServicePort;
    private final IRestaurant_EmployeeRequestMapper restaurant_employeeRequestMapper;
    private final IRestaurant_EmployeeResponseMapper restaurant_employeeResponseMapper;
    @Override
    public void saveRestaurant_Employee(Restaurant_EmployeeRequestDto restaurant_employeeRequestDto) {
        Restaurant_EmployeeModel restaurant_employeeModel = restaurant_employeeRequestMapper.toRestaurant_Employee(restaurant_employeeRequestDto);
        restaurant_employeeModel.setId(new Restaurant_EmployeeIdModel(restaurant_employeeRequestDto.getId_restaurant(), restaurant_employeeRequestDto.getId_person()));
        restaurant_employeeServicePort.saveRestaurant_Employee(restaurant_employeeModel);
    }

    @Override
    public List<Restaurant_EmployeeResponseDto> getAllRestaurant_Employee() {
        return restaurant_employeeResponseMapper.toResponseList(restaurant_employeeServicePort.getAllRestaurant_Employee());
    }

    @Override
    public Restaurant_EmployeeResponseDto getRestaurant_EmployeeById_Person(Long id_person,  Long id_restaurant) {
        return restaurant_employeeResponseMapper.toResponse(restaurant_employeeServicePort.getRestaurant_EmployeeById_Person(id_person, id_restaurant));
    }

    @Override
    public Restaurant_EmployeeResponseDto getRestaurant_EmployeeById(Long id_person) {
        return restaurant_employeeResponseMapper.toResponse(restaurant_employeeServicePort.getRestaurant_EmployeeById(id_person));
    }

}
