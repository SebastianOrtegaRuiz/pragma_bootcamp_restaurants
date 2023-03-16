package com.pragma.restaurant.application.dto.response;

import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
    private List<DishesResponseDto> dishesResponseDto;
}
