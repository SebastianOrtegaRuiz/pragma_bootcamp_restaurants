package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import com.pragma.restaurant.infraestructure.output.repository.orders.IOrdersRepository;
import com.pragma.restaurant.infraestructure.output.repository.orders.IOrdersResponseRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrdersEntityMapper {

    OrdersEntity toEntity(OrdersModel order);
    OrdersModel toOrdersModel(OrdersEntity ordersEntity);

    OrdersModel toOrdersPageModel(IOrdersResponseRepository resp);

    List<OrdersModel> toOrdersModelList(List<OrdersEntity> ordersEntityList);

    List<OrdersModel> toOrdersModeResplList(List<IOrdersResponseRepository> ordersEntityList);

}
