package com.pragma.restaurant.domain.model.restaurant_Employee;

public class Restaurant_EmployeeModel {
    private Restaurant_EmployeeIdModel id;
    private String field;

    public Restaurant_EmployeeModel(String field, Restaurant_EmployeeIdModel id) {
        this.field = field;
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public Restaurant_EmployeeIdModel getId() {
        return id;
    }

    public void setId(Restaurant_EmployeeIdModel id) {
        this.id = id;
    }
}
