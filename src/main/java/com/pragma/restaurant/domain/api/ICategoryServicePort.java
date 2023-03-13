package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryServicePort {
    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getAllCategory();
}
