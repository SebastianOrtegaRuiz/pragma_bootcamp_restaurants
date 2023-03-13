package com.pragma.restaurant.application.mapper.dishesorders;

import com.pragma.restaurant.application.dto.response.Dishes_OrdersResponseDto;
import com.pragma.restaurant.domain.model.Dishes_OrdersModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishes_OrdersResponseMapper {

    Dishes_OrdersResponseDto toResponse(Dishes_OrdersModel dishes_ordersModel);

    List<Dishes_OrdersResponseDto> toResponseList(List<Dishes_OrdersModel> dishes_ordersModelList);
}
