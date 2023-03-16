package com.pragma.restaurant.application.dto.response.restaurants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantsOwnerResponseDto {
    private String name;
    private String url_logo;
    private Long id_owner;
}
