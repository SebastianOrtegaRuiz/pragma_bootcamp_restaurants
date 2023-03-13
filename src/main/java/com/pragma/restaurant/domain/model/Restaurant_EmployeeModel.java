package com.pragma.restaurant.domain.model;

public class Restaurant_EmployeeModel {

    private Long id_restaurant;
    private Long id_person;
    private String field;

    public Restaurant_EmployeeModel(Long id_restaurant, Long id_person, String field) {
        this.id_restaurant = id_restaurant;
        this.id_person = id_person;
        this.field = field;
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
}
