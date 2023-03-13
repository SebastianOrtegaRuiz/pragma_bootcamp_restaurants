package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.application.handler.IOrdersHandler;
import com.pragma.restaurant.application.mapper.orders.IOrdersRequestMapper;
import com.pragma.restaurant.application.mapper.orders.IOrdersResponseMapper;
import com.pragma.restaurant.domain.api.IOrdersServicePort;
import com.pragma.restaurant.domain.model.OrdersModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrdersHandler implements IOrdersHandler {

    private final IOrdersServicePort OrdersServicePort;
    private final IOrdersRequestMapper OrdersRequestMapper;
    private final IOrdersResponseMapper OrdersResponseMapper;
    @Override
    public void saveOrders(OrdersRequestDto OrdersRequestDto) {
        OrdersModel OrdersModel = OrdersRequestMapper.toOrders(OrdersRequestDto);
        OrdersServicePort.saveOrders(OrdersModel);
    }

    @Override
    public List<OrdersResponseDto> getAllOrders() {
        return OrdersResponseMapper.toResponseList(OrdersServicePort.getAllOrders());
    }
}
