package com.pragma.restaurant.application.mapper.orders;

import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.request.OrdersUpdateRequestDto;
import com.pragma.restaurant.domain.model.OrdersModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrdersRequestMapper {
    OrdersModel toOrders(OrdersRequestDto ordersRequestDto);

    OrdersModel toOrdersUpdate(OrdersUpdateRequestDto ordersUpdateRequestDto);
}
