package com.pragma.restaurant.application.dto.response.dishes;

import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishesResponseDto {
    private Long id;
    private String name;
    private Long id_category;
    private String description;
    private int price;
    private Long id_restaurant;
    private String url_image;
    private Boolean active;
    private RestaurantsOwnerResponseDto restaurantsOwnerResponseDto;
}
