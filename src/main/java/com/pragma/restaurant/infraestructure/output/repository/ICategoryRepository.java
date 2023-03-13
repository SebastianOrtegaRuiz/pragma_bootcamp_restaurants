package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
