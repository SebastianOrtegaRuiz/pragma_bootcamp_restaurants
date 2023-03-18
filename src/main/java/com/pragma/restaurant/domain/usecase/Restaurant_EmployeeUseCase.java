package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.api.IRestaurant_EmployeeServicePort;
import com.pragma.restaurant.domain.model.restaurant_Employee.Restaurant_EmployeeModel;
import com.pragma.restaurant.domain.spi.IRestaurant_EmployeePersistencePort;

import java.util.List;

public class Restaurant_EmployeeUseCase implements IRestaurant_EmployeeServicePort {

    private final IRestaurant_EmployeePersistencePort restaurant_employeePersistencePort;

    public Restaurant_EmployeeUseCase(IRestaurant_EmployeePersistencePort restaurant_employeePersistencePort) {
        this.restaurant_employeePersistencePort = restaurant_employeePersistencePort;
    }

    @Override
    public void saveRestaurant_Employee(Restaurant_EmployeeModel restaurant_employeeModel) {
        restaurant_employeePersistencePort.saveRestaurant_Employee(restaurant_employeeModel);
    }

    @Override
    public List<Restaurant_EmployeeModel> getAllRestaurant_Employee() {
        return restaurant_employeePersistencePort.getAllRestaurant_Employee();
    }
}
