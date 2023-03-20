package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.request.OrdersUpdateRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.domain.model.OrdersModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrdersHandler {
    OrdersResponseDto saveOrders(OrdersRequestDto ordersRequestDto);

    OrdersResponseDto updateOrders(OrdersUpdateRequestDto ordersUpdateRequestDto);

    Page<OrdersResponseDto> getAllOrders(int pages, int records, String status);

    List<OrdersResponseDto> getOrdersByClientAndStatus(Long id);

    OrdersResponseDto getOrdersById(Long id);

}

