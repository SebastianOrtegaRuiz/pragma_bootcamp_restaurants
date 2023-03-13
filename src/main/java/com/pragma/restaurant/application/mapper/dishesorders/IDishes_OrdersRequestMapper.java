package com.pragma.restaurant.application.mapper.dishesorders;

import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import com.pragma.restaurant.domain.model.Dishes_OrdersModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDishes_OrdersRequestMapper {
    Dishes_OrdersModel toDishes_Orders(Dishes_OrdersRequestDto dishes_ordersRequestDto);
}
