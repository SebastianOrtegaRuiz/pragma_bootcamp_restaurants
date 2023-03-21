package com.pragma.restaurant.domain.spi;

import com.pragma.restaurant.domain.model.CategoryModel;
import org.springframework.data.domain.Page;

public interface ICategoryPersistencePort {
    CategoryModel saveCategory(CategoryModel categoryModel);

    Page<CategoryModel> getAllCategory(int page, int records);

}
