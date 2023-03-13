package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.domain.spi.IOrdersPersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IOrdersEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IOrdersRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public class OrdersJpaAdapter implements IOrdersPersistencePort {
    private final IOrdersRepository ordersRepository;
    private final IOrdersEntityMapper ordersEntityMapper;

    @Override
    public OrdersModel saveOrders(@Valid OrdersModel ordersModel) {
        OrdersEntity ordersEntity = ordersRepository.save(ordersEntityMapper.toEntity(ordersModel));
        if(ordersEntity == null) {
            throw new NoDataFoundException();
        }
        return ordersEntityMapper.toOrdersModel(ordersEntity);
    }

    @Override
    public List<OrdersModel> getAllOrders() {
        List<OrdersEntity> entityList = ordersRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return ordersEntityMapper.toOrdersModelList(entityList);
    }
}
