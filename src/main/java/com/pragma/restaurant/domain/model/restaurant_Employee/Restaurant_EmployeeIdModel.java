package com.pragma.restaurant.domain.model.restaurant_Employee;

public class Restaurant_EmployeeIdModel {

    private Long id_restaurant;
    private Long id_person;

    public Restaurant_EmployeeIdModel(Long id_restaurant, Long id_person) {
        this.id_restaurant = id_restaurant;
        this.id_person = id_person;
    }

    public Long getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(Long id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }


}
