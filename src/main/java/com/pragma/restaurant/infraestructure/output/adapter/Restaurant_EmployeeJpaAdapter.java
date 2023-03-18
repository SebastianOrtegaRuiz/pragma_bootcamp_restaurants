package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.restaurant_Employee.Restaurant_EmployeeModel;
import com.pragma.restaurant.domain.spi.IRestaurant_EmployeePersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.restaurant_employee.Restaurant_EmployeeEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IRestaurant_EmployeeEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IRestaurant_EmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public class Restaurant_EmployeeJpaAdapter implements IRestaurant_EmployeePersistencePort {
    private final IRestaurant_EmployeeRepository restaurant_employeeRepository;
    private final IRestaurant_EmployeeEntityMapper restaurant_employeeEntityMapper;

    @Override
    public Restaurant_EmployeeModel saveRestaurant_Employee(@Valid Restaurant_EmployeeModel restaurant_employeeModel) {
        Restaurant_EmployeeEntity restaurant_employeeEntity = restaurant_employeeRepository.save(restaurant_employeeEntityMapper.toEntity(restaurant_employeeModel));
        if(restaurant_employeeEntity == null) {
            throw new NoDataFoundException();
        }
        return restaurant_employeeEntityMapper.toRestaurant_EmployeeModel(restaurant_employeeEntity);
    }

    @Override
    public List<Restaurant_EmployeeModel> getAllRestaurant_Employee() {
        List<Restaurant_EmployeeEntity> entityList = restaurant_employeeRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restaurant_employeeEntityMapper.toRestaurant_EmployeeModelList(entityList);
    }
}
