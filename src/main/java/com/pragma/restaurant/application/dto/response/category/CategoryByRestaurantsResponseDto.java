package com.pragma.restaurant.application.dto.response.category;

import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryByRestaurantsResponseDto {
    private String name;
    private String description;
    private String dischesname;
}
