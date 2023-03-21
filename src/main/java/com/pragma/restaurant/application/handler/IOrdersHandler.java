package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.orders.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrdersHandler {
    OrdersResponseDto saveOrders(OrdersRequestDto ordersRequestDto);

    OrdersResponseDto updateOrders(OrdersResponseDto ordersResponseDto);

    Page<OrdersResponseDto> getAllOrders(int pages, int records, String status);

    List<OrdersResponseDto> getOrdersByClientAndStatus(Long id);

    OrdersResponseDto getOrdersById(Long id);

}

