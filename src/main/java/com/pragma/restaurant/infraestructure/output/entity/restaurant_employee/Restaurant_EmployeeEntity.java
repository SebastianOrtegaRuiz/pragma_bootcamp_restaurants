package com.pragma.restaurant.infraestructure.output.entity.restaurant_employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "restaurant_employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant_EmployeeEntity implements Serializable {

    @EmbeddedId
    @NotNull
    private Restaurant_EmployeeId id;

    @NotNull
    @NotEmpty(message = "Field cannot be empty")
    @Column(nullable = false)
    private String field;

}
