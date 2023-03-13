package com.pragma.restaurant.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishesUpdateRequestDto {
    private Long id;
    private String description;
    private int price;
}
