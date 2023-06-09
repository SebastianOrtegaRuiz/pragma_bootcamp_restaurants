package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.api.ICategoryServicePort;
import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.domain.spi.ICategoryPersistencePort;
import org.springframework.data.domain.Page;

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
    public Page<CategoryModel> getAllCategory(int page, int records) {
        return categoryPersistencePort.getAllCategory(page, records);
    }

}
