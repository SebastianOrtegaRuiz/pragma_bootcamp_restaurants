package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.dishes_orders.Dishes_OrdersEntity;
import com.pragma.restaurant.infraestructure.output.entity.dishes_orders.Dishes_OrdersId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishes_OrdersRepository extends JpaRepository<Dishes_OrdersEntity, Dishes_OrdersId> {

}
