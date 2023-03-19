package com.pragma.restaurant.infraestructure.output.entity.restaurant_employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant_EmployeeId implements Serializable {
    private Long id_restaurant;
    private Long id_person;
}
