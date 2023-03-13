package com.pragma.restaurant.infraestructure.output.entity.restaurant_employee;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class Restaurant_EmployeeId implements Serializable {
    private Long id_restaurant;
    private Long id_person;
}
