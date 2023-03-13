package com.pragma.restaurant.application.mapper.restaurant;

import com.pragma.restaurant.application.dto.response.RestaurantsResponseDto;
import com.pragma.restaurant.domain.model.RestaurantsModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRestaurantsResponseMapper {
    RestaurantsResponseDto toResponse(RestaurantsModel restaurantsModel);


    List<RestaurantsResponseDto> toResponseList(List<RestaurantsModel> restaurantsModelList);
}
