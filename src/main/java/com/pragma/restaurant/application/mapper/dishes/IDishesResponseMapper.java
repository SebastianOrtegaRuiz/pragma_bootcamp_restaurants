package com.pragma.restaurant.application.mapper.dishes;

import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import com.pragma.restaurant.domain.model.DishesModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishesResponseMapper {
    @Mapping(target = "restaurantsOwnerResponseDto", source = "restaurantsModel")
    DishesResponseDto toResponse(DishesModel dishesModel);

    List<DishesResponseDto> toResponseList(List<DishesModel> dishesModelList);

}
