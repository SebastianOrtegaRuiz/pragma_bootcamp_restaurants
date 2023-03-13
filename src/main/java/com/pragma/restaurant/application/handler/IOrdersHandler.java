package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;

import java.util.List;

public interface IOrdersHandler {
    void saveOrders(OrdersRequestDto ordersRequestDto);

    List<OrdersResponseDto> getAllOrders();
}
