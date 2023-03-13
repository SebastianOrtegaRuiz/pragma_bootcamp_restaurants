package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.DishesRequestDto;
import com.pragma.restaurant.application.dto.response.DishesResponseDto;

import java.util.List;

public interface IDishesHandler {
    void saveDishes(DishesRequestDto dishesRequestDto);

    List<DishesResponseDto> getAllDishes();
}
