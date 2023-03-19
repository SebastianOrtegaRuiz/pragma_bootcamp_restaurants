package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.infraestructure.output.entity.dishes_orders.Dishes_OrdersEntity;
import com.pragma.restaurant.infraestructure.output.entity.dishes_orders.Dishes_OrdersId;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDishes_OrdersRepository extends JpaRepository<Dishes_OrdersEntity, Dishes_OrdersId> {

}
