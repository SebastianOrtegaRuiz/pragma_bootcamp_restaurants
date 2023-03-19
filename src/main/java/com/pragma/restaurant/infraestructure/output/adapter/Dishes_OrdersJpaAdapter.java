package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.dishes_order.Dishes_OrdersModel;
import com.pragma.restaurant.domain.spi.IDishes_OrdersPersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.dishes_orders.Dishes_OrdersEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IDishes_OrdersEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IDishes_OrdersRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public class Dishes_OrdersJpaAdapter implements IDishes_OrdersPersistencePort {
    private final IDishes_OrdersRepository dishes_ordersRepository;
    private final IDishes_OrdersEntityMapper dishes_ordersEntityMapper;

    @Override
    public List<Dishes_OrdersModel> saveDishes_Orders(@Valid List<Dishes_OrdersModel> dishes_ordersModel) {
        List<Dishes_OrdersEntity> dishes_ordersEntity = dishes_ordersRepository.saveAll(dishes_ordersEntityMapper.toEntity(dishes_ordersModel));
        if(dishes_ordersEntity == null) {
            throw new NoDataFoundException();
        }
        return dishes_ordersEntityMapper.toDishes_OrdersModel(dishes_ordersEntity);
    }

    @Override
    public List<Dishes_OrdersModel> getAllDishes_Orders() {
        List<Dishes_OrdersEntity> entityList = dishes_ordersRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return dishes_ordersEntityMapper.toDishes_OrdersModelList(entityList);
    }
}
