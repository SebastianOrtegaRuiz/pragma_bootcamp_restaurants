package com.pragma.restaurant.application.mapper.restaurant;

import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsOwnerResponseDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsResponseDto;
import com.pragma.restaurant.domain.model.RestaurantsModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRestaurantsResponseMapper {
    RestaurantsResponseDto toResponse(RestaurantsModel restaurantsModel);
    RestaurantsOwnerResponseDto toResponseOwner(RestaurantsModel restaurantsModel);

    List<RestaurantsResponseDto> toResponseList(List<RestaurantsModel> restaurantsModelList);
}
