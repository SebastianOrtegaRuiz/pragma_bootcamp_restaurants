package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrdersEntityMapper {

    OrdersEntity toEntity(OrdersModel order);
    OrdersModel toOrdersModel(OrdersEntity ordersEntity);
    List<OrdersModel> toOrdersModelList(List<OrdersEntity> ordersEntityList);

}