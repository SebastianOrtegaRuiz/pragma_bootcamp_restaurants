package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import com.pragma.restaurant.infraestructure.output.repository.IOrdersRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrdersEntityMapper {

    OrdersEntity toEntity(OrdersModel order);
    OrdersModel toOrdersModel(OrdersEntity ordersEntity);

    OrdersModel toOrdersPageModel(IOrdersRepository.Resp resp);

    List<OrdersModel> toOrdersModelList(List<OrdersEntity> ordersEntityList);

    List<OrdersModel> toOrdersModeResplList(List<IOrdersRepository.Resp> ordersEntityList);

}
