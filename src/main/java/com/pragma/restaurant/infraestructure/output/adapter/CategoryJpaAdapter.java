package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.domain.spi.ICategoryPersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import com.pragma.restaurant.infraestructure.output.mapper.ICategoryEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public CategoryModel saveCategory(@Valid CategoryModel categoryModel) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryEntityMapper.toEntity(categoryModel));
        if(categoryEntity == null) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toCategoryModel(categoryEntity);
    }

    @Override
    public List<CategoryModel> getAllCategory() {
        List<CategoryEntity> entityList = categoryRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toCategoryModelList(entityList);
    }
}
