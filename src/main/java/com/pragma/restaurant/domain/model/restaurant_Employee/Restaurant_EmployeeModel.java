package com.pragma.restaurant.domain.model.restaurant_Employee;

public class Restaurant_EmployeeModel {
    private Restaurant_EmployeeIdModel id;
    private Long id_restaurant;
    private Long id_person;
    private String field;

    public Restaurant_EmployeeModel(Long id_restaurant, Long id_person, String field, Restaurant_EmployeeIdModel id) {
        this.id_restaurant = id_restaurant;
        this.id_person = id_person;
        this.field = field;
        this.id = id;
    }

    public Long getId_restaurant() {
        return id_restaurant;
    }

    public Long getId_person() {
        return id_person;
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
