package com.pragma.restaurant.application.mapper.dishes;

import com.pragma.restaurant.application.dto.request.DishesRequestDto;
import com.pragma.restaurant.application.dto.request.DishesUpdateRequestDto;
import com.pragma.restaurant.domain.model.DishesModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDishesRequestMapper {

    DishesModel toDishes(DishesRequestDto dishesRequestDto);

   // DishesModel toDishesUpdate(DishesUpdateRequestDto dishesUpdateRequestDto);
}
