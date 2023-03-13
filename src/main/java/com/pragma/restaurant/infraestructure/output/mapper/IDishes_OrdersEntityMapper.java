package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.Dishes_OrdersModel;
import com.pragma.restaurant.infraestructure.output.entity.dishes_orders.Dishes_OrdersEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring"
)
public interface IDishes_OrdersEntityMapper {
    Dishes_OrdersEntity toEntity(Dishes_OrdersModel dishes_order);
    Dishes_OrdersModel toDishes_OrdersModel(Dishes_OrdersEntity dishes_orderEntity);
    List<Dishes_OrdersModel> toDishes_OrdersModelList(List<Dishes_OrdersEntity> dishes_orderEntityList);
}
