package com.pragma.restaurant.application.dto.request.feign;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequestDto {
    private String name;
    private String last_name;
    private int identity_card;
    private String cellphone;
    private String email;
    private String password;
    private Long id_rol;
}
