package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.CategoryModel;
import org.springframework.data.domain.Page;

public interface ICategoryServicePort {
    void saveCategory(CategoryModel categoryModel);

    Page<CategoryModel> getAllCategory(int page, int records);

}
