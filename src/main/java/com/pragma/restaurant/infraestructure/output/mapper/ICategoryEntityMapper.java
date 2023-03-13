package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring"
)
public interface ICategoryEntityMapper {
    CategoryEntity toEntity(CategoryModel category);
    CategoryModel toCategoryModel(CategoryEntity categoryEntity);
    List<CategoryModel> toCategoryModelList(List<CategoryEntity> categoryEntityList);
}
