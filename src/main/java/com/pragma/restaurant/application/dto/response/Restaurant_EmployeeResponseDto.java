package com.pragma.restaurant.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restaurant_EmployeeResponseDto {
    private Long id_restaurant;
    private Long id_person;
    private String field;
}
