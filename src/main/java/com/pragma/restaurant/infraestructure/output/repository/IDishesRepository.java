package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.DishesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishesRepository extends JpaRepository<DishesEntity, Long> {
}
