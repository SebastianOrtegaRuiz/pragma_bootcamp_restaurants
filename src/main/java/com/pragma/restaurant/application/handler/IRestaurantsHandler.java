package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.RestaurantsRequestDto;
import com.pragma.restaurant.application.dto.response.RestaurantsResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRestaurantsHandler {
    void saveRestaurants(RestaurantsRequestDto restaurantsRequestDto);

    Page<RestaurantsResponseDto> getAllRestaurants(int pages, int records);
}
