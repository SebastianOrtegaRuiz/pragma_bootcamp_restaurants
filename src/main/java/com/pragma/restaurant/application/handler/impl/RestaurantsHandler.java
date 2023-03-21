package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.RestaurantsRequestDto;
import com.pragma.restaurant.application.dto.request.feign.UsersRequestDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import com.pragma.restaurant.application.handler.IRestaurantsHandler;
import com.pragma.restaurant.application.mapper.feign.IUserFeignClient;
import com.pragma.restaurant.application.mapper.restaurant.IRestaurantsRequestMapper;
import com.pragma.restaurant.application.mapper.restaurant.IRestaurantsResponseMapper;
import com.pragma.restaurant.domain.api.IRestaurantsServicePort;
import com.pragma.restaurant.domain.model.RestaurantsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantsHandler implements IRestaurantsHandler {

    private final IRestaurantsServicePort restaurantsServicePort;
    private final IRestaurantsRequestMapper restaurantsRequestMapper;
    private final IRestaurantsResponseMapper restaurantsResponseMapper;
    private final IUserFeignClient userFeignClient;

    @Override
    public void saveRestaurants(RestaurantsRequestDto restaurantsRequestDto) {
        RestaurantsModel restaurantsModel = restaurantsRequestMapper.toRestaurants(restaurantsRequestDto);
        restaurantsServicePort.saveRestaurants(restaurantsModel);
    }

    @Override
    public Page<RestaurantsResponseDto> getAllRestaurants(int pages, int records) {
        return restaurantsServicePort.getAllRestaurants(pages, records).map(restaurantsResponseMapper::toResponse);
    }

    @Override
    public RestaurantsResponseDto getRestaurantsById(Long id) {
        return restaurantsResponseMapper.toResponse(restaurantsServicePort.getRestaurantsById(id));
    }

    @Override
    public RestaurantsOwnerResponseDto getRestaurantsOwnerById(Long id) {
        return restaurantsResponseMapper.toResponseOwner(restaurantsServicePort.getRestaurantsById(id));
    }

    @Override
    public UserResponseDto getUser(Long id, String autorization) {
        return userFeignClient.getUser(id, autorization);
    }

    @Override
    public UserResponseDto saveUser(UsersRequestDto usersRequestDto, String autorization) {
        return userFeignClient.saveUser(usersRequestDto, autorization);
    }
}
