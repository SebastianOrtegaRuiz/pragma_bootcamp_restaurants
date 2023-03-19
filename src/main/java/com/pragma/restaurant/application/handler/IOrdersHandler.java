package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.domain.model.OrdersModel;

import java.util.List;

public interface IOrdersHandler {
    OrdersResponseDto saveOrders(OrdersRequestDto ordersRequestDto);

    List<OrdersResponseDto> getAllOrders();

    List<OrdersResponseDto> getOrdersByClientAndStatus(Long id);
}

