package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.api.ICategoryServicePort;
import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryModel> getAllCategory() {
        return categoryPersistencePort.getAllCategory();
    }
}
