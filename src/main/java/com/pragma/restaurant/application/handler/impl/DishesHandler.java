package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.dishes.DishesRequestDto;
import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.application.handler.IDishesHandler;
import com.pragma.restaurant.application.mapper.dishes.IDishesRequestMapper;
import com.pragma.restaurant.application.mapper.dishes.IDishesResponseMapper;
import com.pragma.restaurant.application.mapper.feign.IUserFeignClient;
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

    private final IUserFeignClient userFeignClient;
    @Override
    public void saveDishes(DishesRequestDto dishesRequestDto) {
        DishesModel dishesModel = dishesRequestMapper.toDishes(dishesRequestDto);
        dishesServicePort.saveDishes(dishesModel);
    }

    @Override
    public void updateDishes(DishesResponseDto dishesResponseDto) {
        DishesModel dishesModel = dishesRequestMapper.toDishesUpdate(dishesResponseDto);
        dishesServicePort.updateDishes(dishesModel);
    }

    @Override
    public void changeStatusDishes(DishesResponseDto dishesResponseDto) {
        DishesModel dishesModel = dishesRequestMapper.toDishesUpdate(dishesResponseDto);
        dishesServicePort.updateDishes(dishesModel);
    }

    @Override
    public List<DishesResponseDto> getAllDishes() {
        return dishesResponseMapper.toResponseList(dishesServicePort.getAllDishes());
    }

    @Override
    public DishesResponseDto getDishesById(Long id) {
        return dishesResponseMapper.toResponse(dishesServicePort.getDishesById(id));
    }

    @Override
    public UserResponseDto getUser(Long id, String autorization) {
        return userFeignClient.getUser(id, autorization);
    }

    @Override
    public UserResponseDto getUserByEmail(String email, String autorization) {
        return userFeignClient.getUserByEmail(email, autorization);
    }
}
