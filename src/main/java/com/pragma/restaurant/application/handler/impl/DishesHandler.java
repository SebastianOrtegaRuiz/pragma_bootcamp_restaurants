package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.DishesRequestDto;
import com.pragma.restaurant.application.dto.response.DishesResponseDto;
import com.pragma.restaurant.application.handler.IDishesHandler;
import com.pragma.restaurant.application.mapper.dishes.IDishesRequestMapper;
import com.pragma.restaurant.application.mapper.dishes.IDishesResponseMapper;
import com.pragma.restaurant.domain.api.IDishesServicePort;
import com.pragma.restaurant.domain.model.DishesModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DishesHandler implements IDishesHandler {

    private final IDishesServicePort dishesServicePort;
    private final IDishesRequestMapper dishesRequestMapper;
    private final IDishesResponseMapper dishesResponseMapper;
    @Override
    public void saveDishes(DishesRequestDto dishesRequestDto) {
        DishesModel dishesModel = dishesRequestMapper.toDishes(dishesRequestDto);
        dishesServicePort.saveDishes(dishesModel);
    }

    @Override
    public List<DishesResponseDto> getAllDishes() {
        return dishesResponseMapper.toResponseList(dishesServicePort.getAllDishes());
    }
}
