package com.pragma.restaurant.application.mapper.orders;

import com.pragma.restaurant.application.dto.request.orders.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.domain.model.OrdersModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrdersRequestMapper {
    OrdersModel toOrders(OrdersRequestDto ordersRequestDto);

    OrdersModel toOrdersUpdate(OrdersResponseDto ordersResponseDto);

}
