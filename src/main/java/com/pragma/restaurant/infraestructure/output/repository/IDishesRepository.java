package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.application.dto.response.dishes.DishesResponseDto;
import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.infraestructure.output.entity.DishesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDishesRepository extends JpaRepository<DishesEntity, Long> {

    @Query(value="SELECT c.name, c.description, d.id, d.name, d.description, d.price, d.url_image FROM dishes WHERE id = :id", nativeQuery = true)
    List<DishesEntity> findAllDishesById(Long id);

}
