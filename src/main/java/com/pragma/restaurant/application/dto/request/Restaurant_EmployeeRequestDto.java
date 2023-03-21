package com.pragma.restaurant.application.dto.request;

import com.pragma.restaurant.application.dto.request.feign.UsersRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restaurant_EmployeeRequestDto {
    private Long id_restaurant;
    private Long id_person;
    private String field;
    private UsersRequestDto usersRequestDto;
}
