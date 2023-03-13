package com.pragma.restaurant.application.mapper.orders;

import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.domain.model.OrdersModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrdersResponseMapper {
    OrdersResponseDto toResponse(OrdersModel ordersModel);

    List<OrdersResponseDto> toResponseList(List<OrdersModel> ordersModelList);
}
