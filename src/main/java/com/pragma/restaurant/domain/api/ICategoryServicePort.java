package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.CategoryByRestaurantsModel;
import com.pragma.restaurant.domain.model.CategoryModel;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface ICategoryServicePort {
    void saveCategory(CategoryModel categoryModel);

    Page<CategoryModel> getAllCategory(int page, int records);

    Page<CategoryByRestaurantsModel> getAllCategoryByRestaurant();
}
