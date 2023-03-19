package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.dishes.DishesRequestDto;
import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.domain.model.DishesModel;

import java.util.List;

public interface IDishesHandler {
    void saveDishes(DishesRequestDto dishesRequestDto);

    void updateDishes(DishesResponseDto dishesResponseDto);

    void changeStatusDishes(DishesResponseDto dishesResponseDto);

    List<DishesResponseDto> getAllDishes();

    DishesResponseDto getDishesById(Long id);

    UserResponseDto getUser(Long id, String autorization);

    UserResponseDto getUserByEmail(String email, String autorization);
}
