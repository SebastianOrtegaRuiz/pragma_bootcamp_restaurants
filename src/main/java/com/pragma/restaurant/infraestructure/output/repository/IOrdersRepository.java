package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<OrdersEntity, Long> {
}
