package com.pragma.restaurant.application.mapper.dishes;

import com.pragma.restaurant.application.dto.response.DishesResponseDto;
import com.pragma.restaurant.domain.model.DishesModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishesResponseMapper {
    DishesResponseDto toResponse(DishesModel dishesModel);

    List<DishesResponseDto> toResponseList(List<DishesModel> dishesModelList);
}
