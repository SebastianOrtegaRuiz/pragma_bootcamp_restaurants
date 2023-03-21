package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
