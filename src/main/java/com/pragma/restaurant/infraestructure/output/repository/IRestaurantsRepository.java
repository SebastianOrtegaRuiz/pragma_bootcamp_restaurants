package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.RestaurantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantsRepository extends JpaRepository<RestaurantsEntity, Long> {
}
