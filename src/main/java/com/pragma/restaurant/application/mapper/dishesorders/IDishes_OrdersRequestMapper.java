package com.pragma.restaurant.application.mapper.dishesorders;

import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import com.pragma.restaurant.domain.model.dishes_order.Dishes_OrdersModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishes_OrdersRequestMapper {
    List<Dishes_OrdersModel> toDishes_Orders(List<Dishes_OrdersRequestDto> dishes_ordersRequestDto);
}
