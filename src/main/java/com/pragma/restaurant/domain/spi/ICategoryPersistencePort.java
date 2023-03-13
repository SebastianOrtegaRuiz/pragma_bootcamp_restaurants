package com.pragma.restaurant.domain.spi;

import com.pragma.restaurant.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryPersistencePort {
    CategoryModel saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getAllCategory();
}
