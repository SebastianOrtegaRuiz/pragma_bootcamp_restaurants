package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.RestaurantsRequestDto;
import com.pragma.restaurant.application.dto.request.UsersRequestDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsResponseDto;
import com.pragma.restaurant.application.dto.response.feign.UserResponseDto;
import org.springframework.data.domain.Page;

public interface IRestaurantsHandler {
    void saveRestaurants(RestaurantsRequestDto restaurantsRequestDto);

    Page<RestaurantsResponseDto> getAllRestaurants(int pages, int records);

    RestaurantsResponseDto getRestaurantsById(Long id);

    RestaurantsOwnerResponseDto getRestaurantsOwnerById(Long id);

    UserResponseDto getUser(Long id, String autorization);

    UserResponseDto saveUser(UsersRequestDto usersRequestDto, String autorization);
}
