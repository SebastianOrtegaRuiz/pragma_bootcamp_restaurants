package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.orders.OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.application.handler.IOrdersHandler;
import com.pragma.restaurant.application.mapper.orders.IOrdersRequestMapper;
import com.pragma.restaurant.application.mapper.orders.IOrdersResponseMapper;
import com.pragma.restaurant.domain.api.IOrdersServicePort;
import com.pragma.restaurant.domain.model.OrdersModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrdersHandler implements IOrdersHandler {

    private final IOrdersServicePort ordersServicePort;
    private final IOrdersRequestMapper ordersRequestMapper;
    private final IOrdersResponseMapper ordersResponseMapper;
    @Override
    public OrdersResponseDto saveOrders(OrdersRequestDto OrdersRequestDto) {
        OrdersModel OrdersModel = ordersRequestMapper.toOrders(OrdersRequestDto);
        return ordersResponseMapper.toResponse(ordersServicePort.saveOrders(OrdersModel));
    }

    @Override
    public OrdersResponseDto updateOrders(OrdersResponseDto ordersResponseDto) {
        OrdersModel OrdersModel = ordersRequestMapper.toOrdersUpdate(ordersResponseDto);
        return ordersResponseMapper.toResponse(ordersServicePort.updateOrders(OrdersModel));
    }

    @Override
    public Page<OrdersResponseDto> getAllOrders(int pages, int records, String status) {
        return ordersServicePort.getAllOrders(pages, records, status).map(ordersResponseMapper::toResponse);
    }

    @Override
    public List<OrdersResponseDto> getOrdersByClientAndStatus(Long id) {
        return ordersResponseMapper.toResponseList(ordersServicePort.getOrdersByClientAndStatus(id));
    }

    @Override
    public OrdersResponseDto getOrdersById(Long id) {
        return ordersResponseMapper.toResponse(ordersServicePort.getOrdersById(id));
    }


}
