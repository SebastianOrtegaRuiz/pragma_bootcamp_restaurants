package com.pragma.restaurant.application.mapper.dishes;

import com.pragma.restaurant.application.dto.request.dishes.DishesUpdateRequestDto;
import com.pragma.restaurant.domain.model.DishesModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDishesUpdateRequestMapper {

    DishesModel toDishes(DishesUpdateRequestDto dishesUpdateRequestDto);
}
