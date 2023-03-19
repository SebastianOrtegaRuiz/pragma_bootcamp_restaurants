package com.pragma.restaurant.application.dto.response.feign;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private Long id_rol;

}