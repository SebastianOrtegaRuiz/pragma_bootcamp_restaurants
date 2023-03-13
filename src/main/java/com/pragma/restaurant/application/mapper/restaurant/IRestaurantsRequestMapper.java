package com.pragma.restaurant.application.mapper.restaurant;

import com.pragma.restaurant.application.dto.request.RestaurantsRequestDto;
import com.pragma.restaurant.domain.model.RestaurantsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRestaurantsRequestMapper {
    RestaurantsModel toRestaurants(RestaurantsRequestDto restaurantsRequestDto);
}
