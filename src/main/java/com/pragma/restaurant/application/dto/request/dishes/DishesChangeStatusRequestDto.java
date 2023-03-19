package com.pragma.restaurant.application.dto.request.dishes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishesChangeStatusRequestDto {

    private Long id;
    private Boolean active;
}
